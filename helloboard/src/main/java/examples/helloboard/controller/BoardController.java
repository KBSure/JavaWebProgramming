package examples.helloboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Calendar;
import java.util.UUID;

@Controller
@RequestMapping(value = "/boards")
public class BoardController {

    // http://localhost:8080/boards?page=2&searchType=content&searchStr=java
    @GetMapping
    public String boards(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                          @RequestParam(name = "searchType", required = false, defaultValue = "title") String searchType,
                          @RequestParam(name = "searchStr", required = false, defaultValue = "") String searchStr,
                          ModelMap modelMap
                          ){
        System.out.println("page :" + page);
        System.out.println("searchType :" + searchType);
        System.out.println("searchStr :" + searchStr);

        //TODO
        // searchType(title, content, titleAndContent), searchStr 이 있을 경우
        // 1. 검색된 결과의 총 수
        // 2. 한페이지에 보여줄 수
        // 1,2를 이용하여 페이징 처리에 해당하는 값을 구할 수 있다. 만약 전체가 97페이지면?
        // <<    <     1     2     3    4   5  >  >>    > 를 누르면 6페이지를 보여준다.
        // <<    <     6     7     8    9   10  >  >>
        // <<    <    96    97                  >  >>
        // 3. page에 해당하는 검색 결과 목록
        // searchType, searchStr 이 없을 경우
        return "boards_list";
    }

    @GetMapping("/{boardId}")
    public String boardRead(@PathVariable(value = "boardId")Long boardId,
                            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                            @RequestParam(name = "searchType", required = false, defaultValue = "title") String searchType,
                            @RequestParam(name = "searchStr", required = false, defaultValue = "") String searchStr,
                            ModelMap modelMap){
        System.out.println("boardId : " + boardId);
        // 1. boardId에 해당하는 게시물을 한건 읽어온다.
        // 2. boardId의 이전 글, boardId의 이후 글. (검색어도 신경써라!!!)
        //    이전글 : 100보다 작으면서 가장 큰 boardId
        //    이후글 : 100보다 크면서 가장 작은 boardId
        return "boards_read";
    }

    @GetMapping("/writeform")
    public String boardWriteForm(){
        return "boards_writeform";
    }

    @PostMapping("/write")
    public String boardWrite(
            @RequestParam(name = "title") String title,
            @RequestParam("file") MultipartFile file
    ){

        System.out.println(title);
        System.out.println(file.getContentType());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        //1. file을 저장할 것이다.

        // 중복된 파일 문제를 해결.
        // 외부에서는 직접 접근하면 안된다. ex> jsp를 업로드 실행할 수 없는 경로 (외부에서 접근하지 못하는 경로)
        // 하나의 폴더에 너무 많은 파일이 저장되면 관리하기 어렵다.
        // /tmp/helloboard 에 저장하도록 한다.
        // /tmp/helloboard/년/월/일/uuid

        // 날짜 가져오기
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);


        // 윈도우의 경우엔 디렉토리 구분자가 \
        // unix계열은 디렉토리 구분자가 /
        // File.separator 를 이용하여 디렉토리를 구분한다.

        StringBuffer sb = new StringBuffer("/tmp/helloboard/");
        sb.append(year);
        sb.append("/");
        sb.append(month);
        sb.append("/");
        sb.append(day);
        sb.append("/");

        String dir = sb.toString();


        //1-1. 디렉토리가 존재하지 않는다면
        // 디렉토리를 만들어준다.
            // 디렉토리는 날짜별로

        File fileObj = new File(dir);
        if(!fileObj.exists()){//디렉토리 존재 안하면
            fileObj.mkdir();
        }

        // 파일 이름 uuid 생성해서 파일 저장


        UUID uuid = UUID.randomUUID();
        String saveFileName = uuid.toString();
        String saveFilePath = dir + saveFileName;


        InputStream in = null;
        OutputStream out = null;
        try {
            in = file.getInputStream();
            out = new FileOutputStream(saveFilePath);
            // 버퍼 만들어서 받아와야지
            byte[] buffer = new byte[1024];
            int readCount = 0;
            while((readCount = in.read(buffer)) != -1){ // 읽어온 게 있으면
                out.write(buffer, 0, readCount); // 파일로 기록하자.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                out.close();
            }catch (IOException e) {
                e.printStackTrace();
            }

        }


        //db 에는 다음과 같은 내용이 저장될 것이다.
        // 게시물 id, 글쓴이 id, title, 내용,
        // 파일 id, 게시물id, 파일의 오리지날이름, 파일의 실제 저장경로, 파일길이, 파일type

        return "redirect:/boards";
    }

    // Download의 경우에는 읽어들인 파일정보를 브라우저에게 출력한다.
    // 파일정보를 response를 이용하여 직접 출력하겠다.
    // @ResponseBody를 붙여주고, HttpServletResponse response를 파라미터로 주입받는다.
    @GetMapping("/download/{fileId}")
    @ResponseBody
    public void download(@PathVariable(name = "fileId")Long fileId,
                         HttpServletResponse response){
        // db에서 fileId를 이용하여 파일정보를 읽어들인다.
        String saveFilePath = "/tmp/helloboard/2018/4/16/96bb7f16-e350-468b-aa53-f94b6ad22ff4";

        String contentType = "image/png";
        long  fileSize = 201951L;
        String fileName = "hello.png";

        // Content-Disposition, Content-Transfer-Encoding 이 있으면 파일이 다운로드된다.
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Type", contentType);
        response.setHeader("Content-Length", "" + fileSize);
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");

        // try - with - resources
        try(
                FileInputStream fis = new FileInputStream(saveFilePath);
                OutputStream out = response.getOutputStream();
        ){
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while((readCount = fis.read(buffer)) != -1){
                out.write(buffer,0,readCount);
            }
        }catch(Exception ex){
            throw new RuntimeException("file Save Error");
        }
    }

    public String boardDeleteForm(){
        return "boards_deleteform";
    }

    @DeleteMapping
    public String boardDelete(){
        return "redirect:/boards";
    }

    @GetMapping("/updateform")
    public String boardUpdateForm(){
        return "boards_update";
    }

    @PutMapping("/update")
    public String boardUpdate(@RequestParam(name = "name") String name){

        System.out.println("name : " + name);
        return "redirect:/boards" + "/id";
    }
}


/*
/boards   boards_list         WEB-INF/views/board_list.jsp                   1page의 목록을 보여준다.
/boards   boards_list         WEB-INF/views/board_list.jsp    page=2         1page의 목록을 보여준다.
/boards   boards_list         WEB-INF/views/board_list.jsp    searchType=title&searchStr=apple         제목에서 apple로 검색한 1page의 목록을 보여준다.
/boards   boards_list         WEB-INF/views/board_list.jsp    page=3&searchType=title&searchStr=apple  제목에서 apple로 검색한      3page의 목록을 보여준다.

/boards/{boardId}   boards_read       WEB-INF/views/boards_read       page=3&searchType=title&searchStr=apple

/boards/writeform   boards_writeform   글쓰기폼이보여진다.         이름, 암호, 제목, 내용
/boards (POST)      boards 리다이렉트     글이 저장되고 리다이렉트된다.

/boards/deleteform/{boardId}  boards_deleteform  암호를 물어보는 폼이 보여진다.
/boards (DELETE)    boards 리다이렉트    글이 삭제되고 리다이렉트된다.             boardId=50&passwd=hello

/boards/updateform/{boardId}  boards_updateform
/boards (PUT)      boards/{boardId} 글이 수정되고 글상세보기로 리다이렉트한다.
 */