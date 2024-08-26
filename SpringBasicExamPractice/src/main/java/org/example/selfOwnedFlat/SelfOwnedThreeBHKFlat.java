package org.example.selfOwnedFlat;

public class SelfOwnedThreeBHKFlat {
    Float plot;
    Float finalPriceOfSelfOwnedThreeBHKFlat;

    public Float getPlot() {
        return plot;
    }

    public void setPlot(Float length,Float breadth,Float height) {
        this.plot = length*breadth*height;
    }

    public Float getFinalPriceOfSelfOwnedThreeBHKFlat() {
        return finalPriceOfSelfOwnedThreeBHKFlat;
    }

    public void setFinalPriceOfSelfOwnedThreeBHKFlat() {
        this.finalPriceOfSelfOwnedThreeBHKFlat = plot*50000F;
    }
}
