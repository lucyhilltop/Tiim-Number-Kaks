package ee.ut.math.tvt.tiim_number_kaks;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
class IntroUI extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JPanel p1;
Dimension d;
	public String getAppProps() {
	String result = "";
	Properties prop = new Properties();
	
	InputStream inputStream = getClass().getResourceAsStream("application.properties");
	try {
		prop.load(inputStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if (inputStream == null) {
		try {
			throw new FileNotFoundException("property file 'applications.properties' not found in the classpath");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Siin on viga!");
		}
	}
	
	String nimi = prop.getProperty("Tiim");
	String juht = prop.getProperty("Juht");
	String juhimeil = prop.getProperty("email");
	String liikmed = prop.getProperty("Liikmed");
	result = "Tiimi nimi: " + nimi + "\n" + "Tiimi juht: " + juht + "\n" + 
			"Juhi e-mail: " + juhimeil + "\n" + "Liikmed: " + liikmed;
	
	return result;
}

    public IntroUI() {	
        createAndShowGUI();
    }
    
    private void createAndShowGUI()
    {
        setTitle("Intro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        // An empty panel with FlowLayout
        p1=new JPanel();
        
     
		String nimekiri = getAppProps();
        // Set some preferred size
        d=new Dimension(600,500);
        p1.setPreferredSize(d);
    	p1.add(new JLabel(nimekiri));
    	//p1.add(new JLabel("Silver Pajum�e"));
    	//p1.add(new JLabel("silverpajumae@hotmail.com"));
    	//p1.add(new JLabel("Silver Pajum�e, Liis M�eots, Mikk Tark"));
    	
		BufferedImage wPic = null;
		try {
			wPic = ImageIO.read(this.getClass().getResource("number.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	p1.add(new JLabel(new ImageIcon(wPic)));
        
        // Add panels
        add(p1);
        
        setSize(400,400);
        setVisible(true);
        pack();

    }
    
    public static void main(String args[])
    {
        try {
			new IntroUI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Siin on jama :(");
			e.printStackTrace();
		}
    }
}