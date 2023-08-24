package outfox.ead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import outfox.ead.LoginFeignClient;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/deliveryPlatform")
public class userController {
    @Autowired
    private LoginFeignClient loginFeignClient;

    @GetMapping("/login")
    public void getLogin() {
        //loginFeignClient.getLogin();
        // 只能使用 异步非阻塞
        CompletableFuture.runAsync(loginFeignClient::getLogin);
        System.out.println("deliveryPlatform Login~~~~~~~~~~~");
    }
}
