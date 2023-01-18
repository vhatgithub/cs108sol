import java.util.Arrays;

//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		String rowType;
		int row;
		
		for(int i = 0; i < this.grid.length; i++) {
			rowType = this.getRowType(i);
			row = i;
			
			if(rowType == "filledRow") {
				while(row > 0 && getRowType(row - 1) == "partiallyFilledRow") {
					for(int j = 0; j < this.grid[row].length; j++) {
						this.grid[row][j] = this.grid[row - 1][j];
					}
					
					row--;
				}
				
				for(int j = 0; j < this.grid[row].length; j++) {
					this.grid[row][j] = false;
				}
			}
		}
	}
	
	private String getRowType(int rowIndex) {
		boolean fullRow = true;
		
		for(int j = 0; j < this.grid[rowIndex].length; j++) {
			if(this.grid[rowIndex][j] != this.grid[rowIndex][0]) {
				fullRow = false;
				break;
			}
		}
		
		if(fullRow && this.grid[rowIndex][0] == true) {
			return "filledRow";
		} else if(fullRow && this.grid[rowIndex][0] == false) {
			return "emptyRow";
		}
		
		return "partiallyFilledRow";
	}
	
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return this.grid;
	}
}
