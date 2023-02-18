package com.system.afnai_managment.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order{
    @Id
    @SequenceGenerator(name = "gp_user_seq_gen", sequenceName = "gp_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "gp_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer orderid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "U_id",
            foreignKey = @ForeignKey(name = "FK_User_Id")
    )
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id", referencedColumnName = "P_id",
            foreignKey = @ForeignKey(name = "Fk_Product_Id"))

    private Property property;

    public Integer getOrderid() {
        return this.orderid;
    }


}
