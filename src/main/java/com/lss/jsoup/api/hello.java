package com.lss.jsoup.api;

import com.lss.jsoup.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class hello {

    @GetMapping("/api/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/api/login")
    public String login(@RequestBody User user) {
        if (user.getEmail() == "123@123" && user.getPassword() == "123") {
            return  "ok";
        }
        return "no";

    }
}
