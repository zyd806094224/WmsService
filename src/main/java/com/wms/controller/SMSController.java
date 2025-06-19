package com.wms.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms")
public class SMSController {

    @PostMapping("/resMsg")
    public JSONObject resMsg(@RequestBody JSONArray array) {
        // TODO：您需要自行处理上行短信消息内容，此示例只打印回执信息
        System.out.println(array.toJSONString());
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", "接收成功");
        return json;
    }

}
