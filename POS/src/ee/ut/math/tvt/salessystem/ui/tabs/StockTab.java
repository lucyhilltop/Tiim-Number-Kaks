package ee.ut.math.tvt.salessystem.ui.tabs;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;


public class StockTab {

  private JButton addItem;
  
  
  private JButton createaddItemButton() {
	    JButton b = new JButton("Add Item");
	    b.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        addItemButtonClicked();
	      }

		private void addItemButtonClicked() {
			JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
			JTextField Id = new JTextField(5);
			JTextField Name = new JTextField(5);
			JTextField Description = new JTextField(5);
			JTextField Price = new JTextField(5);
			JTextField Quantity = new JTextField(5);
			panel.add(new JLabel("Id:"));
			panel.add(Id);
			panel.add(new JLabel("Name:"));
			panel.add(Name);
			panel.add(new JLabel("Description:"));
			panel.add(Description);
			panel.add(new JLabel("Price:"));
			panel.add(Price);
			panel.add(new JLabel("Quantity:"));
			panel.add(Quantity);
			int result = JOptionPane.showConfirmDialog(null, panel, 
		               "Enter Item Information", JOptionPane.OK_CANCEL_OPTION);
			if (result == JOptionPane.OK_OPTION) {
				long id=Long.parseLong(Id.getText());
				String name=Name.getText();
				String description=Description.getText();
				Double price=Double.parseDouble(Price.getText());
				int quantity=Integer.parseInt(Quantity.getText());
				StockItem uus = new StockItem(id,name,description,price,quantity);
				model.getWarehouseTableModel().addItem(uus);
				
		      }
		}
	    });

	    return b;
	  }

  private SalesSystemModel model;

  public StockTab(SalesSystemModel model) {
    this.model = model;
  }

  // warehouse stock tab - consists of a menu and a table
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
    gc.weighty = 0d;

    panel.add(drawStockMenuPane(), gc);

    gc.weighty = 1.0;
    gc.fill = GridBagConstraints.BOTH;
    panel.add(drawStockMainPane(), gc);
    return panel;
  }

  // warehouse menu
  private Component drawStockMenuPane() {
    JPanel panel = new JPanel();

    GridBagConstraints gc = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();

    panel.setLayout(gb);

    gc.anchor = GridBagConstraints.NORTHWEST;
    gc.weightx = 0;

    addItem = createaddItemButton();
    gc.gridwidth = GridBagConstraints.RELATIVE;
    gc.weightx = 1.0;
    panel.add(addItem, gc);

    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    return panel;
  }


  // table of the wareshouse stock
  private Component drawStockMainPane() {
    JPanel panel = new JPanel();

    JTable table = new JTable(model.getWarehouseTableModel());

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

    panel.setBorder(BorderFactory.createTitledBorder("Warehouse status"));
    return panel;
  }

}
