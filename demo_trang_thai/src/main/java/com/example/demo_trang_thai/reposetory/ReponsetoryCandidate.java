package com.example.demo_trang_thai.reposetory;

import com.example.demo_trang_thai.model.entity.Candidate;
import com.example.demo_trang_thai.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReponsetoryCandidate extends JpaRepository<Candidate, Long> {
//    @Query()
    List<Candidate> findAll();

    @Query(value = "select * from candidate where id = ?1",nativeQuery = true)
    Candidate getById(Long id);

    @Query(value = "Select * from candidate join status on status.id=candidate.id_status order by  priority_level asc,candidate.updated_on asc",nativeQuery = true)
    List<Candidate> findCandidate();

    @Query(value = "Select * from candidate join status on status.id=candidate.id_status order by  priority_level asc,candidate.updated_on asc limit 1",nativeQuery = true)
    List<Candidate> findPriorityCandidate();
}
