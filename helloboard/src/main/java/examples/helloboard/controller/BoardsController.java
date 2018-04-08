package examples.helloboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/boards") //Annotation 문법 공부 필요
public class BoardsController {
    @GetMapping
    public String boardList(){
        //항상 db에서 새롭게 끌어오쟈 Repository 이용하던지 해서
        return "boards_list";
    }

    @GetMapping(value = "/{boardID}")
    public String boardRead(@PathVariable(value = "boardID")Long boardID){
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

//    public String boardDelete(){
//        return "redirect:/boards";
//    }
//
//    public String boardUpdateForm(){
//        return "/boards_update_form";
//    }
//
//    public String boardUpdate(){
//        return "redirect:/boards";
//    }

}