package Zoo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

public class BordeadoTexto extends JLabel {
	
	private Color colorBorde = Color.BLACK;
	
	public BordeadoTexto( String textoLabel ) {
		super( textoLabel );
		setForeground(new Color(70, 130, 180));
		setFont( new Font( "Arial", Font.BOLD, 24 ));
	}
	
	@Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       
       int x = (getWidth() - g.getFontMetrics().stringWidth(getText())) / 2;
       int y = ((getHeight()- g.getFontMetrics().getHeight()) / 2) + g.getFontMetrics().getAscent();
       
       // A dibujar el bordeado ahora
       g.setColor(colorBorde);
       for ( int i = -1; i <= 1; i++ ) {
    	   for ( int j = -1; j <= 1; j++ ) {
    		   if ( i!= 0 || j!= 0 ) {
    			   g.drawString(getText(), x + i, y + j);
    		   }
    	   }
       }
       
       // Texto Original
       g.setColor(getForeground());
       g.drawString(getText(), x, y);
    }

}
