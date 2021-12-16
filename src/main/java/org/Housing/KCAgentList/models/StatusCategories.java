package org.Housing.KCAgentList.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class StatusCategories {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Size(min=3,max=50,message="Status name must be between 3 to 50 characters")
    private String statusName;

    @OneToMany(mappedBy = "status")
    private final List<HouseList> houseList=new ArrayList<>();


    public StatusCategories( String statusName) {

        this.statusName = statusName;
    }

    public StatusCategories() {
    }

    public int getId() {
        return id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<HouseList> getHouseList() {
        return houseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusCategories that = (StatusCategories) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
