package com.hendisantika.springbootjpamysqlexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-jpa-mysql-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-02
 * Time: 20:35
 */

@RestController
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "Spring Boot JPA MySQL Example! " + new Date();
    }
}
