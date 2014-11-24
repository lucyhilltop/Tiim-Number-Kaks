import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.ui.model.HistoryTableModel;


public class HistoryTableModelTest {
	private String date;
	private String time1;
	private double total1;
	private HistoryItem item1;
	private HistoryItem item2;
	private String time2;
	private double total2;
	private HistoryTableModel table;
	
	@Before
	public void SetUp(){
		date = new String("24/11/14");
		time1 = new String("08:20:00");
		time2 = new String("09:11:23");
		total2 = 23.0;
		total1 = 100.0;
		item1 = new HistoryItem(date,time1,total1);
		item2 = new HistoryItem(date, time2, total2);
		table = new HistoryTableModel();
		table.addHistory(item1);
		table.addHistory(item2);
	}
	
	@Test
	public void GetRowCountTest(){
		assertEquals(2,table.getRowCount());
	}
	
	@Test
	public void testGetColumn(){
		assertEquals(date, item1.getColumn(0));
		assertEquals(time1, item1.getColumn(1));
		assertEquals(total1,item1.getColumn(2));
	}
	
	@Test (expected = RuntimeException.class) 
	public void testGetColumnWhenException (){
		item1.getColumn(3);
	}

	@Test 
	public void testGetValueAt(){
		assertEquals(23.0,table.getValueAt(1,2));
	}
}
