package examples.helloboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/boards")
public class BoardsController {
@GetMapping("/")
    public String boardList(){
        return "/views/boards_list";
    }

    public String boardRead(){
        return "/views/boards_read";
    }

    public String boardWriteForm(){
        return "/views/boards_write_form";
    }

    public String boardWrite(){
        return "redirect:/boards";
    }

    public String boardDeleteForm(){
        return "/views/boards_delete_form";
    }

    public String boardDelete(){
        return "redirect:/boards";
    }

    public String boardUpdateForm(){
        return "/views/boards_update_form";
    }

    public String boardUpdate(){
        return "redirect:/boards";
    }

}