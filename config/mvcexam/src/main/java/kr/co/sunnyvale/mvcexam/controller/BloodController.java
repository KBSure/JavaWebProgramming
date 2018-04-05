package kr.co.sunnyvale.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class BloodController {

    @GetMapping(path="/bloodform")
    public String bloodForm (){
        return "bloodForm";
    }

    @PostMapping(path="/blood")
    public String bloodResult (@RequestParam(name="name", required = true) String name,
                               @RequestParam(name="bloodType", required = true) String bloodType, ModelMap modelMap){
//        try {
//            request.setCharacterEncoding("UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        modelMap.addAttribute("name", name);
        modelMap.addAttribute("bloodType", bloodType);

        String msg = null;
        if("A".equals(bloodType)){
            msg = "소심합니다.";
        }else if("B".equals(bloodType)){
            msg = "할말을 다합니다.";
        }else if("O".equals(bloodType)) {
            msg = "둥글둥글합니다";
        }else if("AB".equals(bloodType)){
            msg = "알수 없습니다";
        }

        modelMap.addAttribute("msg", msg);
        return "bloodResult";
    }

//    @PostMapping
//    public String
}
