package lana.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginHandler(@RequestParam(name = "name", required = false, defaultValue = "some user") String name,
                               RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("name",name);
        return "redirect:/chatting";
    }
    @GetMapping("/chatting")
    public String getChatting(@ModelAttribute("name") String name){
        return "msg";
    }
}
