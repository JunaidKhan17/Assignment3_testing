package bcccpTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bcccp.carpark.Carpark;
import bcccp.tickets.adhoc.AdhocTicket;

public class AdhocTicketTest {

	
	 @Test(expected = RuntimeException.class)
	 public void ticketIdLessThanZero() throws Exception 
	 {
		 AdhocTicket adhocTicket = new AdhocTicket("mycarparking",-1,"A10");
	 }
	 
	 
	 @Test(expected = RuntimeException.class)
	 public void barcodeNullOrEmpty() throws Exception 
	 {
		 AdhocTicket adhocTicket = new AdhocTicket("mycarparking",10,"");
	 }
	 
	 
	 @Test(expected = RuntimeException.class)
	 public void carParkNameNullOrEmpty() throws Exception 
	 {
		 AdhocTicket adhocTicket = new AdhocTicket("",10,"A10");
	 }
	 
	 @Test
	 public void testBarCodeValue()
	 {
		 AdhocTicket adhocTicket = new AdhocTicket("e",10,"A10");
		 assertEquals("Barcode","A313030",adhocTicket.getBarcode());
		 
	 }
	 
	 @Test(expected = RuntimeException.class)
	 public void carEntryTimeLessThanZero() throws Exception 
	 {
		 AdhocTicket adhocTicket = new AdhocTicket("myParking",10,"A10");
		 adhocTicket.enter(-1);
	 }
	 
	 @Test(expected = RuntimeException.class)
	 public void paidBeforeEntryTime() throws Exception 
	 {
		 AdhocTicket adhocTicket = new AdhocTicket("myParking",10,"A10");
		 adhocTicket.enter(500);
		 adhocTicket.pay(300, 6);
	 }
	 
	 @Test(expected = RuntimeException.class)
	 public void exirBeforePaid() throws Exception 
	 {
		 AdhocTicket adhocTicket = new AdhocTicket("myParking",10,"A10");
		 adhocTicket.enter(100);
		 adhocTicket.pay(300, 6);
		 adhocTicket.exit(250);
	 }
	  
}
