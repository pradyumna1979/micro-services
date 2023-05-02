package com.pradyumna.cloud.controller;

import com.pradyumna.cloud.response.FallbackResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class GatewayFallback {

    @GetMapping("/department")
    public FallbackResponse departmentFallback() {
        FallbackResponse a = new FallbackResponse();
        a.setMsgCode(500);
        a.setMsg("Department service is down !!!");
        return a;
    }

    @GetMapping("/employee")
    public FallbackResponse employeeFallback() {
        FallbackResponse a = new FallbackResponse();
        a.setMsgCode(500);
        a.setMsg("employee service is down !!!");
        return a;
    }

    @GetMapping("/organization")
    public FallbackResponse organizationFallback() {
        FallbackResponse a = new FallbackResponse();
        a.setMsgCode(500);
        a.setMsg("organization service is down !!!");
        return a;
    }

}
