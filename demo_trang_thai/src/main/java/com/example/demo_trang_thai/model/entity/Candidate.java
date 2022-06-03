package com.example.demo_trang_thai.model.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "candidate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Candidate {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private boolean hover;
    @ManyToOne
    @JoinColumn(name = "id_status")
    private  Status status;

    @Column(name = "created_on")
    private LocalDateTime created_on;
    @Column(name = "updated_on")
    private LocalDateTime updated_on;

    @PrePersist
    public void PrePersist(){
        created_on= LocalDateTime.now();
        updated_on = LocalDateTime.now();
        hover=false;
    }

    //    @PreUpdate
//    public void PreUpdate(){
//        updated_on= LocalDateTime.now();
//    }
}
