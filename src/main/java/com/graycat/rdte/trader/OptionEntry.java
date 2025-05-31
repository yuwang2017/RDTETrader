package com.graycat.rdte.trader;

public class OptionEntry {
    public static String CALL = "C";
    public static String PUT = "P";
    private String Strategy;
    private double bid;
    private double ask;
    private double strike;

    private double delta;

    private int volume = 0;

    private int openInt = 0;

    private double markPrice;

    private double optPrice;

    private double undPrice;

    public String getStrategy() {
        return Strategy;
    }

    public void setStrategy(String strategy) {
        Strategy = strategy;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getStrike() {
        return strike;
    }

    public void setStrike(double strike) {
        this.strike = strike;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getOpenInt() {
        return openInt;
    }

    public void setOpenInt(int openInt) {
        this.openInt = openInt;
    }



    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public double getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(double markPrice) {
        this.markPrice = markPrice;
    }

    public double getOptPrice() {
        return optPrice;
    }

    public void setOptPrice(double optPrice) {
        this.optPrice = optPrice;
    }

    public double getUndPrice() {
        return undPrice;
    }

    public void setUndPrice(double undPrice) {
        this.undPrice = undPrice;
    }
}
