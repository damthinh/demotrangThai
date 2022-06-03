package com.example.demo_trang_thai.controller;

import com.example.demo_trang_thai.model.in.StatusIn;
import com.example.demo_trang_thai.services.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/status")
public class ControllerStatus {
    @Autowired
    private Services services;
@GetMapping()
    ResponseEntity<?> getStatus(){
    return ResponseEntity.status(HttpStatus.OK).body(services.getStatus());
    }
    @PostMapping
    ResponseEntity<?> addStatus(@RequestBody() StatusIn statusIn){
    return ResponseEntity.status(HttpStatus.OK).body(services.addStatus(statusIn));
    }
    @PutMapping("{id}")
    ResponseEntity<?> updateStatus(
            @RequestBody()StatusIn statusIn,
            @PathVariable()Long id
    ){
        System.out.println("vo controler");
    return ResponseEntity.status(HttpStatus.OK).body(services.updateStatus(id,statusIn));
    }

}
