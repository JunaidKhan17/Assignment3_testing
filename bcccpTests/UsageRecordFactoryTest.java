package bcccpTests;

import org.junit.Test;

import bcccp.tickets.season.UsageRecord;
import bcccp.tickets.season.UsageRecordFactory;



public class UsageRecordFactoryTest {

	@Test(expected = RuntimeException.class)
	 public void ticketIDEmpty() throws Exception 
	 {
		UsageRecordFactory usageRecordFactory = new UsageRecordFactory();
		UsageRecord usageRecord = (UsageRecord) usageRecordFactory.make("", 100);
	 }
	
	
	@Test(expected = RuntimeException.class)
	 public void startTimeIsZero() throws Exception 
	 {
		UsageRecordFactory usageRecordFactory = new UsageRecordFactory();
		UsageRecord usageRecord = (UsageRecord) usageRecordFactory.make("A10", 0);
	 }
}
