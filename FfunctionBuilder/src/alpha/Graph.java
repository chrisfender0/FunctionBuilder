package alpha;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Graph extends JPanel {
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintGraphOutline(g);
		drawLine(g);
	}
	
	private void paintGraphOutline(Graphics g) {
		Graphics2D xAxis = (Graphics2D) g;
		Graphics2D yAxis = (Graphics2D) g;
		Graphics2D xText = (Graphics2D) g;
		Graphics2D yText = (Graphics2D) g;
		
		RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_STROKE_CONTROL,
	             RenderingHints.VALUE_STROKE_NORMALIZE);
	    xAxis.setRenderingHints(rh);
	    yAxis.setRenderingHints(rh);
		
		xAxis.setColor(Color.black);
		xAxis.setStroke(new BasicStroke(2));
		xAxis.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);
		
		yAxis.setColor(Color.black);
		yAxis.setStroke(new BasicStroke(2));
		yAxis.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
		
		xText.setColor(Color.black);
		xText.setFont(new Font(Font.SANS_SERIF, 1, 20));
		xText.drawString("(x)", getWidth()-30, (getHeight()/2)-10);
		
		yText.setColor(Color.black);
		yText.setFont(new Font(Font.SANS_SERIF, 1, 20));
		yText.drawString("(y)", getWidth()/2+10, 20);
	}
	
	private void drawLine(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int x = getWidth()/2;
		int y = getHeight()/2; 
		
		RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.setRenderingHints(rh);
		
		g2d.setColor(Color.blue);
		g2d.drawLine(x, y, x+100, y-100);
		g2d.drawLine(x+100, y-100, x+150, y-40);
		g2d.drawLine(x+150, y-40, x+210, y-400);
	}

}
