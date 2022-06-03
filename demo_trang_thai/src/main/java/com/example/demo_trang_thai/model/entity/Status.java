package com.example.demo_trang_thai.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,name = "name",columnDefinition = "varchar(50)")
    private String name;
    @Column(unique = true,name = "priority_level",columnDefinition = "varchar(50)")
    private  String priority_level;
//    @OneToMany(mappedBy = "Candidate")
//    private Collection<Candidate> candidates;
    public Status(String name, String priority_level) {
        this.name = name;
        this.priority_level = priority_level;
    }

}
