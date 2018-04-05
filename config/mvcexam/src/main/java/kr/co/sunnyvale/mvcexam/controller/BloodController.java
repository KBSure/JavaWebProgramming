package kr.co.sunnyvale.mvcexam.controller;

import kr.co.sunnyvale.mvcexam.dto.Blood;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class BloodController {

    @GetMapping(path="/bloodform")
    public String bloodForm (){
        return "bloodForm";
    }

    @PostMapping(path="/blood")
    public String bloodResult (@ModelAttribute Blood blood){
        return "bloodResult";
    }

//    @PostMapping
//    public String
}
