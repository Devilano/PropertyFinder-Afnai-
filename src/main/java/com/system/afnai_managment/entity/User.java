package com.system.afnai_managment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @SequenceGenerator(name = "Afnai_user_seq_gen", sequenceName = "Afnai_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "Afnai_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String email;

    @Column(name="userName")
    private String userName;
    @Column(name="password")
    private String password;

    @Column(name = "mobile_no")
    private String mobileNo;
}

