package bcccp.tickets.adhoc;

import java.util.Date;

public class AdhocTicket implements IAdhocTicket {
	
	private String carparkId_;
	private int ticketNo_;
	private long entryDateTime;
	private long paidDateTime;
	private long exitDateTime;
	private float charge;
	private String barcode;
	private STATE state_;
	
	private enum STATE { ISSUED, CURRENT, PAID, EXITED }

	
	
	public AdhocTicket(String carparkId, int ticketNo, String barcode) {
		
		if(ticketNo < 0)
			throw new RuntimeException("Ticket number cannot be less than 0");
		
		if(barcode==null || barcode.equals(""))
			throw new RuntimeException("Barcode cannot be empty or null");
		
		if(carparkId==null || carparkId.equals(""))
			throw new RuntimeException("carparkId cannot be empty or null");
		
		
		this.carparkId_ = carparkId;
		this.ticketNo_ = ticketNo;
		this.barcode = barcode;
		this.state_ = STATE.ISSUED;		
	}

	
	
	@Override
	public String getBarcode() {
		
		String barcodeReturn = "A" + javax.xml.bind.DatatypeConverter.printHexBinary(("" + ticketNo_).getBytes());
		barcodeReturn = barcodeReturn + javax.xml.bind.DatatypeConverter.printHexBinary(("" + entryDateTime).getBytes());
		return barcodeReturn;
		
	}


	
	@Override
	public String getCarparkId() {
		return carparkId_;
	}

	
	
	@Override
	public int getTicketNo() {
		return ticketNo_;
	}
	

	
	@Override
	public void enter(long entryDateTime) {
		
		if(entryDateTime<0)
			throw new RuntimeException("Entry time cannot be zero or lesser");
		
		this.entryDateTime = entryDateTime;
		this.state_ = STATE.CURRENT;		
	}
	
	
	
	@Override
	public long getEntryDateTime() {
		return entryDateTime;
	}

	
	
	@Override
	public void pay(long paidDateTime, float charge) {
		
		if(paidDateTime < entryDateTime)
			throw new RuntimeException("Paid before entry time");
		
		this.paidDateTime = paidDateTime;
		this.charge = charge;
		state_ = STATE.PAID;
	}
	
	
	
	@Override
	public long getPaidDateTime() {
		return paidDateTime;
	}



	@Override
	public float getCharge() {
		return charge;
	}

	
	
	public String toString() {
		Date entryDate = new Date(entryDateTime);
		Date paidDate = new Date(paidDateTime);
		Date exitDate = new Date(exitDateTime);

		return "Carpark    : " + carparkId_ + "\n" +
		       "Ticket No  : " + ticketNo_ + "\n" +
		       "Entry Time : " + entryDate + "\n" + 
		       "Paid Time  : " + paidDate + "\n" + 
		       "Exit Time  : " + exitDate + "\n" +
		       "State      : " + state_ + "\n" +
		       "Barcode    : " + barcode;		
	}



	@Override
	public boolean isCurrent() {
		return state_ == STATE.CURRENT;
	}



	@Override
	public boolean isPaid() {
		return state_ == STATE.PAID;
	}



	@Override
	public void exit(long dateTime) {
		if(paidDateTime > dateTime)
			throw new RuntimeException("Exit before paid time");
		
		exitDateTime = dateTime;
		state_ = STATE.EXITED;
	}



	@Override
	public long getExitDateTime() {
		return exitDateTime;
	}



	@Override
	public boolean hasExited() {
		return state_ == STATE.EXITED;
	}


}
