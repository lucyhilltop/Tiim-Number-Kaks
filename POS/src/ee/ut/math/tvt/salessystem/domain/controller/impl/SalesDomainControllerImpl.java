package ee.ut.math.tvt.salessystem.domain.controller.impl;

import java.util.ArrayList;
import java.util.List;

import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.HistoryTableModel;
import ee.ut.math.tvt.salessystem.ui.tabs.HistoryTab;
import ee.ut.math.tvt.salessystem.util.HibernateUtil;

/**
 * Implementation of the sales domain controller.
 */
public class SalesDomainControllerImpl implements SalesDomainController {
	
	HistoryTab ht;
	HistoryTableModel htm;
	
	public void submitCurrentPurchase(List<SoldItem> goods, double orderSum)
			throws VerificationFailedException {
		System.out.println("TEEN MIDAGI");
		String kuupaev = "Kuupaev";
		String aeg = "Aeg";
		System.out.println("KUUPAEVAD SATITUD");
		HistoryItem uus = new HistoryItem(kuupaev,aeg,15.0);
		System.out.println("UUS LOODUD");
		htm.addHistory(uus);
		// TODO Auto-generated method stub
		
	}

	public void cancelCurrentPurchase() throws VerificationFailedException {				
		// XXX - Cancel current purchase
	}
	

	public void startNewPurchase() throws VerificationFailedException {
		// XXX - Start new purchase
	}

	public List<StockItem> loadWarehouseState() {
		// XXX mock implementation
		List<StockItem> dataset = new ArrayList<StockItem>();

		StockItem chips = new StockItem(1l, "Lays chips", "Potato chips", 11.0, 5);
		StockItem chupaChups = new StockItem(2l, "Chupa-chups", "Sweets", 8.0, 8);
	    StockItem frankfurters = new StockItem(3l, "Frankfurters", "Beer sauseges", 15.0, 12);
	    StockItem beer = new StockItem(4l, "Free Beer", "Student's delight", 0.0, 100);

		dataset.add(chips);
		dataset.add(chupaChups);
		dataset.add(frankfurters);
		dataset.add(beer);

		return dataset;
	}
	
	public void endSession() {
		HibernateUtil hu = new HibernateUtil();
		hu.closeSession();
	}
	

}
