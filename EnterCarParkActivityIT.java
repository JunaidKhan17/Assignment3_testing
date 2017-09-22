package bcccpTestsIT;

import static org.junit.Assert.*;

import java.awt.EventQueue;

import org.junit.Test;

import bcccp.carpark.CarSensor;
import bcccp.carpark.Carpark;
import bcccp.carpark.Gate;
import bcccp.carpark.entry.EntryController;
import bcccp.carpark.entry.EntryUI;
import bcccp.carpark.exit.ExitController;
import bcccp.carpark.exit.ExitUI;
import bcccp.carpark.paystation.PaystationController;
import bcccp.carpark.paystation.PaystationUI;
import bcccp.tickets.adhoc.AdhocTicketDAO;
import bcccp.tickets.adhoc.AdhocTicketFactory;
import bcccp.tickets.adhoc.IAdhocTicket;
import bcccp.tickets.adhoc.IAdhocTicketDAO;
import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.ISeasonTicketDAO;
import bcccp.tickets.season.SeasonTicket;
import bcccp.tickets.season.SeasonTicketDAO;
import bcccp.tickets.season.UsageRecordFactory;

public class EnterCarParkActivityIT {

	
	@Test
	public void carParkOnlySeasonTicketfull() throws Exception
	{
		CarSensor eos = new CarSensor("Entry Outside Sensor", 20, 100);
		Gate egate = new Gate(20, 320);
		CarSensor eis = new CarSensor("Entry Inside Sensor", 20, 440);
		EntryUI eui = new EntryUI(320, 100);	
		
		PaystationUI pui = new PaystationUI(660, 100);
		
		ExitUI xui = new ExitUI(1000, 100);	
		CarSensor xis = new CarSensor("Exit Inside Sensor", 1330, 100);
		Gate xgate = new Gate(1330, 320);
		CarSensor xos = new CarSensor("Exit Outside Sensor", 1330, 440);
		
		IAdhocTicketDAO adhocTicketDAO = new AdhocTicketDAO(new AdhocTicketFactory());
		ISeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO(new UsageRecordFactory());
		
		Carpark carpark = new Carpark("Bathurst Chase", 2, adhocTicketDAO, seasonTicketDAO);
		
		ISeasonTicket t1 = new SeasonTicket("S1111","Bathurst Chase", 1L, 5L);
		ISeasonTicket t2 = new SeasonTicket("S2222","Bathurst Chase", 1L, 5L);
		ISeasonTicket t3 = new SeasonTicket("S3333","Bathurst Chase", 1L, 5L);
		
		carpark.registerSeasonTicket(t1);
		carpark.registerSeasonTicket(t2);

		carpark.recordSeasonTicketEntry(t1.getId());
		carpark.recordSeasonTicketEntry(t2.getId());
		
		
		assertEquals("carParkfull",true,carpark.isFull());
		
		@SuppressWarnings("unused")
		EntryController entryController = 
				new EntryController(carpark, egate, eos, eis, eui);
		
		@SuppressWarnings("unused")
		PaystationController payController = 
				new PaystationController(carpark, pui);
		
		@SuppressWarnings("unused")
		ExitController exitController = 
		new ExitController(carpark, xgate, xis, xos, xui);
		
		eos.setVisible(true);
		egate.setVisible(true);
		eis.setVisible(true);
		eui.setVisible(true);
		
		pui.setVisible(true);
		
		xui.setVisible(true);
		xis.setVisible(true);
		xgate.setVisible(true);
		xos.setVisible(true);

					
	}
	
