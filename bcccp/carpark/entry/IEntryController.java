package bcccp.carpark.entry;

public interface IEntryController {
	
	public void buttonPushed() throws Exception;
	public void ticketInserted(String barcode);
	public void ticketTaken();
 
}
