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
@RequestMapping("/function")
public class FunctionController {
    @Autowired
    private FunctionRepository functionRepository;



    @GetMapping("/search")
    public String search(){

        return "function/search";
    }
    @GetMapping("/result")
    public  String result(Model model, @PageableDefault(size=5) Pageable pageable, @RequestParam(required = false, defaultValue = "") String searchData){
        Page<Result> fun_dbs = functionRepository.findByDevContainingOrNameOrInsideContaining(searchData, searchData, searchData, pageable);
        //Page<Result> fun_dbs = functionRepository.findAll(pageable);
        int startPage = Math.max(1, fun_dbs.getPageable().getPageNumber() - 5);
        int endPage = Math.min(fun_dbs.getTotalPages(), fun_dbs.getPageable().getPageNumber() + 5);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        model.addAttribute("fun_dbs", fun_dbs);
        return "function/result";

    }

}
