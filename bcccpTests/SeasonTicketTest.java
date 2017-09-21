package bcccpTests;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import bcccp.tickets.adhoc.AdhocTicket;
import bcccp.tickets.season.IUsageRecord;
import bcccp.tickets.season.SeasonTicket;

public class SeasonTicketTest {
	
	 @Test(expected = RuntimeException.class)
	 public void ticketIdEmpty() throws Exception 
	 {
		 SeasonTicket seasonTicket = new SeasonTicket("","myCarParking",100,500);
	 }
	 
	 @Test(expected = RuntimeException.class)
	 public void parkingIdEmpty() throws Exception 
	 {
		 SeasonTicket seasonTicket = new SeasonTicket("A10","",100,500);
	 }
	 
	 @Test(expected = RuntimeException.class)
	 public void invalidStartDate() throws Exception 
	 {
		 SeasonTicket seasonTicket = new SeasonTicket("A10","myParking",0,500);
	 }

	 @Test(expected = RuntimeException.class)
	 public void endvalidLesserStartDate() throws Exception 
	 {
		 SeasonTicket seasonTicket = new SeasonTicket("A10","myParking",600,500);
	 }

	 
}