package com.graycat.rdte.contracts;

import com.ib.client.Contract;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyContracts {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    public static String getToday(){
        return sdf.format(new Date());
    }
    public static Contract RUT() {
        Contract contract = new Contract();
        contract.symbol("RUT");
        contract.secType("IND");
        contract.currency("USD");
        contract.exchange("RUSSELL");
        return contract;
    }

    public static Contract RUT0DTEContract(double strike, String strategy) {
        Contract contract = new Contract();
        contract.symbol("RUT");
        contract.secType("OPT");
        contract.currency("USD");
        contract.exchange("SMART");
        contract.lastTradeDateOrContractMonth(sdf.format(new Date()));
        //contract.lastTradeDateOrContractMonth("20250530");
        contract.strike(strike);
        contract.right(strategy);
        contract.multiplier("100");
        return contract;
    }

    public static Contract XSP0DTEContract(double strike, String strategy) {
        Contract contract = new Contract();
        contract.symbol("XSP");
        contract.secType("OPT");
        contract.currency("USD");
        contract.exchange("SMART");
        contract.lastTradeDateOrContractMonth(sdf.format(new Date()));
        contract.strike(strike);
        contract.right(strategy);
        contract.multiplier("100");
        return contract;
    }

    public static Contract XSP() {
        Contract contract = new Contract();
        contract.symbol("XSP");
        contract.secType("IND");
        contract.currency("USD");
        contract.exchange("CBOE");
        return contract;
    }

    public static Contract SPY() {
        Contract contract = new Contract();
        contract.symbol("SPY");
        contract.secType("STK");
        contract.currency("USD");
        contract.exchange("SMART");
        contract.primaryExch("ARCA");
        return contract;
    }
}
