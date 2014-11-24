import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;


public class StockItemTest {
	private StockItem item1;
	//private StockItem item2;
	private Long id1;
	//private Long id2;
	
	@Before
	public void SetUp() {
		id1 = new Long(777);
		//id2 = new Long(778);
		item1 = new StockItem(id1, "Test-stock1", "teststock1", 11.0, 3);
		//item2 = new StockItem(id2, "Test-stock2", "teststock2", 12.0, 3);
	}
	
	@Test
	public void testClone(){
		assertSame(item1,item1.clone());
	}
	
	@Test
	public void testGetColumn(){
		
	}
}
