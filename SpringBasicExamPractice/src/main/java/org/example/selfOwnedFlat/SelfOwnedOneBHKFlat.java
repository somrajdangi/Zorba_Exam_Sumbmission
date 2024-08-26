package org.example.selfOwnedFlat;

public class SelfOwnedOneBHKFlat {

   Float plot;
   Float finalPriceOfSelfOwnedOneBHKFlat;

    public Float getPlot() {
        return plot;
    }

    public void setPlot(Float length,Float breadth,Float height) {
        this.plot = length*breadth*height;
    }

    public Float getFinalPriceOfSelfOwnedOneBHKFlat() {
        return finalPriceOfSelfOwnedOneBHKFlat;
    }

    public void setFinalPriceOfSelfOwnedOneBHKFlat() {
        this.finalPriceOfSelfOwnedOneBHKFlat = plot*10000;
    }
}
