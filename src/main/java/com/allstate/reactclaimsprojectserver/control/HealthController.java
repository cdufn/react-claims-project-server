package com.allstate.reactclaimsprojectserver.control;

import org.springframework.web.bind.annotation.GetMapping;

public class HealthController {

    @GetMapping("/api/health")
    public String healthcheck() {
        return "ok";
    }
}
