package com.example.GeoGuessr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "fancy-login";
    }

    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";
    }

}
