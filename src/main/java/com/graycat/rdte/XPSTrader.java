package com.graycat.rdte;

import com.graycat.rdte.contracts.MyContracts;
import com.graycat.rdte.ewwrapper.XPSWrapperImpl;
import com.ib.client.EClientSocket;
import com.ib.client.EReader;
import com.ib.client.EReaderSignal;

public class XPSTrader {
    public static boolean chainRetreived = false;

    public static void main(String[] args) throws InterruptedException {
        XPSWrapperImpl wrapper = new XPSWrapperImpl();

        final EClientSocket m_client = wrapper.getClient();
        final EReaderSignal m_signal = wrapper.getSignal();

        m_client.setConnectOptions("+PACEAPI");

        m_client.eConnect("127.0.0.1", 7496, 2);

        final EReader reader = new EReader(m_client, m_signal);

        reader.start();
        //An additional thread is created in this program design to empty the messaging queue
        new Thread(() -> {
            while (m_client.isConnected()) {
                m_signal.waitForSignal();
                try {
                    reader.processMsgs();
                } catch (Exception e) {
                    System.out.println("Exception: "+e.getMessage());
                }
            }
        }).start();

        // A pause to give the application time to establish the connection
        // In a production application, it would be best to wait for callbacks to confirm the connection is complete
        Thread.sleep(1000);
        wrapper.getClient().reqContractDetails(1001, MyContracts.XSP());
        Thread.sleep(100000);
        m_client.eDisconnect();
    }
}
