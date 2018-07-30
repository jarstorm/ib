package ib;

import java.util.Set;
import java.util.Vector;

import com.ib.client.*;

public class EWrapperImpl implements EWrapper {

	// Add for API 9.72 and newer
	private EJavaSignal m_signal = new EJavaSignal();
	private EReader m_reader;

	// Keep track of the next ID
	private int nextOrderID = 0;
	// The IB API Client Socket object
	private EClientSocket client = null;
	// Keep track of prices for Moving Average
	private double priceTotal;
	private int numberOfPrices;

	public EWrapperImpl() {
		// Initialize to 0
		priceTotal = 0.0;
		numberOfPrices = 0;
		// Create a new EClientSocket object version 9.71
		// client = new EClientSocket (this);
		client = new EClientSocket(this, m_signal);
		// Connect to the TWS or IB Gateway application
		// Leave null for localhost
		// Port Number (should match TWS/IB Gateway configuration
		client.eConnect("127.0.0.1", 7497, 0);

		// Pause here for connection to complete
		try {
			// Thread.sleep (1000);
			while (!(client.isConnected()))
				;
			// Can also try: while (client.NextOrderId <= 0);
		} catch (Exception e) {
		}
		;

		// API Version 9.72 and later Launch EReader Thread
		m_reader = new EReader(client, m_signal);
		m_reader.start();
		new Thread() {
			@Override
			public void run() {
				processMessages();
			}
		}.start();

		// Create a new contract
		Contract contract = new Contract();
		contract.symbol("ES");
		// contract.expiry("20160318");
		contract.lastTradeDateOrContractMonth("20160318");
		contract.exchange("GLOBEX");
		contract.secType("FUT");
		contract.currency("USD");
		// Create a TagValue list
		Vector<TagValue> mktDataOptions = new Vector<TagValue>();
		// Make a call to start off data retrieval
		client.reqMktData(0, contract, null, false, mktDataOptions);
		// For API Version 9.73 and higher, add one more parameter: regulatory snapshot
		// client.reqMktData(0, contract, null, false, false, mktDataOptions);

		// At this point our call is done and any market data events
		// will be returned via the tickPrice method
		client.reqScannerParameters();
		client.reqAllOpenOrders();
	} // end RealTimeData

	private void processMessages() {
		while (true) {
			try {
				m_reader.processMsgs();
			} catch (Exception e) {
				error(e);
			}
		} // end while
	} // end processMessages()

	// New for API version 9.72.14
	@Override
	public void securityDefinitionOptionalParameter(int reqId, String exchange, int underlyingConId, String tradingClass,
			String multiplier, Set expirations, Set strikes) {
		// TODO Auto-generated method stub
	}

	// New for API version 9.72.14
	@Override
	public void securityDefinitionOptionalParameterEnd(int reqId) {
		// TODO Auto-generated method stub
	}

	// New for API version 9.72.14
	@Override
	public void accountUpdateMulti(int reqId, String account, String modelCode, String key, String value, String currency) {
		// TODO Auto-generated method stub
	}

	// New for API version 9.72.14
	@Override
	public void accountUpdateMultiEnd(int reqId) {
		// TODO Auto-generated method stub
	}

	// New for API version 9.72.14
	@Override
	public void positionMulti(int reqId, String account, String modelCode, Contract contract, double pos, double avgCost) {
		// TODO Auto-generated method stub
	}

	// New for API version 9.72.14
	@Override
	public void positionMultiEnd(int reqId) {
		// TODO Auto-generated method stub
	}

	@Override
	public void bondContractDetails(int reqId, ContractDetails contractDetails) {
	}

	@Override
	public void contractDetails(int reqId, ContractDetails contractDetails) {
	}

	@Override
	public void contractDetailsEnd(int reqId) {
	}

	@Override
	public void fundamentalData(int reqId, String data) {
	}

	public void bondContractDetails(ContractDetails contractDetails) {
	}

	public void contractDetails(ContractDetails contractDetails) {
	}

	@Override
	public void currentTime(long time) {
	}

	@Override
	public void displayGroupList(int requestId, String contraftInfo) {
	}

	@Override
	public void displayGroupUpdated(int requestId, String contractInfo) {
	}

	// Add for API version 9.72
	@Override
	public void verifyAndAuthCompleted(boolean isSuccessful, String errorText) {
	}

	// Add for API version 9.72
	@Override
	public void verifyAndAuthMessageAPI(String apiData, String xyzChallange) {
	}

	@Override
	public void verifyCompleted(boolean completed, String contractInfo) {
	}

	@Override
	public void verifyMessageAPI(String message) {
	}

	@Override
	public void execDetails(int orderId, Contract contract, Execution execution) {
	}

	@Override
	public void execDetailsEnd(int reqId) {
	}

	@Override
	public void historicalData(int reqId, String date, double open, double high, double low, double close, int volume,
			int count, double WAP, boolean hasGaps) {
	}

