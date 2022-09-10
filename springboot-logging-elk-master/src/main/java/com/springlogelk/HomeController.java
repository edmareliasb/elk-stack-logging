package com.springlogelk;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@AllArgsConstructor
@Slf4j
public class HomeController {

    private TransferService transferService;

    @GetMapping("/")
    public String HomePage(){
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("Welcome home Page " + localDateTime);
        return "Welcome to Home page";
    }

    @GetMapping("/logs")
    public String LogsPage(){
        MDC.put("transaction.id", UUID.randomUUID().toString());
        MDC.put("transaction.owner", "user");

        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("This Logs page " + localDateTime);

        transferService.execute(500L);

        MDC.clear();
        return "Welcome to logs page";
    }

    @GetMapping("/warn")
    public String WarnPage(){
        LocalDateTime localDateTime = LocalDateTime.now();
        log.warn("This warn page " + localDateTime);
        return "Welcome to warn page";
    }


    @GetMapping("/er")
    public String ErrorPage(){
        LocalDateTime localDateTime = LocalDateTime.now();
        log.error("This error page " + localDateTime);
        return "Welcome to error page";
    }


}
