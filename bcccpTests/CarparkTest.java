package bcccpTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bcccp.carpark.Carpark;
import bcccp.tickets.season.ISeasonTicketDAO;
import bcccp.tickets.season.SeasonTicket;
import bcccp.tickets.season.SeasonTicketDAO;

public class CarparkTest {

	
	 
	 @Test(expected = Exception.class)
	 public void ownerNameNullOrEmpty() throws Exception 
	 {
		  Carpark carpark = new Carpark("",100,null,null);
		  Carpark carpark2 = new Carpark(null,100,null,null);
	 }
	 
	 @Test(expected = Exception.class)
	 public void capacityZeroOrLesser() throws Exception 
	 {
		  Carpark carpark = new Carpark("my parking",0,null,null);
		  Carpark carpark2 = new Carpark("my parking",-10,null,null);
	 }
	 
	 
}