	//use case 7.4
	@Test
	public void carParkOnlyAdhocTicketfull() throws Exception
	{
		CarSensor eos = new CarSensor("Entry Outside Sensor", 20, 100);
		Gate egate = new Gate(20, 320);
		CarSensor eis = new CarSensor("Entry Inside Sensor", 20, 440);
		EntryUI eui = new EntryUI(320, 100);	
		
		PaystationUI pui = new PaystationUI(660, 100);
		
		ExitUI xui = new ExitUI(1000, 100);	
		CarSensor xis = new CarSensor("Exit Inside Sensor", 1330, 100);
		Gate xgate = new Gate(1330, 320);
		CarSensor xos = new CarSensor("Exit Outside Sensor", 1330, 440);
		
		IAdhocTicketDAO adhocTicketDAO = new AdhocTicketDAO(new AdhocTicketFactory());
		ISeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO(new UsageRecordFactory());
		
		Carpark carpark = new Carpark("Bathurst Chase", 50, adhocTicketDAO, seasonTicketDAO);
		
			
		for(int i=0;i<50;i++)
		{
			//issue adhoc tickets 50 times
			IAdhocTicket ticket = carpark.issueAdhocTicket();
			carpark.recordAdhocTicketEntry();
			ticket.pay(System.currentTimeMillis(), 5.0f);
			System.out.println("Adhoc Ticket number - " + ticket.getTicketNo());
		}
		
		
		assertTrue("carPark is full",carpark.isFull());
		
		@SuppressWarnings("unused")
		EntryController entryController = 
				new EntryController(carpark, egate, eos, eis, eui);
		
		@SuppressWarnings("unused")
		PaystationController payController = 
				new PaystationController(carpark, pui);
		
		@SuppressWarnings("unused")
		ExitController exitController = 
		new ExitController(carpark, xgate, xis, xos, xui);
		
		eos.setVisible(true);
		egate.setVisible(true);
		eis.setVisible(true);
		eui.setVisible(true);
		
		pui.setVisible(true);
		
		xui.setVisible(true);
		xis.setVisible(true);
		xgate.setVisible(true);
		xos.setVisible(true);

					
	}

	//use case 7.2
	@Test
	public void seasonTicketCustomerSuccessfulEntry() throws Exception
	{
		CarSensor eos = new CarSensor("Entry Outside Sensor", 20, 100);
		Gate egate = new Gate(20, 320);
		CarSensor eis = new CarSensor("Entry Inside Sensor", 20, 440);
		EntryUI eui = new EntryUI(320, 100);	
		
		PaystationUI pui = new PaystationUI(660, 100);
		
		ExitUI xui = new ExitUI(1000, 100);	
		CarSensor xis = new CarSensor("Exit Inside Sensor", 1330, 100);
		Gate xgate = new Gate(1330, 320);
		CarSensor xos = new CarSensor("Exit Outside Sensor", 1330, 440);
		
		IAdhocTicketDAO adhocTicketDAO = new AdhocTicketDAO(new AdhocTicketFactory());
		ISeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO(new UsageRecordFactory());
		
		Carpark carpark = new Carpark("Bathurst Chase", 100, adhocTicketDAO, seasonTicketDAO);
		
		ISeasonTicket t1 = new SeasonTicket("S1111","Bathurst Chase", 1L, 5L);
		
		carpark.registerSeasonTicket(t1);
		carpark.recordSeasonTicketEntry(t1.getId());
		
		//test case here
		assertTrue(carpark.isSeasonTicketValid(t1.getId()));
		assertTrue(t1.inUse());
		assertEquals("Testing valid time",5,t1.getEndValidPeriod());
		assertEquals("Number of season tickets is 1",1,seasonTicketDAO.getNumberOfTickets());
		
		
		@SuppressWarnings("unused")
		EntryController entryController = 
				new EntryController(carpark, egate, eos, eis, eui);
		
		@SuppressWarnings("unused")
		PaystationController payController = 
				new PaystationController(carpark, pui);
		
		@SuppressWarnings("unused")
		ExitController exitController = 
		new ExitController(carpark, xgate, xis, xos, xui);
		
		eos.setVisible(true);
		egate.setVisible(true);
		eis.setVisible(true);
		eui.setVisible(true);
		
		pui.setVisible(true);
		
		xui.setVisible(true);
		xis.setVisible(true);
		xgate.setVisible(true);
		xos.setVisible(true);

					
	}
	
