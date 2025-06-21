package com.wms.entity;

import lombok.Data;

@Data
public class SmsBean {

    private String phone_number;

    private String content;

    private String send_time;

    private String dest_code;

    private String sequence_id;
}
