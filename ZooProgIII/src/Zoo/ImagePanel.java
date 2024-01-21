package Zoo;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	private Image imagenFondo;
	
	public ImagePanel(String string) {
		this.imagenFondo = new ImageIcon(string).getImage();
	}

//	public ImagePanel(URL resource) {
//		// TODO Auto-generated constructor stub
//		this.imagenFondo = new ImageIcon(resource).getImage();
//	}



	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
	}
	
	

}
