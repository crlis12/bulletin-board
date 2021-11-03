package com.project.project.controller;

import com.project.project.model.Result;
import com.project.project.repository.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@RequestMapping("/api")
class FunctionApiController {


    @Autowired
    private FunctionRepository functionRepository;


    @GetMapping("/function")
    List<Result> all(@RequestParam(required = false) String dev) {
        if(StringUtils.isEmpty(dev)){
            return functionRepository.findAll();
        } else {
            return functionRepository.findByDev(dev);
        }

    }
    // end::get-aggregate-root[]

    @PostMapping("/function")
    Result newFunction(@RequestBody Result newFunction) {
        return functionRepository.save(newFunction);
    }

    // Single item

    @GetMapping("/function/{id}")
    //@GetMapping("/function/{dev}")
    //Fun_model one(@PathVariable String dev) {
    Result one(@PathVariable Long id) {
        return functionRepository.findById(id).orElse(null);
        //return repository.findByDev(dev).orElse(null);
    }

    @PutMapping("/function/{id}")
    Result replaceFunction(@RequestBody Result newFunction, @PathVariable Long id) {

        return functionRepository.findById(id)
                .map(Function -> {
                    Function.setPrice(newFunction.getPrice());
                    Function.setShip_fee(newFunction.getShip_fee());
                    return functionRepository.save(Function);
                })
                .orElseGet(() -> {
                    newFunction.setId(id);
                    return functionRepository.save(newFunction);
                });
    }

    @DeleteMapping("/functions/{id}")
    void deleteFunction(@PathVariable Long id) {
        functionRepository.deleteById(id);
    }
}