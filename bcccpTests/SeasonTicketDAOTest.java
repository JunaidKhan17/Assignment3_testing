package bcccpTests;

import org.junit.Test;

import bcccp.tickets.season.SeasonTicket;
import bcccp.tickets.season.SeasonTicketDAO;
import bcccp.tickets.season.UsageRecordFactory;

public class SeasonTicketDAOTest {

	@Test(expected = RuntimeException.class)
	 public void nullFactory() throws Exception 
	 {
		 SeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO(null);
	 }
	
	@Test(expected = RuntimeException.class)
	 public void nullTicketRegister() throws Exception 
	 {
		 SeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO(new UsageRecordFactory());
		 seasonTicketDAO.registerTicket(null);
	 }
	
	@Test(expected = RuntimeException.class)
	 public void nullTicketDeregister() throws Exception 
	 {
		 SeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO(new UsageRecordFactory());
		 seasonTicketDAO.deregisterTicket(null);
	 }
	
	@Test
	public void recordTicketEntry()
	{
		 SeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO(new UsageRecordFactory());
		 SeasonTicket seasonTicket = new SeasonTicket("A3","myPark",100,200);
		 seasonTicketDAO.registerTicket(seasonTicket);
		 seasonTicketDAO.recordTicketEntry(seasonTicket.getId());
		 
	}
	
	@Test
	public void recordTicketExit()
	{
		 SeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO(new UsageRecordFactory());
		 SeasonTicket seasonTicket = new SeasonTicket("A3","myPark",100,200);
		 seasonTicketDAO.registerTicket(seasonTicket);
		 seasonTicketDAO.recordTicketEntry(seasonTicket.getId());
		 seasonTicketDAO.recordTicketExit(seasonTicket.getId());
	}
	
	@Test(expected = RuntimeException.class)
	public void recordTicketExitNotInUse()
	{
		 SeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO(new UsageRecordFactory());
		 SeasonTicket seasonTicket = new SeasonTicket("A3","myPark",100,200);
		 seasonTicketDAO.registerTicket(seasonTicket);
		 //the entry is not recorded, so it should fail
		 seasonTicketDAO.recordTicketExit(seasonTicket.getId());
	}


}
