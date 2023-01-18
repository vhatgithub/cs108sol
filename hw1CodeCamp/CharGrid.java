// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int charArea = 0;
		int initPosX = -1, initPosY = -1, finalPosX = 0, finalPosY = 0;
		
		for(int i = 0; i < this.grid.length; i++) {
			for(int j = 0; j < this.grid[i].length; j++) {
				if(initPosX == -1 && initPosY == -1 && ch == this.grid[i][j]) {
					initPosX = i;
					initPosY = j;
				}
				
				if(ch == this.grid[i][j]) {
					finalPosX = i + 1;
					finalPosY = finalPosY < (j + 1) ? j + 1 : finalPosY;
				}
				
			}
		}
		
		charArea = finalPosX == 0 ? 0 : (finalPosX - initPosX) * (finalPosY - initPosY);
		
		return charArea;
	}
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int plusCount = 0, armStartPos = 0, armLen = 1, midArmPos, upArmLen = 0, downArmLen = 0;
		char currentChar, prevChar;
		
//		First and last cannot create a plus of a char, so start from 2nd row, end to 2nd last row
		for(int i = 1; i < this.grid.length - 1; i++) {
			armLen = 1;
			armStartPos = 0;
			
			for(int j = 1; j < this.grid[i].length; j++) {
				currentChar = this.grid[i][j];
				prevChar = this.grid[i][j - 1];
				
				if(currentChar == prevChar && prevChar != ' ') {
					armLen++;
					
					if(j < this.grid[i].length - 1) {
						continue;
					}
				}
				
				if(armLen > 1 && armLen % 2 == 1) {
					midArmPos = armStartPos + (j - armStartPos) / 2;
					
					upArmLen = computeUpArmLen(i, midArmPos, prevChar);
					downArmLen = computeDownArmLen(i, midArmPos, prevChar);
					
					if(armLen / 2 == upArmLen && armLen / 2 == downArmLen) {
						plusCount++;
					}
				}
				
				if(currentChar != prevChar) {
					armLen = 1;
					armStartPos = j;
				}
			}
		}
		
		
		return plusCount;
	}
	
	private int computeUpArmLen(int rowIndex, int midArmPos, char ch) {
		int armLen = 0;
		
		while(rowIndex > 0 && this.grid[--rowIndex][midArmPos] == ch) {
			armLen++;
		}
		
		return armLen;
	}
	
	private int computeDownArmLen(int rowIndex, int midArmPos, char ch) {
		int armLen = 0;
		
		while(rowIndex < this.grid.length - 1 && this.grid[++rowIndex][midArmPos] == ch) {
			armLen++;
		}
		
		return armLen;
	}
	
}
