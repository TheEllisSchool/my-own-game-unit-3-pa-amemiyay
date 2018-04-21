import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Sudoku extends JFrame{
	
	static final int GRIDSIZE = 9;
	int numEmpty = 0;
	private Cell [][] grid = new Cell[GRIDSIZE][GRIDSIZE];

	
	Random rand = new Random();
	ArrayList<Integer> row1Box1 = new ArrayList<>();
	ArrayList<Integer> row2Box1 = new ArrayList<>();
	ArrayList<Integer> row3Box1 = new ArrayList<>();
	ArrayList<Integer> col1Box1 = new ArrayList<>();
	ArrayList<Integer> col2Box1 = new ArrayList<>();
	ArrayList<Integer> col3Box1 = new ArrayList<>();
	ArrayList<Integer> box1 = new ArrayList<>();
	
	ArrayList<Integer> rows23Box1 = new ArrayList<>();
	ArrayList<Integer> cols23Box1 = new ArrayList<>();

	ArrayList<Integer> row1Box2 = new ArrayList<>();
	ArrayList<Integer> row2Box2 = new ArrayList<>();
	ArrayList<Integer> row3Box2 = new ArrayList<>();
	ArrayList<Integer> col1Box2 = new ArrayList<>();
	ArrayList<Integer> col2Box2 = new ArrayList<>();
	ArrayList<Integer> col3Box2 = new ArrayList<>();
	
	ArrayList<Integer> row1Box3 = new ArrayList<>();
	ArrayList<Integer> row2Box3 = new ArrayList<>();
	ArrayList<Integer> row3Box3 = new ArrayList<>();
	
	ArrayList<Integer> row1Box4 = new ArrayList<>();
	ArrayList<Integer> row2Box4 = new ArrayList<>();
	ArrayList<Integer> row3Box4 = new ArrayList<>();
	ArrayList<Integer> col1Box4 = new ArrayList<>();
	ArrayList<Integer> col2Box4 = new ArrayList<>();
	ArrayList<Integer> col3Box4 = new ArrayList<>();
	
	ArrayList<Integer> box5 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
	ArrayList<Integer> box6 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
	ArrayList<Integer> box7 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
	ArrayList<Integer> box8 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
	ArrayList<Integer> box9 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
	
	ArrayList<Integer> rows23Box4 = new ArrayList<>();
	ArrayList<Integer> cols23Box2 = new ArrayList<>();
	ArrayList<Integer> cols13Box2 = new ArrayList<>();
	ArrayList<Integer> cols12Box2 = new ArrayList<>();
	ArrayList<Integer> rows13Box4 = new ArrayList<>();
	ArrayList<Integer> rows12Box4 = new ArrayList<>();
	ArrayList<Integer> row1Box5 = new ArrayList<>();
	ArrayList<Integer> row2Box5 = new ArrayList<>();
	ArrayList<Integer> row3Box5 = new ArrayList<>();
	ArrayList<Integer> rows23Box5 = new ArrayList<>();
	ArrayList<Integer> rows13Box5 = new ArrayList<>();
	ArrayList<Integer> rows12Box5 = new ArrayList<>();

	ArrayList<Integer> col1Box5 = new ArrayList<>();
	ArrayList<Integer> col2Box5 = new ArrayList<>();
	ArrayList<Integer> col3Box5 = new ArrayList<>();
	ArrayList<Integer> cols23Box5 = new ArrayList<>();
	ArrayList<Integer> cols13Box5 = new ArrayList<>();
	ArrayList<Integer> cols12Box5 = new ArrayList<>();

	ArrayList<Integer> col1Box3 = new ArrayList<>();
	ArrayList<Integer> col2Box3 = new ArrayList<>();
	ArrayList<Integer> col3Box3 = new ArrayList<>();
	ArrayList<Integer> cols13Box3 = new ArrayList<>();
	ArrayList<Integer> cols23Box3 = new ArrayList<>();
	ArrayList<Integer> cols12Box3 = new ArrayList<>();
	
	ArrayList<Integer> col1Box6 = new ArrayList<>();
	ArrayList<Integer> col2Box6 = new ArrayList<>();
	ArrayList<Integer> col3Box6 = new ArrayList<>();
	ArrayList<Integer> cols13Box6 = new ArrayList<>();
	ArrayList<Integer> cols23Box6 = new ArrayList<>();
	ArrayList<Integer> cols12Box6 = new ArrayList<>();

	
	ArrayList<Integer> row1Box7 = new ArrayList<>();
	ArrayList<Integer> row2Box7 = new ArrayList<>();
	ArrayList<Integer> row3Box7 = new ArrayList<>();
	ArrayList<Integer> rows23Box7 = new ArrayList<>();
	ArrayList<Integer> rows13Box7 = new ArrayList<>();
	ArrayList<Integer> rows12Box7 = new ArrayList<>();
	
	ArrayList<Integer> row1Box8 = new ArrayList<>();
	ArrayList<Integer> row2Box8 = new ArrayList<>();
	ArrayList<Integer> row3Box8 = new ArrayList<>();
	ArrayList<Integer> rows23Box8 = new ArrayList<>();
	ArrayList<Integer> rows13Box8 = new ArrayList<>();
	ArrayList<Integer> rows12Box8 = new ArrayList<>();
	
	ArrayList<Integer> setGrid = new ArrayList<>();
	ArrayList<Integer> yourGrid = new ArrayList<>();
	int yourNum = 0;
	
	public Sudoku() {
		initGUI();
		
		setTitle("SUDOKU");
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		//setSize(700, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initGUI() {
		//titlePanel
		JPanel titlePanel = new JPanel();
		add(titlePanel, BorderLayout.PAGE_START);
		titlePanel.setBackground(Color.black);
		JLabel titleLabel = new JLabel("Sudoku Puzzle");
		titlePanel.add(titleLabel);
		titleLabel.setBackground(Color.black);
		titleLabel.setOpaque(true);
		titleLabel.setForeground(Color.WHITE);
		Font titleFont = new Font("Times New Roman", Font.PLAIN, 36);
		titleLabel.setFont(titleFont);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		//center panel
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
		add(centerPanel, BorderLayout.CENTER);
		for (int r = 0; r < GRIDSIZE; r++) {
			for (int c = 0; c < GRIDSIZE; c++) {
				grid[r][c] = new Cell(r, c);
				grid[r][c].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Cell button = (Cell) e.getSource();
						int row = button.getRow();
						int col = button.getCol();
							
						clickedCell(row, col);
					}
				});
				
				centerPanel.add(grid[r][c]);
			}
		}
		
		//maze panel
		newPuzzle();
		
		//button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.black);
		add(buttonPanel, BorderLayout.PAGE_END);
		JButton newPuzzleButton = new JButton("New Puzzle");
		newPuzzleButton.setFocusable(false);
		newPuzzleButton.setBackground(Color.white);
		newPuzzleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newPuzzle();
			}
		});
		buttonPanel.add(newPuzzleButton);
	}
	
	public void clickedCell(int r, int c) {
		if (!grid[r][c].hasSetNumber()) {
			grid[r][c].increaseNumClicked();
		}
		checkAnswer(setGrid);
	}
	
	private void newPuzzle() {
		resetAll();
		UIManager.put("OptionPane.background", Color.black);
        UIManager.put("Panel.background", Color.black);
        UIManager.put("Button.background", Color.white);
        UIManager.put("Button.foreground", Color.black);
        JLabel difficultyLabel = new JLabel("Select a difficulty", JLabel.CENTER);
        difficultyLabel.setForeground(Color.white);
		String[] options = {"Easy", "Medium", "Hard"};
        int x = JOptionPane.showOptionDialog(null, difficultyLabel,
        		"Difficulty", JOptionPane.DEFAULT_OPTION, 
        		JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (x == 0) {
        		numEmpty = 36;
        } else if (x == 1) {
        		numEmpty = 45;
        } else if (x == 2) {
        		numEmpty = 54;
        } 
		generatePuzzle();
		
		
	}
	
	public void generatePuzzle() {
		
		ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		int numElements = 3;
		
		//-----------FIRST BOX------------
		//3 rows of first box

		for (int r = 0; r < 3; r++) {
			for (int i = 0; i < numElements; i++) {
				int randomIndex = rand.nextInt(nums.size());
				int randomElement = nums.get(randomIndex);
				nums.remove(new Integer(randomElement));
				if (r == 0) {
					row1Box1.add(randomElement);
				} else if (r == 1) {
					row2Box1.add(randomElement);
				} else if (r == 2) {
					row3Box1.add(randomElement);
				}
				box1.add(randomElement);
				
				grid[r][i].changeNumShown(Integer.toString(randomElement));
			}
		}
		

		for (int c = 0; c < 3; c++) {
			for (int r = 0; r < 3; r++) {
				if (c == 0) {
					col1Box1.add(Integer.parseInt(grid[r][c].getNumShown()));
				} else if (c == 1) {
					col2Box1.add(Integer.parseInt(grid[r][c].getNumShown()));
				} else if (c == 2) {
					col3Box1.add(Integer.parseInt(grid[r][c].getNumShown()));
				}
			}
		}

		
		
		
		//-----------SECOND BOX------------
		//first row of second box
		rows23Box1.addAll(row2Box1);
		rows23Box1.addAll(row3Box1);

		for (int i = 0; i < numElements; i++) {
			int randomIndex = rand.nextInt(rows23Box1.size());
			int randomElement = rows23Box1.get(randomIndex);
			if (row2Box1.contains(randomElement)) {
				row2Box1.remove(new Integer(randomElement));	
			} else {
				row3Box1.remove(new Integer(randomElement));
			}
			rows23Box1.remove(new Integer(randomElement));
			box1.remove(new Integer(randomElement));
			row1Box2.add(randomElement);
			grid[0][i+3].changeNumShown(Integer.toString(randomElement));
		} 
		
		//second row of second box
		for (int i = 0; i < numElements; i++) {
			int randomIndex;
			int randomElement;
			if (row3Box1.size() >= 1) { //if there's still numbers left over
				randomIndex = rand.nextInt(row3Box1.size());
				randomElement = row3Box1.get(randomIndex);
				row3Box1.remove(new Integer(randomElement));
			} else { // from the top
				randomIndex = rand.nextInt(row1Box1.size());
				randomElement = row1Box1.get(randomIndex);
				row1Box1.remove(new Integer(randomElement));
			}
			box1.remove(new Integer(randomElement));
			row2Box2.add(randomElement);
			grid[1][i+3].changeNumShown(Integer.toString(randomElement));
		}
		
		//third row of second box: fill with left over
	
		for (int i = 0; i < numElements; i++) {
			int randomIndex = rand.nextInt(box1.size());
			int randomElement = box1.get(randomIndex);
			box1.remove(new Integer(randomElement));
			row3Box2.add(randomElement);
			grid[2][i+3].changeNumShown(Integer.toString(randomElement));
		}
		

		for (int c = 3; c < 6; c++) {
			for (int r = 0; r < 3; r++) {
				if (c == 3) {
					col1Box2.add(Integer.parseInt(grid[r][c].getNumShown()));
				} else if (c == 4) {
					col2Box2.add(Integer.parseInt(grid[r][c].getNumShown()));
				} else if (c == 5) {
					col3Box2.add(Integer.parseInt(grid[r][c].getNumShown()));
				}
			}
		}
		
		//---------THIRD BOX--------
		//first row of third box: fill with left over
		ArrayList<Integer> r1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		for (int i = 0; i < 6; i++) {
			r1.remove(new Integer(Integer.parseInt(grid[0][i].getNumShown())));
		}
		for (int i = 0; i < numElements; i++) {
			int randomIndex = rand.nextInt(r1.size());
			int randomElement = r1.get(randomIndex);
			r1.remove(new Integer(randomElement));
			grid[0][i+6].changeNumShown(Integer.toString(randomElement));
			row1Box3.add(randomElement);
		}
		//second row of third box
		ArrayList<Integer> r2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		for (int i = 0; i < 6; i++) {
			r2.remove(new Integer(Integer.parseInt(grid[1][i].getNumShown())));
		}
		for (int i = 0; i < numElements; i++) {
			int randomIndex = rand.nextInt(r2.size());
			int randomElement = r2.get(randomIndex);
			r2.remove(new Integer(randomElement));
			grid[1][i+6].changeNumShown(Integer.toString(randomElement));
			row2Box3.add(randomElement);
		}
		
		//third row of third box
		ArrayList<Integer> r3 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		for (int i = 0; i < 6; i++) {
			r3.remove(new Integer(Integer.parseInt(grid[2][i].getNumShown())));
		}
		for (int i = 0; i < numElements; i++) {
			int randomIndex = rand.nextInt(r3.size());
			int randomElement = r3.get(randomIndex);
			r3.remove(new Integer(randomElement));
			grid[2][i+6].changeNumShown(Integer.toString(randomElement));
			row3Box3.add(randomElement);
		}
		

		for (int c = 6; c < 9; c++) {
			for (int r = 0; r < 3; r++) {
				if (c == 6) {
					col1Box3.add(Integer.parseInt(grid[r][c].getNumShown()));
				} else if (c == 7) {
					col2Box3.add(Integer.parseInt(grid[r][c].getNumShown()));
				} else if (c == 8) {
					col3Box3.add(Integer.parseInt(grid[r][c].getNumShown()));
				}
			}
		}
		cols23Box3.addAll(col2Box3);
		cols23Box3.addAll(col3Box3);
		cols13Box3.addAll(col1Box3);
		cols13Box3.addAll(col3Box3);
		cols12Box3.addAll(col1Box3);
		cols12Box3.addAll(col2Box3);
		
		
		//-------FOURTH BOX-------
		//first column of fourth box 
		cols23Box1.addAll(col2Box1);
		cols23Box1.addAll(col3Box1);
		
		
		//make first column
		for (int i = 0; i < numElements; i++) {
			int randomIndex = rand.nextInt(cols23Box1.size());
			int randomElement = cols23Box1.get(randomIndex);
			if (col3Box1.contains(randomElement)) {
				col3Box1.remove(new Integer(randomElement));	
			} 
			cols23Box1.remove(new Integer(randomElement));
			//box1.remove(new Integer(randomElement));
			col1Box4.add(randomElement);
			grid[i+3][0].changeNumShown(Integer.toString(randomElement));
		} 
		
			
		//second column of fourth box
		for (int i = 0; i < numElements; i++) {
			int randomIndex;
			int randomElement;
			if (col3Box1.size() >= 1) { //if there's still numbers left over
				randomIndex = rand.nextInt(col3Box1.size());
				randomElement = col3Box1.get(randomIndex);
				col3Box1.remove(new Integer(randomElement));
				//box1.remove(new Integer(randomElement));
			} else { // from the top
				randomIndex = rand.nextInt(col1Box1.size());
				randomElement = col1Box1.get(randomIndex);

				//box1.remove(new Integer(randomElement));
				col1Box1.remove(new Integer(randomElement));
			}
			col2Box4.add(randomElement);
			grid[i+3][1].changeNumShown(Integer.toString(randomElement));
		}
		
		//third column of fourth box: fill with left over
		col3Box4.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
		col3Box4.removeAll(col1Box4);
		col3Box4.removeAll(col2Box4);
		
		for (int i = 0; i < numElements; i++) {
			int randomIndex = rand.nextInt(col3Box4.size());
			int randomElement = col3Box4.get(randomIndex);
			col3Box4.remove(new Integer(randomElement));
			grid[i+3][2].changeNumShown(Integer.toString(randomElement));
		}
		
		
		for (int r = 3; r < 6; r++) {
			for (int c = 0; c < 3; c++) {
				if (r == 3) {
					row1Box4.add(Integer.parseInt(grid[r][c].getNumShown()));
				} else if (r == 4) {
					row2Box4.add(Integer.parseInt(grid[r][c].getNumShown()));
				} else if (r == 5) {
					row3Box4.add(Integer.parseInt(grid[r][c].getNumShown()));
				}
			}
		}
		rows23Box4.addAll(row2Box4);
		rows23Box4.addAll(row3Box4);
		
		rows13Box4.addAll(row1Box4);
		rows13Box4.addAll(row3Box4);
		
		
		//---------SEVENTH BOX--------
		//first column of seventh box
		ArrayList<Integer> c1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		for (int i = 0; i < 6; i++) {
			c1.remove(new Integer(Integer.parseInt(grid[i][0].getNumShown())));
		}
		for (int i = 0; i < numElements; i++) {
			int randomIndex = rand.nextInt(c1.size());
			int randomElement = c1.get(randomIndex);
			c1.remove(new Integer(randomElement));
			grid[i+6][0].changeNumShown(Integer.toString(randomElement));
		}
		//second column of seventh box
		ArrayList<Integer> c2 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		for (int i = 0; i < 6; i++) {
			c2.remove(new Integer(Integer.parseInt(grid[i][1].getNumShown())));
		}
		for (int i = 0; i < numElements; i++) {
			int randomIndex = rand.nextInt(c2.size());
			int randomElement = c2.get(randomIndex);
			c2.remove(new Integer(randomElement));
			grid[i+6][1].changeNumShown(Integer.toString(randomElement));
		}
		//third column of seventh box
		ArrayList<Integer> c3 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		for (int i = 0; i < 6; i++) {
			c3.remove(new Integer(Integer.parseInt(grid[i][2].getNumShown())));
		}
		for (int i = 0; i < numElements; i++) {
			int randomIndex = rand.nextInt(c3.size());
			int randomElement = c3.get(randomIndex);
			c3.remove(new Integer(randomElement));
			grid[i+6][2].changeNumShown(Integer.toString(randomElement));
		}
		

		for (int r = 6; r < 9; r++) {
			for (int c = 0; c < 3; c++) {
				if (r == 6) {
					row1Box7.add(Integer.parseInt(grid[r][c].getNumShown()));
				} else if (r == 7) {
					row2Box7.add(Integer.parseInt(grid[r][c].getNumShown()));
				} else if (r == 8) {
					row3Box7.add(Integer.parseInt(grid[r][c].getNumShown()));
				}
			}
		}
		
		rows23Box7.addAll(row2Box7);
		rows23Box7.addAll(row3Box7);
		rows13Box7.addAll(row1Box7);
		rows13Box7.addAll(row3Box7);
		rows12Box7.addAll(row1Box7);
		rows12Box7.addAll(row2Box7);
		
		
		for (int i = 0; i < 6; i++) {
			if (i < 3) {
				cols23Box2.add(Integer.parseInt(grid[i][4].getNumShown()));
			} else {
				cols23Box2.add(Integer.parseInt(grid[i-3][5].getNumShown()));
			}
		}
		
		for (int i = 0; i < 6; i++) {
			if (i < 3) {
				cols13Box2.add(Integer.parseInt(grid[i][3].getNumShown()));
			} else {
				cols13Box2.add(Integer.parseInt(grid[i-3][5].getNumShown()));
			}
		}
		
		for (int i = 0; i < 6; i++) {
			if (i < 3) {
				cols12Box2.add(Integer.parseInt(grid[i][3].getNumShown()));
			} else {
				cols12Box2.add(Integer.parseInt(grid[i-3][4].getNumShown()));
			}
		}
		
		for (int i = 0; i < 6; i++) {
			if (i < 3) {
				rows12Box4.add(Integer.parseInt(grid[3][i].getNumShown()));
			} else {
				rows12Box4.add(Integer.parseInt(grid[4][i-3].getNumShown()));
			}
		}

		//----------FINISH BOXES---------
		makeUpToBox9();
		
		//make array of all the nums //row by row 1-81
		
		for (int r = 0; r < GRIDSIZE; r++) { 
			for (int c = 0; c < GRIDSIZE; c++) {
				setGrid.add(Integer.parseInt(grid[r][c].getNumShown()));
			}
		}
		
		//empty out some cells
		Random random = new Random();
		int randomRow = 0;
		int randomCol = 0;
		for (int i = 0; i < numEmpty; i++) {
			randomRow = random.nextInt(GRIDSIZE);
			randomCol = random.nextInt(GRIDSIZE);
			grid[randomRow][randomCol].emptyNumber();
			grid[randomRow][randomCol].setNumber(false);
		}
		
		
		
	}
	
	 public <T> ArrayList<T> intersection(ArrayList<T> list1, ArrayList<T> list2, ArrayList<T> list3) {
		 ArrayList<T> list = new ArrayList<T>();
		 for (T t : list1) {
			 if(list2.contains(t) && list3.contains(t)) {
				 list.add(t);
			 }
		 }
		 return list;
	   }
	 public <T> ArrayList<T> intersection(ArrayList<T> list1, ArrayList<T> list2, ArrayList<T> list3, ArrayList<T> list4) {
		 ArrayList<T> list = new ArrayList<T>();
		 for (T t : list1) {
			 if(list2.contains(t) && list3.contains(t)&& list4.contains(t)) {
				 list.add(t);
			 }
		 }
		 return list;
	   }
	 public <T> ArrayList<T> intersection(ArrayList<T> list1, ArrayList<T> list2, ArrayList<T> list3, ArrayList<T> list4, ArrayList<T> list5) {
		 ArrayList<T> list = new ArrayList<T>();
		 for (T t : list1) {
			 if(list2.contains(t) && list3.contains(t)&& list4.contains(t) && list5.contains(t)) {
				 list.add(t);
			 }
		 }
		 return list;
	   }
	
	 public void checkAnswer(ArrayList<Integer> list) { //put in the list of numshown
		 //make it here
		 //make 2D array of the numShown 
		 for (int r = 0; r < GRIDSIZE; r++) { 
			for (int c = 0; c < GRIDSIZE; c++) {
				if (grid[r][c].getNumShown() == "") {
					yourNum = 0;
				} else {
					yourNum = Integer.parseInt(grid[r][c].getNumShown());
				}
				yourGrid.add(yourNum);
			}
		}
		
		if (yourGrid.equals(list)) {
			UIManager.put("OptionPane.background", Color.white);
	        UIManager.put("Panel.background", Color.white);
	        UIManager.put("Button.background", Color.white);
	        UIManager.put("Button.foreground", Color.black);
	        JLabel congratsLabel = new JLabel("", JLabel.CENTER);
	        congratsLabel.setForeground(Color.black);
	        ImageIcon congrats = new ImageIcon("congrats.gif");
			Object[] options = {"New Game", "Exit"};
			int n = JOptionPane.showOptionDialog(null, congratsLabel, "", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, congrats, options, options[0]);
			if (n == 0) {
				newPuzzle();
			}
		} 
		yourGrid.clear();
	}
	 
	public void makeUpToElement33() { //A OF BOX5
		int index33 = rand.nextInt(intersection(box5, rows23Box4, cols23Box2).size());
		int element33 = intersection(box5, rows23Box4, cols23Box2).get(index33);
		box5.remove(new Integer(element33));
		grid[3][3].changeNumShown(Integer.toString(element33));
		row1Box5.add(element33);
		col1Box5.add(element33);
	}

	public void makeUpToElement34() { // up to B OF BOX5
		makeUpToElement33();
		int index34 = rand.nextInt(intersection(box5, rows23Box4, cols13Box2).size());
		int element34 = intersection(box5, rows23Box4, cols13Box2).get(index34);
		box5.remove(new Integer(element34));
		grid[3][4].changeNumShown(Integer.toString(element34));
		col2Box5.add(element34);
		row1Box5.add(element34);
	}
	
	public void makeUpToElement43() { //up to D OF BOX5
		makeUpToElement34();
		int index43 = rand.nextInt(intersection(box5, rows13Box4, cols23Box2).size());
		int element43 = intersection(box5, rows13Box4, cols23Box2).get(index43);
		box5.remove(new Integer(element43));
		grid[4][3].changeNumShown(Integer.toString(element43));	
		row2Box5.add(element43);
		col1Box5.add(element43);
	}
	
	
	public void makeUpToElement35() { //up to C OF BOX5// you can't make C unless there's an intersection(rows23Box4, cols12Box2, box5)
		do {
			box5.clear();
			box5.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
			box6.clear();
			box6.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
			box7.clear();
			box7.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
			box8.clear();
			box8.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
			box9.clear();
			box9.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
			
			col1Box5.clear();
			col2Box5.clear();
			col3Box5.clear();
			row1Box5.clear();
			row2Box5.clear();
			row3Box5.clear();
			rows13Box5.clear();
			rows12Box5.clear();
			rows23Box5.clear();
			
			cols23Box5.clear();
			cols13Box5.clear();
			cols12Box5.clear();

			row1Box8.clear();
			row2Box8.clear();
			row3Box8.clear();
			rows13Box8.clear();
			rows12Box8.clear();
			rows23Box8.clear();

			col1Box6.clear();
			col2Box6.clear();
			col3Box6.clear();
			cols23Box6.clear();
			cols13Box6.clear();
			cols12Box6.clear();

			makeUpToElement43();
			
		} while (intersection(rows23Box4, cols12Box2, box5).size() == 0);
		int index35 = rand.nextInt(intersection(box5, rows23Box4, cols12Box2).size());
		int element35 = intersection(box5, rows23Box4, cols12Box2).get(index35);
		box5.remove(new Integer(element35));
		grid[3][5].changeNumShown(Integer.toString(element35));
		col3Box5.add(element35);
		row1Box5.add(element35);
	}
	
	public void makeUpToElement53() { //up to G OF BOX5// can't make G unless there's an intersection(rows12Box4, cols23Box2, box5)
		do {
			makeUpToElement35();
		} while (intersection(rows12Box4, cols23Box2, box5).size() == 0);
		int index53 = rand.nextInt(intersection(box5, rows12Box4, cols23Box2).size());
		int element53 = intersection(box5, rows12Box4, cols23Box2).get(index53);
		box5.remove(new Integer(element53));
		grid[5][3].changeNumShown(Integer.toString(element53));
		row3Box5.add(element53);
		col1Box5.add(element53);
	}
	
	public void makeUpToElement44() { //up to E OF BOX5//can't make E unless there's an intersection (rows13Box4, cols13Box2, box5)
		do {
			makeUpToElement53();
		} while (intersection(rows13Box4, cols13Box2, box5).size() == 0);
		int index44 = rand.nextInt(intersection(box5, rows13Box4, cols13Box2).size());
		int element44 = intersection(box5, rows13Box4, cols13Box2).get(index44);
		box5.remove(new Integer(element44));
		grid[4][4].changeNumShown(Integer.toString(element44));
		col2Box5.add(element44);
		row2Box5.add(element44);
	}
	public void makeUpToElement45() { // up to F OF BOX5// can't make F unless there's an intersection(rows13Box4, cols12Box2, box5)
		do {
			makeUpToElement44();
		} while (intersection(rows13Box4, cols12Box2, box5).size() == 0);
		int index45 = rand.nextInt(intersection(box5, rows13Box4, cols12Box2).size());
		int element45 = intersection(box5, rows13Box4, cols12Box2).get(index45);
		box5.remove(new Integer(element45));
		grid[4][5].changeNumShown(Integer.toString(element45));
		col3Box5.add(element45);
		row2Box5.add(element45);
	}
	
	public void makeUpToElement54() {//up to H OF BOX5 // can't make H unless there's an intersection(rows12Box4, cols13Box2, box5
		do {
			makeUpToElement45();
		} while (intersection(rows12Box4, cols13Box2, box5).size() == 0);
		int index54 = rand.nextInt(intersection(box5, rows12Box4, cols13Box2).size());
		int element54 = intersection(box5, rows12Box4, cols13Box2).get(index54);
		box5.remove(new Integer(element54));
		grid[5][4].changeNumShown(Integer.toString(element54));
		col2Box5.add(element54);
		row3Box5.add(element54);
	}
	
	public void makeUpToBox5() {
		makeUpToElement54();
		
		//I
		grid[5][5].changeNumShown(Integer.toString(box5.get(0)));
		col3Box5.add(box5.get(0));
		row3Box5.add(box5.get(0));

		rows23Box5.addAll(row2Box5);
		rows23Box5.addAll(row3Box5);
		rows13Box5.addAll(row1Box5);
		rows13Box5.addAll(row3Box5);
		rows12Box5.addAll(row1Box5);
		rows12Box5.addAll(row2Box5);
		
		cols23Box5.addAll(col2Box5);
		cols23Box5.addAll(col3Box5);
		cols13Box5.addAll(col1Box5);
		cols13Box5.addAll(col3Box5);
		cols12Box5.addAll(col1Box5);
		cols12Box5.addAll(col2Box5);
	}
	
	public void makeUpToElement36() { //A OF BOX6
		do {
			makeUpToBox5();
		} while (intersection(rows23Box4, rows23Box5, cols23Box3, box6).size() == 0);
		
		int index36 = rand.nextInt(intersection(rows23Box4, rows23Box5, cols23Box3, box6).size());
		int element36 = intersection(rows23Box4, rows23Box5, cols23Box3, box6).get(index36);
		box6.remove(new Integer(element36));
		grid[3][6].changeNumShown(Integer.toString(element36));
		col1Box6.add(element36);
		
	}
	
	public void makeUpToElement37() { // B of BOX6
		do {
			makeUpToElement36();
		} while (intersection(rows23Box4, rows23Box5, cols13Box3, box6).size() == 0);
		int index37 = rand.nextInt(intersection(rows23Box4, rows23Box5, cols13Box3, box6).size());
		int element37 = intersection(rows23Box4, rows23Box5, cols13Box3, box6).get(index37);
		box6.remove(new Integer(element37));
		grid[3][7].changeNumShown(Integer.toString(element37));
		col2Box6.add(element37);
	}
	
	public void makeUpToElement46() { // D of BOX6
		do {
			makeUpToElement37();
		} while (intersection(rows13Box4, rows13Box5, cols23Box3, box6).size() == 0);
		int index46 = rand.nextInt(intersection(rows13Box4, rows13Box5, cols23Box3, box6).size());
		int element46 = intersection(rows13Box4, rows13Box5, cols23Box3, box6).get(index46);
		box6.remove(new Integer(element46));
		grid[4][6].changeNumShown(Integer.toString(element46));
		col1Box6.add(element46);
	}
	
	public void makeUpToElement38() { //C of BOX6 
		do {
			makeUpToElement46();
		} while (intersection(rows23Box4, rows23Box5, cols12Box3, box6).size() == 0);
		grid[3][8].changeNumShown(Integer.toString(intersection(rows23Box4, rows23Box5, cols12Box3, box6).get(0)));
		col3Box6.add((intersection(rows23Box4, rows23Box5, cols12Box3, box6).get(0)));
		box6.remove(intersection(rows23Box4, rows23Box5, cols12Box3, box6).get(0));
	}
	
	public void makeUpToElement56() { //G of BOX6
		do {
			makeUpToElement38();
		} while (intersection(rows12Box4, rows12Box5, cols23Box3, box6).size() == 0);
		int index56 = rand.nextInt(intersection(rows12Box4, rows12Box5, cols23Box3, box6).size());
		int element56 = intersection(rows12Box4, rows12Box5, cols23Box3, box6).get(index56);
		box6.remove(new Integer(element56));
		grid[5][6].changeNumShown(Integer.toString(element56));
		col1Box6.add(element56);
	}
	
	public void makeUpToElement47() { //E of BOX6
		do {
			makeUpToElement56();
		} while (intersection(rows13Box4, rows13Box5, cols13Box3, box6).size() == 0);
		int index47 = rand.nextInt(intersection(rows13Box4, rows13Box5, cols13Box3, box6).size());
		int element47 = intersection(rows13Box4, rows13Box5, cols13Box3, box6).get(index47);
		box6.remove(new Integer(element47));
		grid[4][7].changeNumShown(Integer.toString(element47));
		col2Box6.add(element47);
	}
	
	public void makeUpToElement48() { //F of BOX6 
		do {
			makeUpToElement47();
		} while (intersection(rows13Box4, rows13Box5, cols12Box3, box6).size() == 0);
		grid[4][8].changeNumShown(Integer.toString(intersection(rows13Box4, rows13Box5, cols12Box3, box6).get(0)));
		col3Box6.add(intersection(rows13Box4, rows13Box5, cols12Box3, box6).get(0));
		box6.remove(intersection(rows13Box4, rows13Box5, cols12Box3, box6).get(0));
	}
	
	public void makeUpToElement57() { //H of BOX6
		do {
			makeUpToElement48();
		} while (intersection(rows12Box4, rows12Box5, cols13Box3, box6).size() == 0);
		int index57 = rand.nextInt(intersection(rows12Box4, rows12Box5, cols13Box3, box6).size());
		int element57 = intersection(rows12Box4, rows12Box5, cols13Box3, box6).get(index57);
		box6.remove(new Integer(element57));
		grid[5][7].changeNumShown(Integer.toString(element57));
		col2Box6.add(element57);
	}
	
	public void makeUpToBox6() {
		do {
			makeUpToElement57();
		} while (intersection(rows12Box4, rows12Box5, cols12Box3, box6).size() == 0);
		
		//I
		grid[5][8].changeNumShown(Integer.toString(box6.get(0)));
		col3Box6.add(box6.get(0));
		
		cols23Box6.addAll(col2Box6);
		cols23Box6.addAll(col3Box6);
		cols13Box6.addAll(col1Box6);	
		cols13Box6.addAll(col3Box6);
		cols12Box6.addAll(col1Box6);
		cols12Box6.addAll(col2Box6);
	}
	
	public void makeUpToElement63() { //A OF BOX8
		do {
			makeUpToBox6();
		} while (intersection(rows23Box7, cols23Box2, cols23Box5, box8).size() == 0);
		
		int index63 = rand.nextInt(intersection(rows23Box7, cols23Box2, cols23Box5, box8).size());
		int element63 = intersection(rows23Box7, cols23Box2, cols23Box5, box8).get(index63);
		box8.remove(new Integer(element63));
		grid[6][3].changeNumShown(Integer.toString(element63));
		row1Box8.add(element63);
	}
	
	public void makeUpToElement64() { //B OF BOX8
		do {
			makeUpToElement63();
		} while (intersection(rows23Box7, cols13Box2, cols13Box5, box8).size() == 0);
		
		int index64 = rand.nextInt(intersection(rows23Box7, cols13Box2, cols13Box5, box8).size());
		int element64 = intersection(rows23Box7, cols13Box2, cols13Box5, box8).get(index64);
		box8.remove(new Integer(element64));
		grid[6][4].changeNumShown(Integer.toString(element64));
		row1Box8.add(element64);
	}
	
	public void makeUpToElement73() { //D OF BOX8
		do {
			makeUpToElement64();
		} while (intersection(rows13Box7, cols23Box2, cols23Box5, box8).size() == 0);
		
		int index73 = rand.nextInt(intersection(rows13Box7, cols23Box2, cols23Box5, box8).size());
		int element73 = intersection(rows13Box7, cols23Box2, cols23Box5, box8).get(index73);
		box8.remove(new Integer(element73));
		grid[7][3].changeNumShown(Integer.toString(element73));
		row2Box8.add(element73);
	}
	
	public void makeUpToElement65() { //C of BOX8
		do {
			makeUpToElement73();
		} while (intersection(rows23Box7, cols12Box2, cols12Box5, box8).size() == 0);
		int index65 = rand.nextInt(intersection(rows23Box7, cols12Box2, cols12Box5, box8).size());
		int element65 = intersection(rows23Box7, cols12Box2, cols12Box5, box8).get(index65);
		box8.remove(new Integer(element65));
		grid[6][5].changeNumShown(Integer.toString(element65));
		row1Box8.add(element65);
	}
	
	public void makeUpToElement83() { //G of BOX8
		do {
			makeUpToElement65();
		} while (intersection(rows12Box7, cols23Box2, cols23Box5, box8).size() == 0);
		int index83 = rand.nextInt(intersection(rows12Box7, cols23Box2, cols23Box5, box8).size());
		int element83 = intersection(rows12Box7, cols23Box2, cols23Box5, box8).get(index83);
		box8.remove(new Integer(element83));
		grid[8][3].changeNumShown(Integer.toString(element83));
		row3Box8.add(element83);
	}
	public void makeUpToElement74() { //E of BOX8
		do {
			makeUpToElement83();
		} while (intersection(rows13Box7, cols13Box2, cols13Box5, box8).size() == 0);
		int index74 = rand.nextInt(intersection(rows13Box7, cols13Box2, cols13Box5, box8).size());
		int element74 = intersection(rows13Box7, cols13Box2, cols13Box5, box8).get(index74);
		box8.remove(new Integer(element74));
		grid[7][4].changeNumShown(Integer.toString(element74));
		row2Box8.add(element74);
	}
	public void makeUpToElement75() { //F of BOX8
		do {
			makeUpToElement74();
		} while (intersection(rows13Box7, cols12Box2, cols12Box5, box8).size() == 0);
		int index75 = rand.nextInt(intersection(rows13Box7, cols12Box2, cols12Box5, box8).size());
		int element75 = intersection(rows13Box7, cols12Box2, cols12Box5, box8).get(index75);
		box8.remove(new Integer(element75));
		grid[7][5].changeNumShown(Integer.toString(element75));
		row2Box8.add(element75);
	}
	public void makeUpToElement84() { //H of BOX8
		do {
			makeUpToElement75();
		} while (intersection(rows12Box7, cols13Box2, cols13Box5, box8).size() == 0);
		int index84 = rand.nextInt(intersection(rows12Box7, cols13Box2, cols13Box5, box8).size());
		int element84 = intersection(rows12Box7, cols13Box2, cols13Box5, box8).get(index84);
		box8.remove(new Integer(element84));
		grid[8][4].changeNumShown(Integer.toString(element84));
		row3Box8.add(element84);
	}
	public void makeUpToBox8() { //Box8 done
		do {
			makeUpToElement84();
		} while (intersection(rows12Box4, rows12Box5, cols12Box3, box6).size() == 0);

		//I
		grid[8][5].changeNumShown(Integer.toString(box8.get(0)));
		row3Box8.add(box8.get(0));
		
		rows23Box8.addAll(row2Box8);
		rows23Box8.addAll(row3Box8);
		rows13Box8.addAll(row1Box8);
		rows13Box8.addAll(row3Box8);
		rows12Box8.addAll(row1Box8);
		rows12Box8.addAll(row2Box8);
	}
	
	public void makeUpToElement66() { //A of Box9
		do {
			makeUpToBox8();
		} while (intersection(rows23Box7, rows23Box8, cols23Box3, cols23Box6, box9).size() == 0);
		int index66 = rand.nextInt(intersection(rows23Box7, rows23Box8, cols23Box3, cols23Box6, box9).size());
		int element66 = intersection(rows23Box7, rows23Box8, cols23Box3, cols23Box6, box9).get(index66);
		box9.remove(new Integer(element66));
		grid[6][6].changeNumShown(Integer.toString(element66));
	} 
	
	public void makeUpToElement67() { //B of Box9
		do {
			makeUpToElement66();
		} while (intersection(rows23Box7, rows23Box8, cols13Box3, cols13Box6, box9).size() == 0);
		int index67 = rand.nextInt(intersection(rows23Box7, rows23Box8, cols13Box3, cols13Box6, box9).size());
		int element67 = intersection(rows23Box7, rows23Box8, cols13Box3, cols13Box6, box9).get(index67);
		box9.remove(new Integer(element67));
		grid[6][7].changeNumShown(Integer.toString(element67));
	}
	
	public void makeUpToElement76() { //D of Box9
		do {
			makeUpToElement67();
		} while (intersection(rows13Box7, rows13Box8, cols23Box3, cols23Box6, box9).size() == 0);
		int index76 = rand.nextInt(intersection(rows13Box7, rows13Box8, cols23Box3, cols23Box6, box9).size());
		int element76 = intersection(rows13Box7, rows13Box8, cols23Box3, cols23Box6, box9).get(index76);
		box9.remove(new Integer(element76));
		grid[7][6].changeNumShown(Integer.toString(element76));
	}
	
	public void makeUpToElement68() { // C of Box9
		do {
			makeUpToElement76();
		} while (intersection(rows23Box7, rows23Box8, cols12Box3, cols12Box6, box9).size() == 0);
		grid[6][8].changeNumShown(Integer.toString(intersection(rows23Box7, rows23Box8, cols12Box3, cols12Box6, box9).get(0)));
		box9.remove(intersection(rows23Box7, rows23Box8, cols12Box3, cols12Box6, box9).get(0));
	}
	
	public void makeUpToElement86() { //G of Box9
		do {
			makeUpToElement68();
		} while (intersection(rows12Box7, rows12Box8, cols23Box3, cols23Box6, box9).size() == 0);
		int index86 = rand.nextInt(intersection(rows12Box7, rows12Box8, cols23Box3, cols23Box6, box9).size());
		int element86 = intersection(rows12Box7, rows12Box8, cols23Box3, cols23Box6, box9).get(index86);
		box9.remove(new Integer(element86));
		grid[8][6].changeNumShown(Integer.toString(element86));
	}
	
	public void makeUpToElement77() { //E of Box9
		do {
			makeUpToElement86();
		} while (intersection(rows13Box7, rows13Box8, cols13Box3, cols13Box6, box9).size() == 0);
		int index77 = rand.nextInt(intersection(rows13Box7, rows13Box8, cols13Box3, cols13Box6, box9).size());
		int element77 = intersection(rows13Box7, rows13Box8, cols13Box3, cols13Box6, box9).get(index77);
		box9.remove(new Integer(element77));
		grid[7][7].changeNumShown(Integer.toString(element77));
	}
	
	public void makeUpToElement78() { //F of Box9
		do {
			makeUpToElement77();
		} while (intersection(rows13Box7, rows13Box8, cols12Box3, cols12Box6, box9).size() == 0);
		int index78 = rand.nextInt(intersection(rows13Box7, rows13Box8, cols12Box3, cols12Box6, box9).size());
		int element78 = intersection(rows13Box7, rows13Box8, cols12Box3, cols12Box6, box9).get(index78);
		box9.remove(new Integer(element78));
		grid[7][8].changeNumShown(Integer.toString(element78));
	}
	
	public void makeUpToElement87() { //H of Box9
		do {
			makeUpToElement78();
		} while (intersection(rows12Box7, rows12Box8, cols13Box3, cols13Box6, box9).size() == 0);
		int index87 = rand.nextInt(intersection(rows12Box7, rows12Box8, cols13Box3, cols13Box6, box9).size());
		int element87 = intersection(rows12Box7, rows12Box8, cols13Box3, cols13Box6, box9).get(index87);
		box9.remove(new Integer(element87));
		grid[8][7].changeNumShown(Integer.toString(element87));
	}
	
	public void makeUpToBox9() {
		do {
			makeUpToElement87();
		} while (intersection(rows12Box7, rows12Box8, cols12Box3, cols12Box6, box9).size() == 0);
		grid[8][8].changeNumShown(Integer.toString(box9.get(0)));
	}
	

	public void resetAll() {
		box5.clear();
		box5.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		box6.clear();
		box6.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		box7.clear();
		box7.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		box8.clear();
		box8.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	
		box9.clear();
		box9.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		
		box1.clear();
		row1Box1.clear();
		row2Box1.clear();
		row3Box1.clear();
		col1Box1.clear();
		col2Box1.clear();
		col3Box1.clear();

		
		rows23Box1.clear();
		cols23Box1.clear();

		row1Box2.clear();
		row2Box2.clear();
		row3Box2.clear();
		col1Box2.clear();
		col2Box2.clear();
		col3Box2.clear();
		
		row1Box3.clear();
		row2Box3.clear();
		row3Box3.clear();
		
		row1Box4.clear();
		row2Box4.clear();
		row3Box4.clear();
		col1Box4.clear();
		col2Box4.clear();
		col3Box4.clear();

		rows23Box4.clear();
		cols23Box2.clear();
		cols13Box2.clear();
		cols12Box2.clear();
		rows13Box4.clear();
		rows12Box4.clear();
		
		row1Box5.clear();
		row2Box5.clear();
		row3Box5.clear();
		rows23Box5.clear();
		rows13Box5.clear();
		rows12Box5.clear();
		
		col1Box5.clear();
		col2Box5.clear();
		col3Box5.clear();
		cols23Box5.clear();
		cols13Box5.clear();
		cols12Box5.clear();
		
		col1Box3.clear();
		col2Box3.clear();
		col3Box3.clear();
		cols23Box3.clear();
		cols13Box3.clear();
		cols12Box3.clear();
		
		col1Box6.clear();
		col2Box6.clear();
		col3Box6.clear();
		cols23Box6.clear();
		cols13Box6.clear();
		cols12Box6.clear();
		
		row1Box7.clear();
		row2Box7.clear();
		row3Box7.clear();
		rows23Box7.clear();
		rows13Box7.clear();
		rows12Box7.clear();
		
		row1Box8.clear();
		row2Box8.clear();
		row3Box8.clear();
		rows23Box8.clear();
		rows13Box8.clear();
		rows12Box8.clear();
		
		for (int r = 0; r < GRIDSIZE; r++) {
			for (int c = 0; c < GRIDSIZE; c++) {
				grid[r][c].reset();
			}
		}
		setGrid.clear();
		yourGrid.clear();
		yourNum = 0;
	}

	public static void main(String[] args) {
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new Sudoku();
            }   
        });

	}

}
