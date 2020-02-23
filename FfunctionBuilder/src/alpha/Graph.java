package alpha;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Graph extends JPanel {
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintGraphOutline(g);
		draw(g);
	}
	
	private void paintGraphOutline(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.black);
		g2d.setStroke(new BasicStroke(2));
		g2d.drawLine(getWidth()/2, 0, getWidth()/2, getHeight()); //y axis 
		g2d.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
	}
	
	private void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Graphics2D lastPoint = (Graphics2D) g;
		int x = getWidth()/2;
		int y = getHeight()/2; 
		
		g2d.setColor(Color.blue);
		g2d.drawLine(x, y, x+100, y-100);
		g2d.drawLine(x+100, y-100, x+150, y-40);
	}

}
