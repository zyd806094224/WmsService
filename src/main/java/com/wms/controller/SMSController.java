package com.wms.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.QueryPageParam;
import com.wms.common.Result;
import com.wms.entity.Sms;
import com.wms.entity.SmsBean;
import com.wms.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sms")
public class SMSController {

    @Autowired
    private SmsService smsService;
    @PostMapping("/resMsg")
    public JSONObject resMsg(@RequestBody List<SmsBean> array) {
        try {
            for (SmsBean smsBean : array) {
                Sms sms = new Sms();
                sms.setContent(smsBean.getContent());
                sms.setDestcode(smsBean.getDest_code());
                sms.setPhonenumber(smsBean.getPhone_number());
                sms.setSendtime(smsBean.getSend_time());
                sms.setSequenceid(smsBean.getSequence_id());
                boolean save = smsService.save(sms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", "接收成功");
        return json;
    }


//    @PostMapping("/save")
//    public Result save(@RequestBody Sms sms) {
//        return smsService.save(sms) ? Result.success(sms) : Result.fail();
//    }

    @GetMapping("/list")
    public Result list() {
        List<Sms> list = smsService.list();
        return Result.success(list);
    }

    @PostMapping("/listPaging")
    public Result listPaging(@RequestBody QueryPageParam param) {
        Page<Sms> page = new Page<>();
        page.setCurrent(param.getPageNum());
        page.setSize(param.getPageSize());
        IPage<Sms> result = smsService.listPaging(page);
        return Result.success(result.getRecords(), result.getTotal());
    }

}
