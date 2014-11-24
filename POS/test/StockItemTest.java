import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;


public class StockItemTest {
	private StockItem item1;
	//private StockItem item2;
	private Long id1;
	private String nimi;
	private String desc;
	private double hind;
	private int kogus;
	//private Long id2;
	
	@Before
	public void SetUp() {
		id1 = new Long(777);
		//id2 = new Long(778);
		nimi = "Test-stock1";
		desc = "teststock1";
		hind = 11.0;
		kogus = 3;
		item1 = new StockItem(id1, nimi, desc, hind, kogus);
		//item2 = new StockItem(id2, "Test-stock2", "teststock2", 12.0, 3);
	}
	
	/*@Test
	public void testClone(){
		assertEquals(item1,item1.clone());
	}*/
	
	@Test
	public void testGetColumn(){
		assertEquals(id1, item1.getColumn(0));
		assertEquals(nimi, item1.getColumn(1));
		assertEquals(hind,item1.getColumn(2));
		assertEquals(kogus,item1.getColumn(3));
	}
	
	@Test (expected = RuntimeException.class)
	public void testGetColumnError(){
		item1.getColumn(4);
	}
}
