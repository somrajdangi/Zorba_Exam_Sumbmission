package org.example.selfOwnedFlat;


public class SelfOwnedFlatProperty {
    SelfOwnedOneBHKFlat selfOwnedOneBHKFlat;
    SelfOwnedTwoBHKFlat selfOwnedTwoBHKFlat;
    SelfOwnedThreeBHKFlat selfOwnedThreeBHKFlat;

    public SelfOwnedFlatProperty(SelfOwnedOneBHKFlat selfOwnedOneBHKFlat, SelfOwnedTwoBHKFlat selfOwnedTwoBHKFlat, SelfOwnedThreeBHKFlat selfOwnedThreeBHKFlat) {
        this.selfOwnedOneBHKFlat = selfOwnedOneBHKFlat;
        this.selfOwnedTwoBHKFlat = selfOwnedTwoBHKFlat;
        this.selfOwnedThreeBHKFlat = selfOwnedThreeBHKFlat;
    }

    public SelfOwnedOneBHKFlat getSelfOwnedOneBHKFlat() {
        return selfOwnedOneBHKFlat;
    }

    public void setSelfOwnedOneBHKFlat(SelfOwnedOneBHKFlat selfOwnedOneBHKFlat) {
        this.selfOwnedOneBHKFlat = selfOwnedOneBHKFlat;
    }

    public SelfOwnedThreeBHKFlat getSelfOwnedThreeBHKFlat() {
        return selfOwnedThreeBHKFlat;
    }

    public void setSelfOwnedThreeBHKFlat(SelfOwnedThreeBHKFlat selfOwnedThreeBHKFlat) {
        this.selfOwnedThreeBHKFlat = selfOwnedThreeBHKFlat;
    }

    public SelfOwnedTwoBHKFlat getSelfOwnedTwoBHKFlat() {
        return selfOwnedTwoBHKFlat;
    }

    public void setSelfOwnedTwoBHKFlat(SelfOwnedTwoBHKFlat selfOwnedTwoBHKFlat) {
        this.selfOwnedTwoBHKFlat = selfOwnedTwoBHKFlat;
    }
}
