import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;


public class StockTableModelTest {
	private StockItem item1;
	private Long id1;
	private String nimi;
	private double hind;
	private int kogus;
	private StockItem item2;
	private Long id2;
	private StockTableModel tabel;
	
	@Before
	public void SetUp(){
		id1 = new Long(667);
		nimi = "Table-item-667";
		hind = 10.0;
		kogus = 5;
		id2 = new Long(668);
		item1 = new StockItem(id1, nimi,"kirjeldus",hind,kogus);
		item2 = new StockItem(id2, "Table-item-668", "kirjeldus", 15.0, 4);
		tabel = new StockTableModel();
		tabel.addItem(item1);
	}
	
	@Test
	public void testValidateNameUniqueness(){
		assertEquals("Kas nimi on tabelis olemas?",item1,tabel.getItemByName(nimi));
	}
	
	@Ignore
	public void testHasEnoughInStock(){
		// How much is enough?
		
	}
	
	@Test
	public void testGetItemByIdWhenItemExists(){
		assertEquals("Kui asi on olemas, id järgi otsimine",item1,tabel.getItemById(id1));
	}
	
	@Test (expected = NoSuchElementException.class) 
	public void testGetItemByIdWhenThrowsException(){
		assertEquals("Kui id-d pole tabelis", item2, tabel.getItemById(id2));
	}
}
