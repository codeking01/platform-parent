package outfox.ead.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class userController {
    @GetMapping("/login")
    public void getLogin(){
        System.out.println("getLogin！！！！！！！！！！！！！");
    }
}
