package bcccpTests;

import org.junit.Test;

import bcccp.tickets.adhoc.AdhocTicket;
import bcccp.tickets.adhoc.AdhocTicketDAO;

public class AdhocTicketDAOTest {

	 @Test(expected = RuntimeException.class)
	 public void nullFactory() throws Exception 
	 {
		 AdhocTicketDAO adhocTicketDAO = new AdhocTicketDAO(null);
	 }
}
