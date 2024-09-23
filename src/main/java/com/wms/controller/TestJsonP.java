package com.wms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/jsonp")
public class TestJsonP {

    @GetMapping("/api")
    public void jsonpResponse(@RequestParam("callback") String callback, HttpServletResponse response) throws IOException {
        // 创建要返回的JSON数据
        String jsonData = "{\"name\": \"John\", \"age\": 30}";
        // 设置响应的类型为 application/javascript
        response.setContentType("application/javascript");
        // 拼接 callback 函数并返回
        String jsonpResponse = callback + "(" + jsonData + ");";
        // 将结果写入响应流
        response.getWriter().write(jsonpResponse);
    }
}
