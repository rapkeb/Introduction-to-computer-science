

public class KQueens {

    //Use these constants in your code
    final static int QUEEN = 1;
    final static int WALL = -1;
    final static int EMPTY = 0;


    public static boolean isValidboard(int[][]board){
    	boolean isValid = true;
    	for(int i = 0; i<board.length;i = i+1)
    	{
    		for(int j = 0; j<board[i].length; j=j+1)
    			if(board[i][j] != QUEEN & board[i][j] != WALL & board[i][j] != EMPTY)
    				isValid = false;
    	}
    	return isValid;
    }
    
    
    /**
     * Checks if the input parameters are valid
     *
     * @param k number of queens
     * @param rows number of rows to be on a board
     * @param cols number of columns to be on a board
     * @param walls locations of walls on a board
     * @return true if all parameters are valid, false otherwise.
     */
    public static boolean isValidInput(int k, int rows, int cols, int[][] walls){
    	boolean isValid = true;
    	int count = 0;
    	int SizeOfBoard = rows * cols;
    	if(walls == null || k<1 | rows<1 | cols<1 | walls.length != rows)
    		isValid = false;
    	else
    	{
    		for(int i = 0; i<walls.length & isValid; i = i+1)
    			if(walls[i] == null)
    				isValid = false;
    	}
    	for(int j =0; j<walls.length & isValid; j=j+1)
    	{
    		for(int x = 0; x<walls[j].length; x =x+1)
    		{
    			if(walls[j][x] >= cols)
					isValid = false;
    		}
    		count = count + walls[j].length;
    	}
    	if(SizeOfBoard - count < k)
    		isValid = false;
        return isValid;//replace with return statement
    }

    /**
     * Creates a board of size rows x cols with walls
     *
     * @param rows number of rows in board. Assume valid value.
     * @param cols number of columns in board. Assume valid value.
     * @param walls locations of walls on board. Assume valid value.
     * @return rows x cols board with walls
     */
    public static int[][] createBoard(int rows, int cols, int[][] walls){
    	int [][] newBoard = new int [rows][cols];
    	for(int i = 0; i<rows; i=i+1)
    	{
    		for(int j = 0; j<cols; j=j+1)
    			newBoard[i][j] = EMPTY;
    	}
    	for (int x = 0; x<walls.length; x=x+1)
    	{
    		for(int y = 0; y<walls[x].length; y=y+1)
    			newBoard[x][walls[x][y]] = WALL;
    	}
        return newBoard;//replace with return statement
    }

    /**
     * Print the representation of a board with queens and walls
     *
     * @param board to be printed. Assume valid value.
     */
    public static void printBoard(int[][] board){
    	int count = 0;
    	for(int i = 0; i<board.length; i=i+1)
    	{
    		if(board[i].length > 0)
    			count = count+1;
    	}
    	if(count == 0)
    		System.out.println("There is no solution");
    	else 
    	{
    	for (int j =0; j<board.length; j=j+1)
    	{
    		for(int x = 0; x<board[j].length; x=x+1)
    		{
    			if(board[j][x] == QUEEN)
    				System.out.print('Q' + " ");
    			else
    				if(board[j][x] == WALL)
    					System.out.print('X' + " ");
    				else
    					System.out.print('*' + " ");
    		}
    		System.out.println();
    	}
    	}
    	}

    /**
     * Validate that the walls in board match the walls locations in walls
     *
     * @param walls locations of walls in board. Assume valid value.
     * @param board a board with walls
     * @return true if walls on boards match the walls locations, false otherwise
     */
    public static boolean validateWalls(int[][] walls, int[][] board){
    	boolean isValid = true;
    	int count = 0;
    	int count1 = 0;
    	if (board == null)
    		isValid = false;
    		for(int i = 0; i<board.length & isValid; i = i+1)
    		{
    			if(board[i] == null)
    				isValid = false;
    		}
    		for(int j = 0; j<walls.length & isValid; j=j+1)
    			for(int x = 0; x < walls[j].length & isValid; x=x+1)
    			{
    				if(board[j][walls[j][x]] != WALL)
    					isValid = false;
    			}
    			for(int i = 0; i<board.length & isValid; i=i+1)
    			{
    				for(int j = 0; j<board[i].length & isValid; j=j+1)
    					if(board[i][j] == WALL)
    					{
    						count = count + 1;
    						for(int x = 0; x<walls[i].length; x=x+1)
    							if (walls[i][x] == j)
    								count1 = count1 + 1;
    								
    					}
    			}
    			if(count != count1)
    				isValid = false;
        return isValid ;//replace with return statement
    }



