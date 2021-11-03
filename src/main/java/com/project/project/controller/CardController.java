package com.project.project.controller;


import com.project.project.model.Result;
import com.project.project.repository.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/card")
public class CardController {

    @GetMapping("/page")
    public  String page(@RequestParam(required = false, defaultValue = "") String dev_name){
        return "card/page";
    }
}
