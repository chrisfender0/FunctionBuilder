package alpha;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Graph extends JPanel {

	int x = 0;
	int y = 0;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setXY();
		paintGraphOutline(g);
		paintMarkers(g);
		drawLine(g);
	}

	private void paintGraphOutline(Graphics g) {
		Graphics2D xAxis = (Graphics2D) g;
		Graphics2D yAxis = (Graphics2D) g;
		Graphics2D xText = (Graphics2D) g;
		Graphics2D yText = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_STROKE_CONTROL,
				RenderingHints.VALUE_STROKE_NORMALIZE);
		xAxis.setRenderingHints(rh);
		yAxis.setRenderingHints(rh);

		xAxis.setColor(Color.black);
		xAxis.setStroke(new BasicStroke(2));
		xAxis.drawLine(0, y, getWidth(), y);

		yAxis.setColor(Color.black);
		yAxis.setStroke(new BasicStroke(2));
		yAxis.drawLine(x, 0, x, getHeight());

		xText.setColor(Color.black);
		xText.setFont(new Font(Font.SANS_SERIF, 1, 12));
		xText.drawString("(x)", 30, y + 30);

		yText.setColor(Color.black);
		yText.setFont(new Font(Font.SANS_SERIF, 1, 12));
		yText.drawString("(y)", x-40, getHeight()-30);
	}

	private void paintMarkers(Graphics g) {
		Graphics2D xPoints = (Graphics2D) g;
		Graphics2D yPoints = (Graphics2D) g;

		xPoints.setColor(Color.black);
		xPoints.setStroke(new BasicStroke(1));
		xPoints.setFont(new Font(Font.SANS_SERIF, 1, 10));
		yPoints.setColor(Color.black);
		yPoints.setStroke(new BasicStroke(1));
		yPoints.setFont(new Font(Font.SANS_SERIF, 1, 10));

		for (int i = 1; i < 100; i++) {
			if (i % 5 == 0) {
				if (i == 5) {
					xPoints.drawLine(x + i * 10, y + 4, x + i * 10, y - 4);
					xPoints.drawString(Integer.toString(i), x + (i * 10) - 4, y + 24);

				} else {
					xPoints.drawLine(x + i * 10, y + 4, x + i * 10, y - 4);
					xPoints.drawString(Integer.toString(i), x + (i * 10) - 8, y + 24);
				}
			} else {
				xPoints.drawLine(x + i * 10, y + 2, x + i * 10, y - 2);
			}
		}

		for (int i = 1; i < 100; i++) {
			if (i % 5 == 0) {
				if (i == 5) {
					yPoints.drawLine(x - 4, y - 10 * i, x + 4, y - 10 * i);
					yPoints.drawString(Integer.toString(i), x - 20, y - 10 * i);
				} else {
					yPoints.drawLine(x - 4, y - 10 * i, x + 4, y - 10 * i);
					yPoints.drawString(Integer.toString(i), x - 24, y - 10 * i);
				}
			} else {
				yPoints.drawLine(x - 2, y - 10 * i, x + 2, y - 10 * i);
			}

		}

	}

	private void drawLine(Graphics g) {

		int xPoint = 10;
		int yPoint = 10;

		Graphics2D g2d = (Graphics2D) g;

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHints(rh);
		g2d.setStroke(new BasicStroke(1));

		g2d.setColor(Color.blue);
		g2d.drawOval(x + xPoint - 1, y - yPoint - 1, 3, 3);
		g2d.fillOval(x + xPoint - 1, y - yPoint - 1, 3, 3);
	}

	private void setXY() {
		x = getWidth() / 4;
		y = (getHeight() / 4)*3;
	}

}
