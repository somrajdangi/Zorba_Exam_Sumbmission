package org.example.rentOfFlat_xml;

public class RentOfTwoBHKFlat {
    Integer totalRentOfTwoBHKFlat;
    Integer noOfPerson;

    public Integer getTotalRentOfTwoBHKFlat() {
        return totalRentOfTwoBHKFlat;
    }

    public void setTotalRentOfTwoBHKFlat() {
        this.totalRentOfTwoBHKFlat =400*noOfPerson;
    }

    public Integer getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(Integer noOfPerson) {
        this.noOfPerson = noOfPerson;
    }
}
