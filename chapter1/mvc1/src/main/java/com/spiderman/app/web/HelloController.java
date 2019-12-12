package com.spiderman.app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController {

    @RequestMapping("/hello.do")
    public void test(HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello,world");
    }
}