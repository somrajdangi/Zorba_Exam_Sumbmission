package org.example.rentOfFlat_xml;

public class RentOfOneBHKFlat {
    Integer noOfPerson;
    Integer totalRentOfOneBHKFlat;

    public Integer getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(Integer noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public Integer getTotalRentOfOneBHKFlat() {
        return totalRentOfOneBHKFlat;
    }

    public void setTotalRentOfOneBHKFlat() {
        this.totalRentOfOneBHKFlat = 250*noOfPerson;
    }
}
