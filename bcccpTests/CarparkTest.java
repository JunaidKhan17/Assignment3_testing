package bcccpTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bcccp.carpark.Carpark;

public class CarparkTest {

	 @Test
	    public void ownerNameNullOrEmpty() {
	        Carpark carpark = new Carpark("myparking",100,null,null);

	        assertEquals("Parking name should be myparking", "myparking", carpark.getName());
	    }
}
