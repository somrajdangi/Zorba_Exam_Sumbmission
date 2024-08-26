package org.example.selfOwnedFlat;

public class SelfOwnedTwoBHKFlat {
    Float plot;
    Float finalPriceOfSelfOwnedTwoBHKFlat;

    public Float getPlot() {
        return plot;
    }

    public void setPlot(Float length,Float bredth,Float height) {
        this.plot = length*bredth*height;
    }

    public Float getFinalPriceOfSelfOwnedTwoBHKFlat() {
        return finalPriceOfSelfOwnedTwoBHKFlat;
    }

    public void setFinalPriceOfSelfOwnedTwoBHKFlat(Float finalPriceOfSelfOwnedTwoBHKFlat) {
        this.finalPriceOfSelfOwnedTwoBHKFlat = plot*30000;
    }
}
