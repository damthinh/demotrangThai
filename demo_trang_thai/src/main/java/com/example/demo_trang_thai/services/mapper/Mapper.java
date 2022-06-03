package com.example.demo_trang_thai.services.mapper;


import com.example.demo_trang_thai.model.entity.Candidate;
import com.example.demo_trang_thai.model.entity.Status;
import com.example.demo_trang_thai.model.in.CandidateIn;
import com.example.demo_trang_thai.model.in.StatusIn;

public class Mapper {

        public static Candidate candidate (CandidateIn candidateIn){
            Candidate candidate = new Candidate();
            candidate.setName(candidateIn.getName());
            return candidate;
        }
        public  static Status status (StatusIn statusIn){
            Status status = new Status(statusIn.getName(), statusIn.getPriority_level());
           return status;
        }
}
