package org.Housing.KCAgentList.models;

import java.util.Objects;

public class HouseList {

    private int id;
    private static int nextid=1;
    private String houseDescription;

    private String address;

    public HouseList(String houseDescription, String address){
        this.houseDescription=houseDescription;
        this.address=address;
        this.id=nextid;
        nextid++;
    }

    public String getHouseDescription() {
        return houseDescription;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
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
