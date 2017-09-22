package bcccpTests;

import org.junit.Test;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.IGate;
import bcccp.carpark.entry.EntryController;
import bcccp.carpark.entry.IEntryUI;
import bcccp.tickets.adhoc.AdhocTicket;
import bcccp.tickets.adhoc.AdhocTicketDAO;
import bcccp.tickets.adhoc.AdhocTicketFactory;
import bcccp.tickets.season.SeasonTicket;
import bcccp.tickets.season.SeasonTicketDAO;
import bcccp.tickets.season.UsageRecordFactory;



public class EntryControllerTest {

	 @Test(expected = RuntimeException.class)
	 public void EntryControllerHasANullParameter() throws Exception 
	 {
		 EntryController entryController = new EntryController(null,null,null,null,null);
	 }
	 
	 @Test
	 public void EntryControllercheckState() throws Exception 
	 {
		 AdhocTicketFactory adhocTicketFactory = new AdhocTicketFactory();
		 UsageRecordFactory usageTicketFactory = new UsageRecordFactory();
		 
		 AdhocTicketDAO adhocTicketDAO = new AdhocTicketDAO(adhocTicketFactory);
		 SeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO(usageTicketFactory);
		 Carpark carpark = new Carpark("my parking",10,adhocTicketDAO,seasonTicketDAO);
		 
	 }
}
