package com.myWallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MyWalletApp {
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(MyWalletApp.class, args);
    }

}
