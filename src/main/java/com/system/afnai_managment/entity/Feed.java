package com.system.afnai_managment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Feed")
public class Feed{
    @Id
    @SequenceGenerator(name = "gp_user_seq_gen", sequenceName = "gp_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "gp_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer F_id;
    @Column(name="fullName", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String requirement;
    @Column(nullable = false)
    private String budget;


    @Column(name = "Email",nullable = false)
    private String email;

    @Column(name = "mobile_no", nullable=false)
    private String mobileNo;


}
