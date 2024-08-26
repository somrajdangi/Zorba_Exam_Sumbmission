package org.example.rentOfFlat_xml;

public class RentOfFlatProperty {
    RentOfOneBHKFlat rentOfOneBHKFlat;
    RentOfTwoBHKFlat rentOfTwoBHKFlat;
    RentOfThreeBHKFlat rentOfThreeBHKFlat;
   public RentOfFlatProperty(RentOfOneBHKFlat rentOfOneBHKFlat, RentOfTwoBHKFlat rentOfTwoBHKFlat, RentOfThreeBHKFlat rentOfThreeBHKFlat){
        this.rentOfOneBHKFlat= rentOfOneBHKFlat;
        this.rentOfTwoBHKFlat= rentOfTwoBHKFlat;
        this.rentOfThreeBHKFlat= rentOfThreeBHKFlat;
    }

    public RentOfOneBHKFlat getRentOfOneBHKFlat() {
        return rentOfOneBHKFlat;
    }

    public void setRentOfOneBHKFlat(RentOfOneBHKFlat rentOfOneBHKFlat) {
        this.rentOfOneBHKFlat = rentOfOneBHKFlat;
    }

    public RentOfTwoBHKFlat getRentOfTwoBHKFlat() {
        return rentOfTwoBHKFlat;
    }

    public void setRentOfTwoBHKFlat(RentOfTwoBHKFlat rentOfTwoBHKFlat) {
        this.rentOfTwoBHKFlat = rentOfTwoBHKFlat;
    }

    public RentOfThreeBHKFlat getRentOfThreeBHKFlat() {
        return rentOfThreeBHKFlat;
    }

    public void setRentOfThreeBHKFlat(RentOfThreeBHKFlat rentOfThreeBHKFlat) {
        this.rentOfThreeBHKFlat = rentOfThreeBHKFlat;
    }
}
