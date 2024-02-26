package com.revaluper.rep_crud_project.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class MainController {

    @GetMapping("/")
    public String defaultPage() {
        return "main";
    }

    @GetMapping("main")
    public void main() {}


}
