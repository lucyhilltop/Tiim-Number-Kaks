import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;


public class HistoryItemTest {
	private String Date;
	private String Time;
	private double total;
	private HistoryItem item1;
	
	@Before
	public void setUp(){
		Date = new String("24/11/14");
		Time = new String("08:20:00");
		total = 100.0;
		item1 = new HistoryItem(Date,Time,total);
	
	}
	
	@Test
	public void testGetColumn(){
		assertEquals(Date, item1.getColumn(0));
		assertEquals(Time, item1.getColumn(1));
		assertEquals(total,item1.getColumn(2));
	}
	
	@Test (expected = RuntimeException.class) 
	public void testGetColumnWhenException (){
		item1.getColumn(3);
	}
}

