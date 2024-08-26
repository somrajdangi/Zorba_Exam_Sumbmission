package org.example.rentOfFlat_xml;

public class RentOfThreeBHKFlat {
    Integer noOfPerson;
    Integer totalRenoOfThreeBHKFlat;

    public Integer getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(Integer noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public Integer getTotalRenoOfThreeBHKFlat() {
        return totalRenoOfThreeBHKFlat;
    }

    public void setTotalRenoOfThreeBHKFlat() {
        this.totalRenoOfThreeBHKFlat = 600*noOfPerson;
    }
}
