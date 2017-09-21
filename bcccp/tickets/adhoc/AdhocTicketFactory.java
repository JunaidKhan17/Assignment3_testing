package bcccp.tickets.adhoc;

public class AdhocTicketFactory implements IAdhocTicketFactory {

	@Override
	public IAdhocTicket make(String carparkId, int ticketNo) {
		
		if(carparkId==null || carparkId.equals(""))
			throw new RuntimeException("carkparkID cannot be null or empty");
		
		if(ticketNo<=0)
			throw new RuntimeException("ticketNo cannot be zero or lesser");
		
		String barcode = "A" + Integer.toHexString(ticketNo);
		return new AdhocTicket(carparkId, ticketNo, barcode);
	}

}
