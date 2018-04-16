package examples.helloboard.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path="/users")
public class UserController {
    @GetMapping("/loginform")
    public String loginform(@RequestParam(name = "referer")String referer, ModelMap modelMap){
        modelMap.addAttribute("referer", referer);
        return "loginform";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "id") String id,
                        @RequestParam(name = "passwd") String passwd,
                        @RequestParam(name = "referer", required = false) String referer){
        //그냥 로그인
        if(referer == null || "".equals(referer)){
            return "redirect:/boards";
        }else{
            return "redirect" + referer;
        }
    }
}
