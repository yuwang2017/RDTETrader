package com.graycat.test;

import com.graycat.rdte.contracts.ContractSamples;
import com.graycat.rdte.trader.OptionEntry;
import com.graycat.rdte.utils.LogManager;
import com.graycat.rdte.utils.TradingLogEntry;

import java.util.Date;

public class TestLogManager {
    public static void main(String[] args) {
        LogManager logManager = LogManager.getManager();

        TradingLogEntry logEntry = new TradingLogEntry();
        logEntry.setExpire(ContractSamples.getToday());
        logEntry.setStrategy(OptionEntry.CALL);
        logEntry.setTicker("RUT");
        logEntry.setTradingDate(new Date());
        logEntry.setStrike(2250.0);
        logEntry.setVolume(850);
        logManager.addTradingLog(logEntry);

        logManager.addTradingLog(logEntry);
    }
}
