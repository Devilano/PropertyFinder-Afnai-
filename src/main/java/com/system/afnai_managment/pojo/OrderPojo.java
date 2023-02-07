package com.system.afnai_managment.pojo;
import com.system.afnai_managment.entity.Order;
import com.system.afnai_managment.entity.Property;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderPojo {

    private Integer O_id;
    private Integer P_id;
    private Integer U_id;



    public OrderPojo(Order order){
        this.O_id= order.getOrderid();
        this.P_id=order.getProperty().getP_id();
        this.U_id=order.getUser().getU_id();

    }

}
