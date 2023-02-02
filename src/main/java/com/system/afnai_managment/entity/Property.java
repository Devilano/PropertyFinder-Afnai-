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
@Table(name = "property")
public class Property{
    @Id
    @SequenceGenerator(name = "gp_user_seq_gen", sequenceName = "gp_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "gp_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name="propertyname", nullable = false)
    private String propertyName;

    @Column(nullable = false)
    private String areaSq;

    @Column(nullable = false)
    private String room;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String PCity;

    @Column(nullable = false,unique = true)
    private String ownerName;


    @Column(name = "Email",nullable = false)
    private String email;

    @Column(name = "mobile_no", nullable=false)
    private String mobileNo;


    @Column(nullable = false)
    private String OwnerAddress;


}
