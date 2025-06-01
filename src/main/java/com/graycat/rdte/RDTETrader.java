package com.graycat.rdte;
import com.graycat.rdte.contracts.ContractSamples;
import com.graycat.rdte.ewwrapper.RDTEWrapperImpl;
import com.ib.client.*;

public class RDTETrader {

    public static boolean chainRetreived = false;

    public static void main(String[] args) throws InterruptedException {
        RDTEWrapperImpl wrapper = new RDTEWrapperImpl();

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
        wrapper.getClient().reqContractDetails(1001, ContractSamples.Rut());
        Thread.sleep(100000);
        m_client.eDisconnect();
    }
}
