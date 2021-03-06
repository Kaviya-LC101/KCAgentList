package org.Housing.KCAgentList.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


import java.util.Objects;

@Entity
public class HouseList {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message="Enter House Description")
    @Size(min=6,max=100,message="Description must be between 6 and 100 characters")
    private String houseDescription;

    @NotBlank(message="Location cannot be blank")
    private String location;

    @NotNull(message="Enter Price")
    @Positive(message="Enter the value greater than zero")
    private float price;

    private String yearBuilt;

    @NotNull
    @ManyToOne
    private StatusCategories status;

    public HouseList(String houseDescription, String location,float price,String yearBuilt, StatusCategories status){

        this.houseDescription=houseDescription;
        this.location =location;
        this.price=price;
        this.yearBuilt=yearBuilt;
        this.status=status;
         }

    public HouseList() {}

    public String getHouseDescription() {
        return houseDescription;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public StatusCategories getStatus() {
        return status;
    }

    public void setStatus(StatusCategories status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return houseDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseList houseList = (HouseList) o;
        return id == houseList.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
