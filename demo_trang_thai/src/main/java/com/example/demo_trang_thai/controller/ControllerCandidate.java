package com.example.demo_trang_thai.controller;

import com.example.demo_trang_thai.model.in.CandidateIn;
import com.example.demo_trang_thai.services.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/candidate")
public class ControllerCandidate {
    @Autowired
    private Services services;
    @GetMapping
    ResponseEntity<?> getCandidate(){
        return ResponseEntity.status(HttpStatus.OK).body(services.getCandidate());
    }
    @PostMapping
    ResponseEntity<?> addCandidate(@RequestBody() CandidateIn candidateIn){
        return ResponseEntity.status(HttpStatus.OK).body(services.addCandidate(candidateIn));
    }
    @PutMapping("{id}")
    ResponseEntity<?> updateCandidate(
            @PathVariable()Long id ,
            @RequestBody()CandidateIn candidateIn){
        return ResponseEntity.status(HttpStatus.OK).body(services.updateCandidate(id,candidateIn));
    }
    @DeleteMapping("{id}")
    ResponseEntity<?> deleteCandidate(@PathVariable()Long id){
        return ResponseEntity.status(HttpStatus.OK).body(services.deleteCandidate(id));
    }
}
