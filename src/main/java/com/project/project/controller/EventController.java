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
@RequestMapping("/event")
public class EventController {
    //@Autowired
    //private FunctionRepository functionRepository;



    @GetMapping("/slider_1")
    public String slider_1(){

        return "event/slider_1";
    }
    @GetMapping("/slider_2")
    public  String slider_2(){
        return "event/slider_2";
    }
    @GetMapping("/slider_3")
    public  String slider_3(){
        return "event/slider_3";
    }
}
