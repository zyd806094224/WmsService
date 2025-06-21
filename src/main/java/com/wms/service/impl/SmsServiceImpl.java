package com.wms.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wms.entity.Sms;
import com.wms.mapper.SmsMapper;
import com.wms.service.SmsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SmsServiceImpl extends ServiceImpl<SmsMapper, Sms> implements SmsService {

    @Resource
    private SmsMapper smsMapper;


    @Override
    public IPage<Sms> listPaging(IPage<Sms> page) {
        return smsMapper.listPaging(page);
    }
}
