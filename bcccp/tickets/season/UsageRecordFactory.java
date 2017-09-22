package bcccp.tickets.season;

public class UsageRecordFactory implements IUsageRecordFactory {

	@Override
	public IUsageRecord make(String ticketId, long startDateTime) {
		
		if(ticketId==null || ticketId.equals(""))
			throw new RuntimeException("ticketId cannot be null or empty");
		
		if(startDateTime<=0)
			throw new RuntimeException("startDateTime cannot be zero or lesser");
		
		return new UsageRecord(ticketId, startDateTime);
	}

}
