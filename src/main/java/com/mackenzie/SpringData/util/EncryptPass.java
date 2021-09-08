package com.mackenzie.SpringData.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPass {

    public static void main(String[] args) {

        String pass = "654321";
        System.out.println("password: "+ pass);
        System.out.println("password: "+ encriptarPass(pass));
    }

    public static String encriptarPass(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
