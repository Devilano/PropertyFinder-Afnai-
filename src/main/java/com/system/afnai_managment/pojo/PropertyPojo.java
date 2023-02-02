package com.system.afnai_managment.pojo;
import com.system.afnai_managment.entity.Property;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertyPojo {

    private Integer id;
    private String propertyName;
    private String areaSq;
    private String room;
    private String location;
    private String PCity;
    private String ownerName;
    private String email;
    private String mobileNo;
    private String OwnerAddress;

    public PropertyPojo(Property property){
        this.id= property.getId();
        this.propertyName=property.getPropertyName();
        this.ownerName=property.getOwnerName();
        this.email=property.getEmail();
        this.mobileNo=property.getMobileNo();
        this.areaSq=property.getAreaSq();
        this.room=property.getRoom();
        this.location=property.getLocation();
        this.PCity=property.getPCity();
        this.OwnerAddress=property.getOwnerAddress();

    }

}
