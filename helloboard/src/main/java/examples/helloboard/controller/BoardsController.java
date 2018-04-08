package examples.helloboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/boards") //Annotation 문법 공부 필요
public class BoardsController {
    @GetMapping
    public String boardList(@RequestParam(value = "page", required = false, defaultValue = "1")int page,
                            @RequestParam(value = "searchType", required = false, defaultValue = "title")String searchType,
                            @RequestParam(value = "searchStr", required = false, defaultValue = "")String searchStr){
        //항상 db에서 새롭게 끌어오쟈 Repository 이용하던지 해서
        System.out.println("page" + page);
        System.out.println("searchType" + searchType);
        System.out.println("searchStr" + searchStr);
        return "boards_list";
    }

    @GetMapping(value = "/{boardID}")
    public String boardRead(@PathVariable(value = "boardID", required = true)Long boardID,
                            @RequestParam(value = "page", required = false, defaultValue = "1")int page,
                            @RequestParam(value = "searchType", required = false, defaultValue = "title")String searchType,
                            @RequestParam(value = "searchStr", required = false, defaultValue = "")String searchStr){

        System.out.println("boardID" + boardID);
        System.out.println("page" + page);
        System.out.println("searchType" + searchType);
        System.out.println("searchStr" + searchStr);
        // boardID에 따라서, jsp를 동적으로 만들자.
        return "boards_read";
    }

    @GetMapping(value = "/writeform")
    public String boardWriteForm(){
        //
        return "boards_write_form";
    }

    @PostMapping(value = "/write")
    public String boardWrite(){
        //작성한 글을 db에 등록하도록
        return "redirect:/boards";
    }

    @GetMapping(value = "/deleteform")
    public String boardDeleteForm(){
        return "/boards_delete_form";
    }

    @PostMapping(value = "/delete")
    public String boardDelete(){
        //해당 boardID에 대해서 글 지운다.(파라미터 같이 가지고 와야 함)
        return "redirect:/boards";
    }

    @GetMapping(value = "/updateform")
    public String boardUpdateForm(){
        return "/boards_update_form";
    }

    @PostMapping(value = "/update")
    public String boardUpdate(){
        return "redirect:/boards";
    }

}