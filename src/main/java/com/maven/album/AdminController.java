package com.maven.album;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/admin/accounts")
    public String accounts() {
        return "admin/accounts";
    }

    @GetMapping("/admin/producers")
    public String producers() {
        return "admin/producers";
    }

    @GetMapping("/admin/master")
    public String master(Model model) {
        // for now just return the template, no service calls
        return "admin/master";
    }

    @GetMapping("/admin/create-user")
    public String createUser() {
        return "admin/create-user";
    }
}
