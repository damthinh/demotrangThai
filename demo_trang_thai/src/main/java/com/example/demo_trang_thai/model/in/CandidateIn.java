package com.example.demo_trang_thai.model.in;

import com.example.demo_trang_thai.model.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateIn {
    private String name;
    private Status status;
}
