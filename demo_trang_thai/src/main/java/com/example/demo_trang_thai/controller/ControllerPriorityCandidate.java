package com.example.demo_trang_thai.controller;

import com.example.demo_trang_thai.model.in.PriorityCandidateIn;
import com.example.demo_trang_thai.services.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/priorityCandidate")
public class ControllerPriorityCandidate {
    @Autowired
    private Services services;
    @GetMapping
    ResponseEntity<?>getPriorityCandidate(){
        return ResponseEntity.status(HttpStatus.OK).body(services.getPriorityCandidate());
    }
    @PutMapping
    ResponseEntity<?>updatePriorityCandidate(
            @RequestBody PriorityCandidateIn priorityCandidateIn
//        @RequestBody Long id_status
    ){
        System.out.println(priorityCandidateIn);
        Long id_candidate1 =1L;
        Long id_status=4L;
        return ResponseEntity.status(HttpStatus.OK).body(services.updatePriorityCandidate(priorityCandidateIn));
    }

}
