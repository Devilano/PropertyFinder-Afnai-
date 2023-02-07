package com.system.afnai_managment.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "Afnai_user_seq_gen", sequenceName = "Afnai_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "Afnai_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer U_id;

    @Column(nullable = false)
    private String email;

    @Column(name="user_name")
    private String useernname;
    @Column(name="password")
    private String password;

    @Column(name = "mobile_no")
    private String mobileNo;

    private String image;

    @Transient
    private String imageBase64;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

