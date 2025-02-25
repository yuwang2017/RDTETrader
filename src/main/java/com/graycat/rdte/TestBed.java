package com.graycat.rdte;

import com.graycat.rdte.contracts.ContractSamples;
import com.graycat.rdte.orders.OrderSamples;
import com.graycat.rdte.trader.OptionEntry;
import com.ib.client.Decimal;
import com.ib.client.EClientSocket;
import com.ib.client.EReader;
import com.ib.client.EReaderSignal;

public class TestBed {
    public static void main(String[] args) throws InterruptedException {
        EWrapperImpl wrapper = new EWrapperImpl();

        final EClientSocket m_client = wrapper.getClient();
        final EReaderSignal m_signal = wrapper.getSignal();

        m_client.setConnectOptions("+PACEAPI");

        //! [connect]
        m_client.eConnect("127.0.0.1", 7496, 2);
        //! [connect]
        //! [ereader]
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
        //! [ereader]
        // A pause to give the application time to establish the connection
        // In a production application, it would be best to wait for callbacks to confirm the connection is complete
        Thread.sleep(1000);
        requestMarketData(wrapper.getClient());
        //	testSubmitOrder(wrapper.getClient(), wrapper.getCurrentOrderId());
        Thread.sleep(10000);
        m_client.eDisconnect();
    }

    private static void testSubmitOrder(EClientSocket client, int nextOrderId){
        client.placeOrder(nextOrderId++, ContractSamples.RUT0DTEContract(2240, OptionEntry.CALL), OrderSamples.LimitOrder("BUY", Decimal.parse("1"), 0.05));
    }
    private static void requestMarketData(EClientSocket client) {
        //client.reqMktData(1003, ContractSamples.RUSSEL2000(), "221", false, false, null);
        //client.reqTickByTickData(1003, ContractSamples.RUSSEL2000(), "Last", 0, false);
        client.reqMktData(1004, ContractSamples.RUT0DTEContract(2220, OptionEntry.CALL), "100,233,236", false, false, null);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        client.cancelMktData(1004);
    }
    private static void startRussel0TDECoverCall(EClientSocket client){
        client.reqContractDetails(1001, ContractSamples.Rut());
    }
}
