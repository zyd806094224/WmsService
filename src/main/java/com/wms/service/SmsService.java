package com.wms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wms.entity.Sms;

import java.util.List;

public interface SmsService extends IService<Sms> {

//    List<Sms> listAll();
//
//    void insert(Sms sms);

    IPage<Sms> listPaging(IPage<Sms> page);
}
