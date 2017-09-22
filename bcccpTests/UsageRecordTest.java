package bcccpTests;

import org.junit.Test;

import bcccp.tickets.season.SeasonTicket;
import bcccp.tickets.season.UsageRecord;

public class UsageRecordTest {

	 @Test(expected = RuntimeException.class)
	 public void ticketIdEmpty() throws Exception 
	 {
		 UsageRecord usageRecord = new UsageRecord("",100);
	 }
	 
	 @Test(expected = RuntimeException.class)
	 public void startTimeLessThanZero() throws Exception 
	 {
		 UsageRecord usageRecord = new UsageRecord("A30",-100);
	 }
	 
	 @Test(expected = RuntimeException.class)
	 public void finaliseTimeLessThanZero() throws Exception 
	 {
		 UsageRecord usageRecord = new UsageRecord("A30",100);
		 usageRecord.finalise(0);
	 }
	 
}
