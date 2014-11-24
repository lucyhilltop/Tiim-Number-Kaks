import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;


public class PurchaseInfoTableModelTest {
	private SoldItem item1;
	private Long id1;
	private String nimi;
	private double hind;
	private int kogus;
	private SoldItem item2;
	private Long id2;
	private int count = 0;
	private double summa = 0;
	private PurchaseInfoTableModel tabel;

	
	@Before
	public void SetUp(){
		id1 = new Long(669);
		id2 = new Long(670);
		nimi = "Solditem1";
		hind = 13.0;
		kogus = 5;
		item1 = new SoldItem(new StockItem(id1,nimi,"solditem1",hind), kogus);
		item2 = new SoldItem(new StockItem(id2, "Solditem2", "solditem2", 10.0), kogus);
		tabel = new PurchaseInfoTableModel();
	}
	
	@Test
	public void testAddSoldItem() {
		tabel.addItem(item1);
		assertEquals(count+1,tabel.getRowCount());
	}
	
	//Kuna kusagile peaks ilmselt need meetodid panema...
	
	@Test
	public void testGetSumWithNoItems(){
		for (final SoldItem item : tabel.rows){
			summa = summa + item.getSum();
		}
		assertEquals(0.0, summa, 0.0001);
	}
	
	@Test
	public void testGetSumWithOneItem(){
		tabel.addItem(item1);
		for (final SoldItem item : tabel.rows){
			summa = summa + item.getSum();
		}
		assertEquals(65.0, summa, 0.0001);
	}
	
	@Test
	public void testGetSumWithMultipleItems(){
		tabel.addItem(item1);
		tabel.addItem(item2);
		for (final SoldItem item : tabel.rows){
			summa = summa + item.getSum();
		}
		assertEquals(115.0, summa, 0.0001);
	}

}
