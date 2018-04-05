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
    public String bloodResult (@ModelAttribute Blood bloodDTO, ModelMap modelMap){
        String msg = null;
        if("A".equals(bloodDTO.getBloodType())){
            msg = "소심합니다.";
        }else if("B".equals(bloodDTO.getBloodType())){
            msg = "할말을 다합니다.";
        }else if("O".equals(bloodDTO.getBloodType())) {
            msg = "둥글둥글합니다";
        }else if("AB".equals(bloodDTO.getBloodType())){
            msg = "알수 없습니다";
        }
        bloodDTO.setMsg(msg);
        modelMap.addAttribute("blood", bloodDTO);
        return "bloodResult";
    }

//    @PostMapping
//    public String
}
