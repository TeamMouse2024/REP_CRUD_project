package com.revaluper.rep_crud_project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String defaultPage() {
        return "main";
    }

    @GetMapping("main")
    public void main() {

    }
}
