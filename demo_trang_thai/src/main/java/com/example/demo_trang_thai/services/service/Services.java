package com.example.demo_trang_thai.services.service;

import com.example.demo_trang_thai.model.in.CandidateIn;
import com.example.demo_trang_thai.model.in.PriorityCandidateIn;
import com.example.demo_trang_thai.model.in.StatusIn;
import com.example.demo_trang_thai.model.response.Response;
import org.springframework.stereotype.Service;

@Service
public interface Services {
    Response getStatus ();
    Response addStatus(StatusIn statusIn);
    Response updateStatus(Long id ,StatusIn statusIn);

    Response getCandidate();
    Response addCandidate(CandidateIn candidateIn);
    Response updateCandidate(Long id ,CandidateIn candidateIn);
    Response deleteCandidate(Long id);

    Response getPriorityCandidate();
    Response updatePriorityCandidate(PriorityCandidateIn priorityCandidateIn);
}
