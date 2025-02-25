package com.graycat.rdte.advisor;

public class FAMethodSamples {
    public static final String FA_UPDATED_GROUP = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<ListOfGroups>" +
            "<Group>" +
            "<name>MyTestProfile1</name>" +
            "<defaultMethod>ContractsOrShares</defaultMethod>" +
            "<ListOfAccts varName=\"list\">" +
            "<Account>" +
            "<acct>DU6202167</acct>" +
            "<amount>100.0</amount>" +
            "</Account>" +
            "<Account>" +
            "<acct>DU6202168</acct>" +
            "<amount>200.0</amount>" +
            "</Account>" +
            "</ListOfAccts>" +
            "</Group>" +
            "<Group>" +
            "<name>MyTestProfile2</name>" +
            "<defaultMethod>Ratio</defaultMethod>" +
            "<ListOfAccts varName=\"list\">" +
            "<Account>" +
            "<acct>DU6202167</acct>" +
            "<amount>1.0</amount>" +
            "</Account>" +
            "<Account>" +
            "<acct>DU6202168</acct>" +
            "<amount>2.0</amount>" +
            "</Account>" +
            "</ListOfAccts>" +
            "</Group>" +
            "<Group>" +
            "<name>MyTestProfile3</name>" +
            "<defaultMethod>Percent</defaultMethod>" +
            "<ListOfAccts varName=\"list\">" +
            "<Account>" +
            "<acct>DU6202167</acct>" +
            "<amount>60.0</amount>" +
            "</Account>" +
            "<Account>" +
            "<acct>DU6202168</acct>" +
            "<amount>40.0</amount>" +
            "</Account>" +
            "</ListOfAccts>" +
            "</Group>" +
            "<Group>" +
            "<name>MyTestProfile4</name>" +
            "<defaultMethod>MonetaryAmount</defaultMethod>" +
            "<ListOfAccts varName=\"list\">" +
            "<Account>" +
            "<acct>DU6202167</acct>" +
            "<amount>1000.0</amount>" +
            "</Account>" +
            "<Account>" +
            "<acct>DU6202168</acct>" +
            "<amount>2000.0</amount>" +
            "</Account>" +
            "</ListOfAccts>" +
            "</Group>" +
            "<Group>" +
            "<name>Group_1</name>" +
            "<defaultMethod>NetLiq</defaultMethod>" +
            "<ListOfAccts varName=\"list\">" +
            "<Account>" +
            "<acct>DU6202167</acct>" +
            "</Account>" +
            "<Account>" +
            "<acct>DU6202168</acct>" +
            "</Account>" +
            "</ListOfAccts>" +
            "</Group>" +
            "<Group>" +
            "<name>MyTestGroup1</name>" +
            "<defaultMethod>AvailableEquity</defaultMethod>" +
            "<ListOfAccts varName=\"list\">" +
            "<Account>" +
            "<acct>DU6202167</acct>" +
            "</Account>" +
            "<Account>" +
            "<acct>DU6202168</acct>" +
            "</Account>" +
            "</ListOfAccts>" +
            "</Group>" +
            "<Group>" +
            "<name>MyTestGroup2</name>" +
            "<defaultMethod>NetLiq</defaultMethod>" +
            "<ListOfAccts varName=\"list\">" +
            "<Account>" +
            "<acct>DU6202167</acct>" +
            "</Account>" +
            "<Account>" +
            "<acct>DU6202168</acct>" +
            "</Account>" +
            "</ListOfAccts>" +
            "</Group>" +
            "<Group>" +
            "<name>MyTestGroup3</name>" +
            "<defaultMethod>Equal</defaultMethod>" +
            "<ListOfAccts varName=\"list\">" +
            "<Account>" +
            "<acct>DU6202167</acct>" +
            "</Account>" +
            "<Account>" +
            "<acct>DU6202168</acct>" +
            "</Account>" +
            "</ListOfAccts>" +
            "</Group>" +
            "<Group>" +
            "<name>Group_2</name>" +
            "<defaultMethod>AvailableEquity</defaultMethod>" +
            "<ListOfAccts varName=\"list\">" +
            "<Account>" +
            "<acct>DU6202167</acct>" +
            "</Account>" +
            "<Account>" +
            "<acct>DU6202168</acct>" +
            "</Account>" +
            "</ListOfAccts>" +
            "</Group>" +
            "</ListOfGroups>";
    //! [faupdatedgroup]
}
