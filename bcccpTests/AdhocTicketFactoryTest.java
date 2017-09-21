package bcccpTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bcccp.tickets.adhoc.AdhocTicket;
import bcccp.tickets.adhoc.AdhocTicketDAO;
import bcccp.tickets.adhoc.AdhocTicketFactory;

public class AdhocTicketFactoryTest {

	@Test(expected = RuntimeException.class)
	 public void carParkEmpty() throws Exception 
	 {
		AdhocTicketFactory adhocTicketFactory = new AdhocTicketFactory();
		AdhocTicket ticket = (AdhocTicket) adhocTicketFactory.make("", 10);
	 }
	
	
	@Test(expected = RuntimeException.class)
	 public void ticketLessThanZero() throws Exception 
	 {
		AdhocTicketFactory adhocTicketFactory = new AdhocTicketFactory();
		AdhocTicket ticket = (AdhocTicket) adhocTicketFactory.make("myCarPark", -10);
	 }
	
	@Test
	public void validateTicket()
	{
		AdhocTicketFactory adhocTicketFactory = new AdhocTicketFactory();
		AdhocTicket ticket = (AdhocTicket) adhocTicketFactory.make("myCarPark", 10);
				
		assertEquals(ticket.getBarcode(),"A313030");
	}
}
