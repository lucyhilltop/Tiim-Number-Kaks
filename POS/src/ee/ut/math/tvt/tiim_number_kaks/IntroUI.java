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
	public ArrayList<String> getAppProps() {
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
			e.printStackTrace();
		}
	}
	
	String nimi = prop.getProperty("Tiimi nimi");
	String juht = prop.getProperty("Juht");
	String juhimeil = prop.getProperty("Juhi e-mail");
	String liikmed = prop.getProperty("Liikmed");
	result = "Tiimi nimi: " + nimi + "\n" + "Tiimi juht: " + juht + "\n" + 
			"Juhi e-mail: " + juhimeil + "\n" + "Liikmed: " + liikmed;
	ArrayList<String> list = new ArrayList<String>();
	list.add(nimi);
	list.add(juht);
	list.add(juhimeil);
	list.add(liikmed);
	return list;
}

    public IntroUI() {
    	IntroUI a_props = null;
		ArrayList<String> nimekiri = a_props.getAppProps();
    	System.out.println(nimekiri.get(0));
        createAndShowGUI();
    }
    
    private void createAndShowGUI()
    {
        setTitle("Intro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        // An empty panel with FlowLayout
        p1=new JPanel();
        
        IntroUI a_props = new IntroUI();
        // Set some preferred size
        d=new Dimension(300,200);
        p1.setPreferredSize(d);
        ArrayList<String> nimekiri = a_props.getAppProps();
    	p1.add(new JLabel("Tiimi nimi" + nimekiri.get(0)));
    	p1.add(new JLabel("Silver Pajumäe"));
    	p1.add(new JLabel("silverpajumae@hotmail.com"));
    	p1.add(new JLabel("Silver Pajumäe, Liis Mäeots, Mikk Tark"));
    	
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
        new IntroUI();
    }
}