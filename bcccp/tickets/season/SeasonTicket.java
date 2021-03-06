package bcccp.tickets.season;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeasonTicket implements ISeasonTicket {
	
	private List<IUsageRecord> usages;
	private IUsageRecord currentUsage = null;
	
	private String ticketId;
	private String carparkId;
	private long startValidPeriod;
	private long endValidPeriod;
	
	public SeasonTicket (String ticketId, String carparkId, 
			             long startValidPeriod,
			             long endValidPeriod) {
		
		
		if(ticketId==null || ticketId.equals(""))
			throw new RuntimeException("ticketId cannot be empty or null");
		
		if(carparkId==null || carparkId.equals(""))
			throw new RuntimeException("carparkId cannot be empty or null");
		
		if(startValidPeriod<=0)
			throw new RuntimeException("Start Date cannot be less or equal to zero");
		
		if(endValidPeriod<=0 || (endValidPeriod<startValidPeriod))
			throw new RuntimeException("End Date cannot be less or equal to zero and it cannot be lesser than startPeriod");
			
		
		
		this.ticketId = ticketId;
		this.carparkId =carparkId;
		this.startValidPeriod = startValidPeriod;
		this.endValidPeriod = endValidPeriod;
		
		usages = new ArrayList<IUsageRecord>();
	}


	@Override
	public String getId() {
		return ticketId;
	}


	@Override
	public String getCarparkId() {
		return carparkId;
	}


	@Override
	public long getStartValidPeriod() {
		return startValidPeriod;
	}


	@Override
	public long getEndValidPeriod() {
		return endValidPeriod;
	}


	@Override
	public boolean inUse() {
		return currentUsage != null;
	}


	@Override
	public void recordUsage(IUsageRecord record) {
		currentUsage = record;
		if (!usages.contains(record) ) {
			usages.add(record);
		}
		
	}


	@Override
	public IUsageRecord getCurrentUsageRecord() {
		
		if(inUse())
			return currentUsage;
		else 
			return null;
	}


	@Override
	public List<IUsageRecord> getUsageRecords() {
		return Collections.unmodifiableList(usages);
	}


	@Override
	public void endUsage(long dateTime) {
		if (currentUsage == null) throw new RuntimeException("SeasonTicket.endUsage : ticket is not in use");
		
		currentUsage.finalise(dateTime);
		currentUsage = null;
		
	}


	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Carpark    : " + carparkId + "\n" +
		       "Ticket No  : " + ticketId + "\n" );
		for (IUsageRecord usage : usages) {
			builder.append(usage.toString() + "\n");
		}
		return builder.toString();
	}


}