	@Override
	public void managedAccounts(String accountsList) {
	}

	@Override
	public void commissionReport(CommissionReport cr) {
	}

	// For API Version 9.72 pos is now a double
	@Override
	public void position(String account, Contract contract, double pos, double avgCost) {
	}

	@Override
	public void positionEnd() {
	}

	@Override
	public void accountSummary(int reqId, String account, String tag, String value, String currency) {
	}

	@Override
	public void accountSummaryEnd(int reqId) {
	}

	@Override
	public void accountDownloadEnd(String accountName) {
	}

	@Override
	public void openOrder(int orderId, Contract contract, Order order, OrderState orderState) {
		System.out.println("Orders" + orderId);
	}

	@Override
	public void openOrderEnd() {
		System.out.println("Fin de Orders");
	}

	// For API Version 9.72
	@Override
	public void orderStatus(int orderId, String status, double filled, double remaining, double avgFillPrice, int permId,
			int parentId, double lastFillPrice, int clientId, String whyHeld) {
	}

	@Override
	public void receiveFA(int faDataType, String xml) {
	}

	@Override
	public void scannerData(int reqId, int rank, ContractDetails contractDetails, String distance, String benchmark,
			String projection, String legsStr) {
		System.out.println("llega");
	}

	@Override
	public void scannerDataEnd(int reqId) {
		System.out.println("llega 2");
	}

	@Override
	public void scannerParameters(String xml) {
		System.out.println("llega xml " + xml);
	}

	@Override
	public void tickEFP(int symbolId, int tickType, double basisPoints, String formattedBasisPoints, double impliedFuture,
			int holdDays, String futureExpiry, double dividendImpact, double dividendsToExpiry) {
	}

	@Override
	public void tickGeneric(int symbolId, int tickType, double value) {
	}

	@Override
	public void tickOptionComputation(int tickerId, int field, double impliedVol, double delta, double optPrice,
			double pvDividend, double gamma, double vega, double theta, double undPrice) {
	}

	// public void deltaNeutralValidation(int reqId, UnderComp underComp)
	@Override
	public void deltaNeutralValidation(int reqId, DeltaNeutralContract underComp) {
	}

	@Override
	public void updateAccountTime(String timeStamp) {
	}

	@Override
	public void updateAccountValue(String key, String value, String currency, String accountName) {
	}

	@Override
	public void updateMktDepth(int symbolId, int position, int operation, int side, double price, int size) {
	}

	@Override
	public void updateMktDepthL2(int symbolId, int position, String marketMaker, int operation, int side, double price,
			int size) {
	}

	@Override
	public void updateNewsBulletin(int msgId, int msgType, String message, String origExchange) {
	}

	// For API Version 9.72
	@Override
	public void updatePortfolio(Contract contract, double position, double marketPrice, double marketValue, double averageCost,
			double unrealizedPNL, double realizedPNL, String accountName) {
	}

	@Override
	public void marketDataType(int reqId, int marketDataType) {
	}

	@Override
	public void tickSnapshotEnd(int tickerId) {
	}

	@Override
	public void connectionClosed() {
	}

	// Add connectAck for API version 9.72
	@Override
	public void connectAck() {
	}

	@Override
	public void realtimeBar(int reqId, long time, double open, double high, double low, double close, long volume, double wap,
			int count) {
	}

	@Override
	public void error(Exception e) {
		// Print out a stack trace for the exception
		e.printStackTrace();
	}

	@Override
	public void error(String str) {
		// Print out the error message
		System.err.println(str);
	}

	@Override
	public void error(int id, int errorCode, String errorMsg) {
		// Overloaded error event (from IB) with their own error
		// codes and messages
		System.err.println("error: " + id + "," + errorCode + "," + errorMsg);
	}

	@Override
	public void nextValidId(int orderId) {
		// Return the next valid OrderID
		nextOrderID = orderId;
	}

	@Override
	public void tickPrice(int orderId, int field, double price, int canAutoExecute) {
		double movingAverage = 0.0;
		try {
			// Print out the current price
			// field will provide the price type:
			// 1 = bid, 2 = ask, 4 = last
			// 6 = high, 7 = low, 9 = close
			if (field == 4) {
				numberOfPrices++;
				priceTotal += price;
				movingAverage = priceTotal / numberOfPrices;
				System.out.println("tickPrice: " + orderId + "," + field + "," + price + ", " + movingAverage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void tickSize(int orderId, int field, int size) {
		// field will provide the size type:
		// 0=bid size, 3=ask size, 5=last size, 8=volume
		// System.out.println("tickSize: " + orderId + "," + field + "," + size);
	}

	@Override
	public void tickString(int orderId, int tickType, String value) {
	}

	@Override
	public void softDollarTiers(int arg0, SoftDollarTier[] arg1) {
		// TODO Auto-generated method stub

	}
}
