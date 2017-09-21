package bcccp.tickets.season;

public class UsageRecord implements IUsageRecord {
	
	String ticketId;
	long startDateTime;
	long endDateTime;
	
	
	
	public UsageRecord(String ticketId, long startDateTime) {
		
		if(ticketId==null || ticketId.equals(""))
			throw new RuntimeException("ticketId cannot be empty or null");
		
		if(startDateTime<=0)
			throw new RuntimeException("startDateTime cannot be less than or equal to zero");
		
		this.ticketId = ticketId;
		this.startDateTime = startDateTime;
	}
	
	
	
	public void finalise(long endDateTime) {
		
		if(endDateTime<=0)
			throw new RuntimeException("endDateTime cannot be less than or equal to zero");
		
		this.endDateTime = endDateTime;
	}
	
	
	
	@Override
	public long getStartTime() {
		return startDateTime;
	}



	@Override
	public long getEndTime() {
		return endDateTime;
	}



	@Override
	public String getSeasonTicketId() {
		return ticketId;
	}

	
	
	public String toString() {
		return ("Usage : startDateTime : " + startDateTime + ", endDateTime: " + endDateTime);
	}




}
