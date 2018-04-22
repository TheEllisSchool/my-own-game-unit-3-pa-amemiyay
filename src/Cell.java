import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	
	private static int SIZE = 50;
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
		Font labelFont = new Font ("Arial", Font.PLAIN, SIZE/2);
		numLabel.setFont(labelFont);
		add(numLabel);
		
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
		
		changeNumShown(numShown);
	}
	
	public void changeNumShown(String s) {
		numShown = s;
		numLabel.setText(numShown);
	}
	
	public boolean hasSetNumber() {
		return setNum;
	}
	
	public void setNumber(boolean h) {
		setNum = h;
	}
	
	public void emptyNumber() {
		changeNumShown("");
		numLabel.setForeground(Color.blue);
	}
	
	public boolean isWall(int index){ // is there a wall there?
		return wall[index];
	}
	
	public void reset() {
		numClicked = 0;
		changeNumShown("");
		
		setNum = true;
		numLabel.setForeground(Color.black);
	}
	
	@Override
	public Dimension getPreferredSize(){
		return new Dimension (SIZE, SIZE);
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
			} else if (col != 8){
				g2.setStroke(new BasicStroke(1));
				g2.drawLine(SIZE, 0, SIZE, SIZE);
				
			}
		}
		
		
	}
	
}
