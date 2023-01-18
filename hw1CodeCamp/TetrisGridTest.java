import junit.framework.TestCase;
import java.util.*;

public class TetrisGridTest extends TestCase {
	
	// Provided simple clearRows() test
	// width 2, height 3 grid
	public void testClear1() {
		boolean[][] before =
		{	
			{true, true, false, },
			{false, true, true, }
		};
		
		boolean[][] after =
		{	
			{true, false, false},
			{false, true, false}
		};
		
		TetrisGrid tetris = new TetrisGrid(before);
		tetris.clearRows();

//		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
		
		before = new boolean[][]
			{	
				{false, false, false},
				{false, false, false},
				{true, false, false},
				{false, true, true},
				{true, true, true},
				{true, true, false},
				{true, true, true}
			};
			
		after = new boolean[][]
			{	
			{false, false, false},
			{false, false, false},
			{false, false, false},
			{false, false, false},
			{true, false, false},
			{false, true, true},
			{true, true, false}
			};
			
		tetris = new TetrisGrid(before);
		tetris.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
	}
	
}
