import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cell extends JButton{
	//wall stuff
	public static final int TOP = 0;
	public static final int RIGHT = 1;
	public static final int BOTTOM = 2;
	public static final int LEFT = 3;
	private boolean [] wall = {true, true, true, true};

	//variables
	
	private static int SIZE = 30;
	private int row = 0;
	private int col = 0;
	private int numClicked = 0;
	private String numShown = "";
	
	private boolean setNum = true;
	JLabel numLabel = new JLabel("", JLabel.CENTER);
	
	
	//methods
	
	public Cell(int r, int c) {
		row = r;
		col = c;
		
		numLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		add(numLabel);
		
		Dimension size = new Dimension(SIZE, SIZE);
		setPreferredSize(size);
		
		setBorder(null);
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	
	public int getNumClicked() {
		return numClicked;
	}
	
	public String getNumShown() {
		return numShown;
	}
	
	public void increaseNumClicked() {
		numClicked++;
		if (numClicked%10 == 0) {
			numShown = "";
		} else {
			numShown = Integer.toString(numClicked%10);
		}
		//System.out.println(numShown);
		
		changeNumShown(numShown);
	}
	
	public void changeNumShown(String s) {
		numShown = s;
		numLabel.setText(s);
	}
	
	public boolean hasSetNumber() {
		return setNum;
	}
	
	public void setNumber(boolean h) {
		setNum = h;
	}
	
	public boolean isWall(int index){ // is there a wall there?
		return wall[index];
	}
	
	
	//@Override
	public void paintComponent(Graphics g){
		//draw the background
		g.setColor(Color.white);
		g.fillRect(0, 0, SIZE, SIZE);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		
		//draw the walls
		g.setColor(Color.black);
		if (isWall(TOP)) {
			if (row == 3 || row == 6) {
				g2.setStroke(new BasicStroke(5));
				g2.drawLine(0, 0, SIZE, 0); //top line
			} else {
				g2.setStroke(new BasicStroke(1));
				g2.drawLine(0, 0, SIZE, 0);
			}
		}
			
		if (isWall(RIGHT)) {
			if (col == 2 || col == 5) {
				g2.setStroke(new BasicStroke(5));
				g2.drawLine(SIZE, 0, SIZE, SIZE);
			} else {
				g2.setStroke(new BasicStroke(1));
				g2.drawLine(SIZE, 0, SIZE, SIZE);
				
			}
		}
		
		
	}
	/*
	public void reset() {
		int row = 0;
		int col = 0;
		int num = 0;
		int numClicked = 0;
		
		boolean hasNum = false;
	}*/

}