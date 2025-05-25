package com.graycat.rdte.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class LogManager {

    TradingLog log = null;

    private static LogManager logManager = null;

    private LogManager(){
        //Load config
        InputStream is = getClass().getClassLoader().getResourceAsStream("tradinglog.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            log = mapper.readValue(is, TradingLog.class);
        } catch(Exception e) {
            log = new TradingLog();
        }
        try{
            if(is != null) {
                is.close();
            }
        } catch (Exception e){

        }
    }

    public static LogManager getManager(){
        if( logManager == null){
            logManager = new LogManager();
        }
        return logManager;
    }

    public void addTradingLog(TradingLogEntry logEntry) {
        log.getTradingLogs().add(logEntry);
        saveLog();
    }

    public boolean isOrderSubmitted(String expire) {
        for(TradingLogEntry entry : log.getTradingLogs()) {
            if(expire.equals(entry.getExpire())){
                return true;
            }
        }
        return false;
    }

    private void saveLog(){
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("tradinglog.json");
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + "tradinglog.json");
        } else {
            try {
                File output = new File(resource.toURI());
                ObjectMapper mapper = new ObjectMapper();
                mapper.writerWithDefaultPrettyPrinter().writeValue(output, log);

            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
