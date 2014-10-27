package ee.ut.math.tvt.tiim_number_kaks;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
class IntroUI extends JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JPanel p1;
Dimension d;

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
        
        
        // Set some preferred size
        d=new Dimension(300,200);
        p1.setPreferredSize(d);
        
    	p1.add(new JLabel("Tiim Number 2"));
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