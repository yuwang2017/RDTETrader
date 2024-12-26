package com.graycat.rdte.utils;

import java.util.ArrayList;
import java.util.List;

public class TradingLog {
    private List<TradingLogEntry> tradingLogs = new ArrayList<>();

    public List<TradingLogEntry> getTradingLogs() {
        return tradingLogs;
    }

    public void setTradingLogs(List<TradingLogEntry> tradingLogs) {
        this.tradingLogs = tradingLogs;
    }
}
