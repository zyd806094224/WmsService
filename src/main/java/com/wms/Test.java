package com.wms;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static void main(String[] args) {
        String encode = bCryptPasswordEncoder.encode("123456"); //密码明文加密
        String encode2 = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
        System.out.println(encode2);

        System.out.println(bCryptPasswordEncoder.matches("123456", "$2a$10$N7XIb6kj2/MXOeZl61O8fecYnLSud4.oUJd90XwOjtb.hsjyQUfHa"));
        System.out.println(bCryptPasswordEncoder.matches("123456", "$2a$10$DhtWHexZBrMbUnW6wS8knOirvNNuAetY8z0/wVPK8QKyuuDH7eBbW"));
    }
}
