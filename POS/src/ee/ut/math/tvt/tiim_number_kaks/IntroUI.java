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
			System.out.println("Siin on viga!");
		}
	}
	
	String nimi = prop.getProperty("Tiim");
	String juht = prop.getProperty("Juht");
	String juhimeil = prop.getProperty("email");
	String liikmed = prop.getProperty("Liikmed");
	result = "Tiimi nimi: " + nimi + "\n" + "Tiimi juht: " + juht + "\n" + 
			"Juhi e-mail: " + juhimeil + "\n" + "Liikmed: " + liikmed;
	ArrayList<String> tulemus = new ArrayList<String>();
	tulemus.add(nimi);
	tulemus.add(juht);
	tulemus.add(juhimeil);
	tulemus.add(liikmed);
	return tulemus;
}
	public String getVersionProps() {
		String result = "";
		Properties prop = new Properties();
		String propFileName = "version.properties";
		
		InputStream inputStream = getClass().getResourceAsStream("version.properties");
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (inputStream == null) {
			try {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String major = prop.getProperty("build.major.number");
		String minor = prop.getProperty("build.minor.number");
		String build = prop.getProperty("build.number");
		result = major + "." + minor + "." + build;
		
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
        
     
		ArrayList<String> nimekiri = getAppProps();
        // Set some preferred size
        d=new Dimension(280,300);
        p1.setPreferredSize(d);
    	p1.add(new JLabel("Tiimi nimi: " + nimekiri.get(0)));
    	p1.add(new JLabel("\n" +"Tiimi juht: " + nimekiri.get(1)));
    	p1.add(new JLabel("\n Juhi e-mail: " + nimekiri.get(2)));
    	p1.add(new JLabel("\n Liikmed: " + nimekiri.get(3)));
    	String nk = getVersionProps();
    	p1.add(new JLabel("Versiooni number: " + nk));
    	
		BufferedImage wPic = null;
		try {
			wPic = ImageIO.read(this.getClass().getResource("number.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	p1.add(new JLabel(new ImageIcon(wPic)));
        
        // Add panels
        add(p1);
        
        setSize(200,200);
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