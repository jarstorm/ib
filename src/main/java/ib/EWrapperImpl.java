package ib;

import java.util.Set;

import com.ib.client.*;

public class EWrapperImpl implements EWrapper {

	private EJavaSignal readerSignal;
	private EClientSocket clientSocket;
	private EReader reader;

	public EJavaSignal getReaderSignal() {
		return readerSignal;
	}

	public EClientSocket getClientSocket() {
		return clientSocket;
	}

	public EReader getReader() {
		return reader;
	}

	public EWrapperImpl() {
		readerSignal = new EJavaSignal();
		clientSocket = new EClientSocket(this, readerSignal);
		reader = new EReader(clientSocket, readerSignal);
	}

	@Override
	public void accountDownloadEnd(String arg0) {

	}

	@Override
	public void accountSummary(int arg0, String arg1, String arg2, String arg3, String arg4) {

	}

	@Override
	public void accountSummaryEnd(int arg0) {

	}

	@Override
	public void bondContractDetails(int arg0, ContractDetails arg1) {

	}

	@Override
	public void commissionReport(CommissionReport arg0) {

	}

	@Override
	public void connectAck() {

	}

	@Override
	public void connectionClosed() {

	}

	@Override
	public void contractDetails(int reqId, ContractDetails contractDetails) {
		System.out.println(EWrapperMsgGenerator.contractDetails(reqId, contractDetails));

	}

	@Override
	public void contractDetailsEnd(int reqId) {
		System.out.println("ContractDetailsEnd. " + reqId + "\n");
	}

	@Override
	public void currentTime(long arg0) {

	}

	@Override
	public void deltaNeutralValidation(int arg0, DeltaNeutralContract arg1) {

	}

	@Override
	public void displayGroupList(int arg0, String arg1) {

	}

	@Override
	public void displayGroupUpdated(int arg0, String arg1) {

	}

	@Override
	public void error(Exception arg0) {
		System.out.println("Error " + arg0.getMessage());
	}

	@Override
	public void error(String arg0) {
		System.out.println("Error: " + arg0);
	}

	@Override
	public void error(int arg0, int arg1, String arg2) {
		System.out.println("Error: " + arg0 + ", " + arg1 + ", " + arg2);
	}

	@Override
	public void execDetails(int arg0, Contract arg1, Execution arg2) {

	}

	@Override
	public void execDetailsEnd(int arg0) {

	}

	@Override
	public void fundamentalData(int arg0, String arg1) {

	}

	@Override
	public void historicalData(int arg0, String arg1, double arg2, double arg3, double arg4, double arg5, int arg6, int arg7,
			double arg8, boolean arg9) {

	}

	@Override
	public void managedAccounts(String arg0) {

	}

	@Override
	public void marketDataType(int arg0, int arg1) {

	}

	@Override
	public void nextValidId(int arg0) {

	}

	@Override
	public void openOrder(int arg0, Contract arg1, Order arg2, OrderState arg3) {

	}

	@Override
	public void openOrderEnd() {

	}

	@Override
	public void positionEnd() {

	}

	@Override
	public void realtimeBar(int arg0, long arg1, double arg2, double arg3, double arg4, double arg5, long arg6, double arg7,
			int arg8) {

	}

	@Override
	public void receiveFA(int arg0, String arg1) {

	}

	@Override
	public void scannerData(int arg0, int arg1, ContractDetails arg2, String arg3, String arg4, String arg5, String arg6) {

	}

	@Override
	public void scannerDataEnd(int arg0) {

	}

	@Override
	public void scannerParameters(String arg0) {

	}

	@Override
	public void tickEFP(int arg0, int arg1, double arg2, String arg3, double arg4, int arg5, String arg6, double arg7,
			double arg8) {

	}

	@Override
	public void tickGeneric(int arg0, int arg1, double arg2) {

	}

	@Override
	public void tickOptionComputation(int arg0, int arg1, double arg2, double arg3, double arg4, double arg5, double arg6,
			double arg7, double arg8, double arg9) {

	}

	@Override
	public void tickPrice(int arg0, int arg1, double arg2, int arg3) {

	}

	@Override
	public void tickSize(int arg0, int arg1, int arg2) {

	}

	@Override
	public void tickSnapshotEnd(int arg0) {

	}

	@Override
	public void tickString(int arg0, int arg1, String arg2) {

	}

	@Override
	public void updateAccountTime(String arg0) {

	}

	@Override
	public void updateAccountValue(String arg0, String arg1, String arg2, String arg3) {

	}

	@Override
	public void updateMktDepth(int arg0, int arg1, int arg2, int arg3, double arg4, int arg5) {

	}

	@Override
	public void updateMktDepthL2(int arg0, int arg1, String arg2, int arg3, int arg4, double arg5, int arg6) {

	}

	@Override
	public void updateNewsBulletin(int arg0, int arg1, String arg2, String arg3) {

	}


	@Override
	public void verifyAndAuthCompleted(boolean arg0, String arg1) {

	}

	@Override
	public void verifyAndAuthMessageAPI(String arg0, String arg1) {

	}

	@Override
	public void verifyCompleted(boolean arg0, String arg1) {

	}

	@Override
	public void verifyMessageAPI(String arg0) {

	}

	@Override
	public void accountUpdateMulti(int arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
		// TODO Auto-generated method stub

	}

	@Override
	public void accountUpdateMultiEnd(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void orderStatus(int arg0, String arg1, double arg2, double arg3, double arg4, int arg5, int arg6, double arg7,
			int arg8, String arg9) {
		// TODO Auto-generated method stub

	}

	@Override
	public void position(String arg0, Contract arg1, double arg2, double arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void positionMulti(int arg0, String arg1, String arg2, Contract arg3, double arg4, double arg5) {
		// TODO Auto-generated method stub

	}

	@Override
	public void positionMultiEnd(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void securityDefinitionOptionalParameter(int arg0, String arg1, int arg2, String arg3, String arg4, Set<String> arg5,
			Set<Double> arg6) {
		// TODO Auto-generated method stub

	}

	@Override
	public void securityDefinitionOptionalParameterEnd(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePortfolio(Contract arg0, double arg1, double arg2, double arg3, double arg4, double arg5, double arg6,
			String arg7) {
		// TODO Auto-generated method stub

	}

	@Override
	public void softDollarTiers(int arg0, SoftDollarTier[] arg1) {
		// TODO Auto-generated method stub

	}
}
