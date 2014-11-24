package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.ui.model.HistoryTableModel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab {
	private SalesSystemModel model;
	HistoryTableModel htm;
		
		ArrayList<List<SoldItem>> ajalugu = new ArrayList<List<SoldItem>>();
		
		public void addToAjalugu(List<SoldItem> goods) {
			ajalugu.add(goods);
		}

	public HistoryTab(SalesSystemModel model) {
	    this.model = model;
	  }
	public Component draw() {
	    JPanel panel = new JPanel();
	    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	    GridBagLayout gb = new GridBagLayout();
	    GridBagConstraints gc = new GridBagConstraints();
	    panel.setLayout(gb);

	    gc.fill = GridBagConstraints.HORIZONTAL;
	    gc.anchor = GridBagConstraints.NORTH;
	    gc.gridwidth = GridBagConstraints.REMAINDER;
	    gc.weightx = 1.0d;
	//    gc.weighty = 0d;


	    gc.weighty = 1.0;
	    gc.fill = GridBagConstraints.BOTH;
	    panel.add(drawStockMainPane(), gc);
	    return panel;
	  }

	  // table of the warehouse stock
	  private Component drawStockMainPane() {
	    JPanel panel = new JPanel();

	    	final JTable table = new JTable(model.getCurrentHistoryTableModel());
	    	table.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					int valitud = (table.getSelectedRow());
					String sone = "Name/Quantity/Price/Sum";
					for (int i=0;i<ajalugu.get(valitud).size();i++) {
						String nimi =ajalugu.get(valitud).get(i).getName();
						Integer hulk = ajalugu.get(valitud).get(i).getQuantity();
						double hind = ajalugu.get(valitud).get(i).getPrice();
						double summa = ajalugu.get(valitud).get(i).getSum();
						String liidetav = nimi+"/"+Integer.toString(hulk)+"/"+Double.toString(hind)+"/"+Double.toString(summa);
						sone+="\n";
						sone+= liidetav;
						}
					Component frame = null;
					JOptionPane.showConfirmDialog(frame,sone, sone, JOptionPane.CLOSED_OPTION);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
	    		
	    	});

	    JTableHeader header = table.getTableHeader();
	    header.setReorderingAllowed(false);

	    JScrollPane scrollPane = new JScrollPane(table);

	    GridBagConstraints gc = new GridBagConstraints();
	    GridBagLayout gb = new GridBagLayout();
	    gc.fill = GridBagConstraints.BOTH;
	    gc.weightx = 1.0;
	    gc.weighty = 1.0;

	    panel.setLayout(gb);
	    panel.add(scrollPane, gc);

	    panel.setBorder(BorderFactory.createTitledBorder("History of purchase"));
	    return panel;
	  }
	
}