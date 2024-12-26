package com.graycat.rdte.trader;

import java.util.ArrayList;
import java.util.List;

public class OptionChain {
    private String symbol;
    private String expire;
    private List<OptionEntry> options = new ArrayList<>();

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public List<OptionEntry> getOptions() {
        return options;
    }

    public void setOptions(List<OptionEntry> options) {
        this.options = options;
    }
}
