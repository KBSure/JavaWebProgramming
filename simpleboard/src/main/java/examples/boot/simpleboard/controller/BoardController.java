package examples.boot.simpleboard.controller;

import examples.boot.simpleboard.domain.Board;
import examples.boot.simpleboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping
    public String boardList(){
        return "boards/list";
    }

    @GetMapping(path="/{id}")
    public String boardDetail(@PathVariable(name = "id") Long id, ModelMap modelMap){
        Board board = boardService.getBoard(id);

        modelMap.addAttribute("board", board);

        // http://www.baeldung.com/thymeleaf-in-spring-mvc
        // http://cyberx.tistory.com/132
        return "boards/boardDetail";
    }

    @GetMapping(path="/writeform")
    public String boardWriteform(Principal principal){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println("currentPrincipalName : " + currentPrincipalName);
        System.out.println("login user id : " + principal.getName());
        return "boards/writeform";
    }

    @PostMapping
    public String boardWrite(){
        return "redirect:/boards";
    }

    @DeleteMapping
    @ResponseBody
    public String boardDelete(){
        return "{\"success\":\"ok\"}";
    }

    @GetMapping(path="/updateform")
    public String boardUpdateform(){
        return "boards/updateform";
    }

    @PutMapping
    public String boardUpdate(){
        return "redirect:/boards";
    }
}