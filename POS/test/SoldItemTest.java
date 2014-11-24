import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class SoldItemTest {
	private SoldItem item1;
	private StockItem stitem1;
	private Long id;
	private SoldItem item2;
	
	@Before
	public void setUp() {
		id = new Long(666);
	    stitem1 = new StockItem(id,"Vorst","vorst", 12.0);
		item1 = new SoldItem(stitem1, 3); 
		item2 = new SoldItem(stitem1, 0);
		}
	
	@Test
	public void testGetSum() {
		System.out.println(item1.getSum());
		assertEquals("Summa test",36.0,item1.getSum(),0.00001);
	}
	
	@Test
	public void testGetSumWithZeroQuantity(){
		System.out.println(item2.getSum());
		assertEquals("Kui kogus on null summa test",0,item2.getSum(),0.00001);
	}
}
