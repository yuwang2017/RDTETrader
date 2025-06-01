package com.graycat.rdte;

import com.graycat.rdte.contracts.ContractSamples;
import com.graycat.rdte.contracts.MyContracts;
import com.graycat.rdte.ewwrapper.RDTEWrapperImpl;
import com.graycat.rdte.orders.OrderSamples;
import com.graycat.rdte.trader.OptionEntry;
import com.ib.client.Decimal;
import com.ib.client.EClientSocket;
import com.ib.client.EReader;
import com.ib.client.EReaderSignal;

public class TestBed {
    public static void main(String[] args) throws InterruptedException {
        RDTEWrapperImpl wrapper = new RDTEWrapperImpl();

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
        Thread.sleep(30000);
        m_client.eDisconnect();
    }

    private static void testSubmitOrder(EClientSocket client, int nextOrderId){
        client.placeOrder(nextOrderId++, ContractSamples.RUT0DTEContract(2240, OptionEntry.CALL), OrderSamples.LimitOrder("BUY", Decimal.parse("1"), 0.05));
    }
    private static void requestMarketData(EClientSocket client) {
        //client.reqMktData(1003, ContractSamples.OptionWithLocalSymbol2(), "", false, false, null);
        //client.reqTickByTickData(1003, ContractSamples.RUSSEL2000(), "Last", 0, false);
        //client.reqMktData(1003, ContractSamples.RUT0DTEContract(2090, OptionEntry.CALL), "100,220,221,233,236", false, false, null);
        //client.reqMktData(1003, ContractSamples.RUT0DTEContract(2060, OptionEntry.CALL), "220,221", false, false, null);
        //client.reqMktData(1003, ContractSamples.XSP0DTEContract(585, OptionEntry.CALL), "101", false, false, null);
        //client.reqMktData(1003, MyContracts.XSP0DTEContract(600, OptionEntry.CALL), "", false, false, null);
        client.reqMktData(1003, MyContracts.XSP(), "", false, false, null);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        client.cancelMktData(1003);
    }
    private static void startRussel0TDECoverCall(EClientSocket client){
        client.reqContractDetails(1001, ContractSamples.Rut());
    }
}