	//use case 7.1
	@Test
	public void adhocTicketCustomerSuccessfulEntry() throws Exception
	{
		CarSensor eos = new CarSensor("Entry Outside Sensor", 20, 100);
		Gate egate = new Gate(20, 320);
		CarSensor eis = new CarSensor("Entry Inside Sensor", 20, 440);
		EntryUI eui = new EntryUI(320, 100);	
		
		PaystationUI pui = new PaystationUI(660, 100);
		
		ExitUI xui = new ExitUI(1000, 100);	
		CarSensor xis = new CarSensor("Exit Inside Sensor", 1330, 100);
		Gate xgate = new Gate(1330, 320);
		CarSensor xos = new CarSensor("Exit Outside Sensor", 1330, 440);
		
		IAdhocTicketDAO adhocTicketDAO = new AdhocTicketDAO(new AdhocTicketFactory());
		ISeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO(new UsageRecordFactory());
		
		Carpark carpark = new Carpark("Bathurst Chase", 100, adhocTicketDAO, seasonTicketDAO);
		
		IAdhocTicket ticket = carpark.issueAdhocTicket();
		carpark.recordAdhocTicketEntry();
		ticket.pay(System.currentTimeMillis(), 5.0f);
	
		
		//test case here
		assertTrue("The ticket charge is 5.0",5==ticket.getCharge());
		assertEquals("The barcode valus is expected to be A3130","A3130",ticket.getBarcode());
		assertEquals("The ticket number is 1",1,ticket.getTicketNo());
		
		assertTrue("The ticket is already paid", ticket.isPaid());
		assertEquals("The number of tickets issued is 1",1,adhocTicketDAO.getCurrentTickets().size());
	
		
		@SuppressWarnings("unused")
		EntryController entryController = 
				new EntryController(carpark, egate, eos, eis, eui);
		
		@SuppressWarnings("unused")
		PaystationController payController = 
				new PaystationController(carpark, pui);
		
		@SuppressWarnings("unused")
		ExitController exitController = 
		new ExitController(carpark, xgate, xis, xos, xui);
		
		eos.setVisible(true);
		egate.setVisible(true);
		eis.setVisible(true);
		eui.setVisible(true);
		
		pui.setVisible(true);
		
		xui.setVisible(true);
		xis.setVisible(true);
		xgate.setVisible(true);
		xos.setVisible(true);

					
	}
	
	//use case 7.3
	@Test
	public void invalidSeasonTicketHolder() throws Exception
	{
		CarSensor eos = new CarSensor("Entry Outside Sensor", 20, 100);
		Gate egate = new Gate(20, 320);
		CarSensor eis = new CarSensor("Entry Inside Sensor", 20, 440);
		EntryUI eui = new EntryUI(320, 100);	
		
		PaystationUI pui = new PaystationUI(660, 100);
		
		ExitUI xui = new ExitUI(1000, 100);	
		CarSensor xis = new CarSensor("Exit Inside Sensor", 1330, 100);
		Gate xgate = new Gate(1330, 320);
		CarSensor xos = new CarSensor("Exit Outside Sensor", 1330, 440);
		
		IAdhocTicketDAO adhocTicketDAO = new AdhocTicketDAO(new AdhocTicketFactory());
		ISeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO(new UsageRecordFactory());
		
		Carpark carpark = new Carpark("Bathurst Chase", 100, adhocTicketDAO, seasonTicketDAO);
		
		ISeasonTicket t1 = new SeasonTicket("S1111","Bathurst Chase", 1L, 5L);
		ISeasonTicket t2 = new SeasonTicket("S2222","Bathurst Chase", 1L, 5L);
		
		carpark.registerSeasonTicket(t1);
		carpark.recordSeasonTicketEntry(t1.getId());
		
		//test case here
		//the season ticket t2 is not registered with the carpark
		//so this should be an invalid ticket
		assertFalse(carpark.isSeasonTicketValid(t2.getId()));
		

		@SuppressWarnings("unused")
		EntryController entryController = 
				new EntryController(carpark, egate, eos, eis, eui);
		
		@SuppressWarnings("unused")
		PaystationController payController = 
				new PaystationController(carpark, pui);
		
		@SuppressWarnings("unused")
		ExitController exitController = 
		new ExitController(carpark, xgate, xis, xos, xui);
		
		eos.setVisible(true);
		egate.setVisible(true);
		eis.setVisible(true);
		eui.setVisible(true);
		
		pui.setVisible(true);
		
		xui.setVisible(true);
		xis.setVisible(true);
		xgate.setVisible(true);
		xos.setVisible(true);

					
	}
	
}
