package com.example.demo_trang_thai.services.service;

import com.example.demo_trang_thai.model.entity.Candidate;
import com.example.demo_trang_thai.model.entity.Status;
import com.example.demo_trang_thai.model.in.CandidateIn;
import com.example.demo_trang_thai.model.in.PriorityCandidateIn;
import com.example.demo_trang_thai.model.in.StatusIn;
import com.example.demo_trang_thai.model.response.Response;
import com.example.demo_trang_thai.reposetory.ReponsetoryCandidate;
import com.example.demo_trang_thai.reposetory.ReponsetoryStatus;
import com.example.demo_trang_thai.services.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class Service implements Services {
    @Autowired
    private ReponsetoryCandidate reponsetoryCandidate;
    @Autowired
    private ReponsetoryStatus reponsetoryStatus;
    @Override
    public Response getStatus() {
        List<Status> listStatus = reponsetoryStatus.findStatus();
        if (listStatus.isEmpty()){
            return new Response("get fail");
        }else {
            return new Response("get ok",listStatus);
        }
    }

    @Override
    public Response addStatus(StatusIn statusIn) {
        Status status = Mapper.status(statusIn);
        Boolean findName =reponsetoryStatus.findByName(statusIn.getName()).isPresent();
        if (findName){
            return new Response("tên đã tồn tại");
        }else {
            Boolean findPriority_level =reponsetoryStatus.findByPriority_level(statusIn.getPriority_level()).isPresent();
            if (findPriority_level){
                return new Response("mức độ đã tồn tại");
            }else {
                reponsetoryStatus.save(status);
                return new Response("add ok");
            }
        }
    }

    @Override
    public Response updateStatus(Long id,StatusIn statusIn) {
        System.out.println("vo service");
        Status status = Mapper.status(statusIn);
        boolean findId =reponsetoryStatus.findById(id).isPresent();
        if (findId){
            boolean checkName = reponsetoryStatus.findByNameOtherId(id,status.getName()).isPresent();
            System.out.println(checkName);
            if (checkName){
                return new Response("tên đã tồn tại");
            }else {
                boolean checkPriority_level = reponsetoryStatus.findByPriority_levelOtherId(id,status.getPriority_level()).isPresent();
                System.out.println(checkPriority_level);
                if (checkPriority_level){
                    return new Response("mức độ đã tồn tại");
                }
                else {
            status.setId(id);
            reponsetoryStatus.save(status);
            System.out.println(status);
                    return new Response("update ok");
                }
            }
        }else {
            return new Response("không thấy id");
        }
    }
    @Override
    public Response getCandidate() {
        List<Candidate> listStatus = reponsetoryCandidate.findCandidate();
        if (listStatus.isEmpty()){
            return new Response("get fail");
        }else {
            return new Response("get ok",listStatus);
        }
    }

    @Override
    public Response addCandidate(CandidateIn candidateIn) {
        Candidate candidate = Mapper.candidate(candidateIn);
        Status findId = reponsetoryStatus.getByName("new");
        candidate.setStatus(findId);
        reponsetoryCandidate.save(candidate);
        System.out.println(candidate);
        return new Response("add ok",candidate);
    }

    @Override
    public Response updateCandidate(Long id ,CandidateIn candidateIn) {
        Candidate candidate = reponsetoryCandidate.getById(id);
        candidate.setName(candidateIn.getName());
        reponsetoryCandidate.save(candidate);
        return new Response("update ok",candidate);
    }

    @Override
    public Response deleteCandidate(Long id) {
        Optional<Candidate> findId = reponsetoryCandidate.findById(id);
        if (findId.isPresent()){
           reponsetoryCandidate.deleteById(id);
            return new Response("delete ok");
        }else {
            return new Response("không thấy id");
        }
    }

    @Override
    public Response getPriorityCandidate() {
        List<Candidate> listPriorityCandidate = reponsetoryCandidate.findPriorityCandidate();
        if (listPriorityCandidate.isEmpty()){
            return new Response("get fail");
        }else {
            return new Response("get ok",listPriorityCandidate);
        }
    }

    @Override
    public Response updatePriorityCandidate(PriorityCandidateIn priorityCandidateIn) {
        boolean checkCandidate = reponsetoryCandidate.findById(priorityCandidateIn.getId_candidate()).isPresent();
        if (checkCandidate){
                boolean checkStatus = reponsetoryStatus.findById(priorityCandidateIn.getId_status()).isPresent();
                if (checkStatus){
                    Candidate candidate = reponsetoryCandidate.getById(priorityCandidateIn.getId_candidate());
                    Status status = reponsetoryStatus.getById(priorityCandidateIn.getId_status());
                    candidate.setStatus(status);
                    candidate.setUpdated_on(LocalDateTime.now());
                    reponsetoryCandidate.save(candidate);
                    return new Response("update ok");
                }else {
                    return new Response("không thấy id status");
                }
        }else {
            return new Response("không thấy id candidate");
        }
    }
}
