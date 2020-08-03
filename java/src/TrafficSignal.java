package com;

import java.awt.*;
import java.applet.Applet;

public class TrafficSignal extends Applet implements Runnable {

	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		TrafficSignal ts = new TrafficSignal();
		ts.start();
	}

	Thread t;
	int count;

	public void start() {
		t = new Thread(this);
		t.start();
		setSize(1450, 650);

	}

	public void run() {
		while (true) {
			count++;
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
			if (count == const4st) {
				count = 0;
			}

		}
	}

	int xht = 370;// x-horizontal-top
	int yht = 290;// y-horizontal-top
	int xhb = 750;// x-horizontal-bottom
	int yhb = 390;// y-horizontal-bottom

	int xvr = 690;// x-vertical-right
	int yvr = 100;// x-vertical-right
	int xvl = 590;// x-vertical-left
	int yvl = 450;// y-vertical-left
	int incr = 10;
	int incr2 = 10;
	int second = 0;

	int const1st = 600;
	int const2st = 1200;
	int const3st = 1800;
	int const4st = 2400;

	int stopCounter = 100;

	public void paint(Graphics g) {
		if (count % 20 == 0) {
			second = count / 20;
		}
		g.drawString("" + second, 20, 20);

		drawRoads(g);
		drawCars(g, count);
		drawSignal(g, 460, 60, 80, 180, count >= 0 && count < const1st ? 1 : 2,
				count >= (const4st - stopCounter) && count < const4st ? 1 : 2);// (x,y,w=80,h=180)Vertical
		drawSignal(g, 760, 155, 180, 80, count >= const1st && count < const2st ? 1 : 2,
				count >= (const1st - stopCounter) && count < const1st ? 1 : 2);// (x,y,w=180,h=80)Horizontal
		drawSignal(g, 760, 460, 80, 180, count >= const2st && count < const3st ? 1 : 2,
				count >= (const2st - stopCounter) && count < const2st ? 1 : 2);
		drawSignal(g, 360, 460, 180, 80, count >= const3st && count < const4st ? 1 : 2,
				count >= (const3st - stopCounter) && count < const3st ? 1 : 2);
	}

	void drawCars(Graphics g, int count) {
		g.setColor(Color.RED);
		// *****************************Horizontal-top********************************
		for (int i = 0; i < 2; i++) {
			g.fillRect(xht + i * 130, yht, 50, 20);
		}
		if (count > const1st && count <= const2st) {
			xht += incr;
			if (xht == 1500)
				xht = 0;
			if (xht < 0)
				incr = 10;
			if (count == const2st) {
				xht = 370;
				yht = 290;
			}
		}
		// *****************************Horizontal-bottom********************************
		for (int i = 0; i < 2; i++) {
			g.fillRect(xhb + i * 130, yhb, 50, 20);
		}
		if (count > const3st && count <= const4st) {
			xhb += incr2;
			if (xhb == 0)
				xhb = 1500;
			if (xhb > 0)
				incr2 = -10;
			if (count == const4st) {
				xhb = 750;
				yhb = 390;
			}
		}
		// *****************************Vertical-Right********************************
		for (int i = 0; i < 2; i++) {
			g.fillRect(xvr, yvr + i * 100, 20, 50);
		}
		if (count > const2st && count <= const3st) {
			yvr += incr;
			if (yvr == 700)
				yvr = 0;
			if (yvr < 0)
				incr = 10;
			if (count == const3st) {
				xvr = 690;
				yvr = 100;
			}
		}
		// *****************************Vertical-left********************************
		for (int i = 0; i < 2; i++) {
			g.fillRect(xvl, yvl + i * 100, 20, 50);
		}
		if (count > 0 && count <= const1st) {
			yvl += incr2;
			if (yvl == 0)
				yvl = 700;
			if (yvl > 0)
				incr2 = -10;
			if (count == const1st) {
				xvl = 590;
				yvl = 450;
			}
		}
	}

	void drawSignal(Graphics g, int x, int y, int h, int w, int redFlag, int yellowFlag) {
		g.setColor(new Color(0, 0, 0));
		g.fillRoundRect(x, y, h, w, 25, 25);
		g.setColor(redFlag == 1 || yellowFlag == 1 ? Color.red.darker().darker().darker().darker() : Color.red);
		g.fillOval(x + 20, y + 20, 40, 40);
		g.setColor(yellowFlag == 2 ? Color.orange.darker().darker().darker().darker() : Color.orange);
		g.fillOval(h > 80 ? x + 70 : x + 20, h > 80 ? y + 20 : y + 70, 40, 40);
		g.setColor(redFlag == 2 ? Color.green.darker().darker().darker().darker() : Color.green);
		g.fillOval(h > 80 ? x + 120 : x + 20, h > 80 ? y + 20 : y + 120, 40, 40);
	}

	void drawRoads(Graphics g) {
		// ************ Vertical Road ***********************
		setBackground(Color.gray.brighter());
		g.setColor(new Color(0, 0, 0));
		g.fillRect(550, 0, 200, 700);
		g.setColor(Color.white);// White lines
		for (int i = 0; i < 9; i++) {
			g.fillRect(645, i * 80, 5, 50);
		}
		// *************** Horizontal Road *******************
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 250, 600, 200);
		g.fillRect(660, 250, 1500, 200);
		g.setColor(Color.white);
		for (int i = 0; i < 8; i++) {
			g.fillRect(i * 80, 345, 50, 5);
		}
		for (int i = 0; i < 10; i++) {
			g.fillRect(675 + i * 80, 345, 50, 5);
		}
	}

}