    /**
     * Check if the queen located in board[row][col] is threatened by another queen on the board
     *
     * @param board a queen is located on this board
     * @param row the row in which the queen is located
     * @param col the column in which the queen is located
     * @return true if queen is threatened, false otherwise
     */
    public static boolean isQueenThreatened(int[][] board, int row, int col){
    	boolean isThreatened = false;
    	for(int i = col + 1; i<board[row].length & !isThreatened; i = i+1)
    	{
    		if(board[row][i] == WALL)
    			isThreatened = true;
    		else{
    		if(board[row][i] == QUEEN)
    			return true;
    		}
    	}
    	isThreatened = false;
    	for(int i = col - 1; i>=0 & !isThreatened; i = i-1)
    	{
    		if(board[row][i] == WALL)
    			isThreatened = true;
    		else{
    		if(board[row][i] == QUEEN)
    			return true;
    		}
    	}
    	isThreatened = false;
    	for(int j = row + 1; j<board.length & !isThreatened; j = j+1)
    	{
    		if(board[j][col] == WALL)
    			isThreatened = true;
    		else{
    		if(board[j][col] == QUEEN)
    			return true;
    		}
    	}
    	isThreatened = false;
    	for(int j = row - 1; j>=0 & !isThreatened; j = j-1)
    	{
    		if(board[j][col] == WALL)
    			isThreatened = true;
    		else{
    		if(board[j][col] == QUEEN)
    			return true;
    		}
    	}
    	isThreatened = false;
    	for(int i = row + 1,j = col + 1; i<board.length & j<board[row].length & !isThreatened; i = i+1,j = j+1)
    		{
    			if(board[i][j] == WALL)
        			isThreatened = true;
    			else{
        		if(board[i][j] == QUEEN)
        			return true;
    			}
        	}
    	isThreatened = false;
    	for(int i = row - 1,j = col - 1; i>=0 & j>=0 & !isThreatened; i = i-1,j = j-1)
    		{
    			if(board[i][j] == WALL)
        			isThreatened = true;
    			else{
        		if(board[i][j] == QUEEN)
        			return true;
    			}
        	}
    	isThreatened = false;
    	for(int i = row + 1,j = col - 1; i<board.length & j>=0 & !isThreatened; i = i+1,j = j-1)
    		{
    			if(board[i][j] == WALL)
        			isThreatened = true;
    			else{
        		if(board[i][j] == QUEEN)
        			return true;
    			}
        	}
    	isThreatened = false;
    	for(int i = row - 1,j = col + 1; i>=0 & j<board[row].length & !isThreatened; i = i-1,j = j+1)
    		{
    			if(board[i][j] == WALL)
        			isThreatened = true;
    			else{
        		if(board[i][j] == QUEEN)
        			return true;
    			}
        	}
    	return false ;//replace with return statement
    }


    /**
     * Check if board is a legal solution for k queens
     *
     * @param board a solution for the k-queens problem. Assume board not null and not empty, and each cell not null.
     * @param k number of queens that must be on the board. Assume k>=1.
     * @param rows number of rows that must be on the board. Assume rows>=1.
     * @param cols number of columns that must be on the board. Assume cols>=1.
     * @param walls locations of walls that must be on board. Assume valid value.
     * @return true if board is a legal solution for k queens, otherwise false
     */
    public static boolean isLegalSolution(int[][] board, int k, int rows, int cols, int[][] walls){
    	if((board.length != rows) | (board[0].length != cols))
    		return false;
    	if(!KQueens.validateWalls(walls, board) | !KQueens.isValidboard(board))
    			return false;
    	int counter = 0;
    	for(int i = 0; i<board.length; i=i+1)
    	{
    		for(int j = 0; j<board[i].length; j=j+1)
    		{
    			if(board[i][j] == QUEEN)
    			{
    				counter = counter + 1;
    				if(KQueens.isQueenThreatened(board, i, j))
    					return false;
    			}
    		}
    	}
    	if(counter != k)
    		return false;
    	return true;//replace with return statement
    }

    /**
     * Adds queen to cell board[row][col] if the board obtained by adding the queen is legal
     *
     * @param board represents a partial solution for k'<k queens. Assume valid value.
     * @param row queen must be added to this row. Assume valid value.
     * @param col queen must be added to this column. Assume valid value.
     * @return true if queen was added, otherwise false.
     */
    public static boolean addQueen(int[][] board, int row, int col){
    	boolean addQueen = false;
    	if(board[row][col] == EMPTY)
    	{
    	if(!KQueens.isQueenThreatened(board, row, col))
    	{
    		board[row][col] = QUEEN;
    		addQueen = true;
    	}
    	}
    	return addQueen ;//replace with return statement
    }

    /**
     * Solves the k queens problem.
     *
     * @param k number of queens to be located on the board
     * @param rows number of rows in the board
     * @param cols number of columns in the board
     * @param walls locations of walls on the board
     * @return board that is a legal solution, empty board if there is no solution
     */
    public static int[][] kQueens(int k, int rows, int cols, int[][] walls){
    	int [][] nosolution = new int [0][0];
    	if(!KQueens.isValidInput(k, rows, cols, walls))
    		return nosolution;
    	int [][] solution = KQueens.createBoard(rows, cols, walls);
    	if(KQueens.kQueens(solution, k,0,0,0))
    		return solution;
    	return nosolution ;//replace with return statement
    }

    /**
     * Recursive helper function for the k queens problem
     * @param board
     * @param k
     * @param row
     * @param col
     * @param numOfQueens
     * @return
     */
    private static boolean kQueens(int[][] board, int k, int row, int col, int numOfQueens){
    	int numQueens = KQueens.count(board);
    	if(numQueens == k)
    		return true;
    	int nextcol = col + 1 ;
    	int nextrow = row ;
    	if(board[row].length-1<nextcol)
    	{
    		nextcol = 0 ;
    	nextrow = row + 1;
    	}
    	if(nextrow == board.length)
    		return false;
    	boolean canadd = false;
    	if(KQueens.addQueen(board, row, col))
    	{
    		canadd = KQueens.kQueens(board, k, nextrow, nextcol, numOfQueens + 1);
    		if(!canadd)
    			board[row][col] = EMPTY;
    	}
    	boolean cantadd = KQueens.kQueens(board, k, nextrow, nextcol, numOfQueens);
    	return cantadd || canadd ;
    }
    
    private static int count(int[][]board){
    	int counter = 0 ;
    	for(int i = 0 ; i<board.length;i=i+1)
    	{
    		for(int j = 0 ; j<board[i].length;j=j+1)
    		{
    			if(board[i][j] == QUEEN)
    			counter = counter + 1;
    		}
    	}
    	return counter;
    }
}
