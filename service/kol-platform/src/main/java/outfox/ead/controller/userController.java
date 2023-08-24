package outfox.ead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import outfox.ead.LoginFeignClient;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/kolPlatform")
public class userController {

    @Autowired
    private LoginFeignClient loginFeignClient;

    @RequestMapping("/kol-platform/login")
    public void getLogin() {
        //loginFeignClient.getLogin();
        System.out.println("kol-platform Login~~~~~~~~~~~");
        //CompletableFuture.supplyAsync(() -> {
        //    loginFeignClient.getLogin();
        //    return null;
        //});
        CompletableFuture.runAsync(loginFeignClient::getLogin);
    }

    @RequestMapping("/kol-platform/loginTest")
    public void loginTest() {
        System.out.println("loginTest");
        loginFeignClient.getLogin();
    }
}
