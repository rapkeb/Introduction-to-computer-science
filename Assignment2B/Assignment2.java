
public class Assignment2 {

	// Task 1
	public static boolean isSquareMatrix(boolean[][] matrix){
		boolean ans= true;
		if (matrix == null)
			ans= false;
		else
		{
		for (int i=0; i<matrix.length; i = i+1)
		{
			if (matrix[i] == null || matrix[i].length == 0)
				ans= false;
			else {
			if (matrix.length != matrix[i].length)
				ans= false;
			}
		}
		}
		return ans;
	}
	
	
	public static boolean isSquare(int[][] matrix){ //helping function
		boolean ans= true;
		if (matrix == null)
			ans= false;
		else
		{
		for (int i=0; i<matrix.length; i = i+1)
		{
			if (matrix[i] == null || matrix[i].length == 0)
				ans= false;
			else {
			if (matrix.length != matrix[i].length)
				ans= false;
			}
		}
		}
		return ans;
	}

	// Task 2
	public static boolean isSymmetricMatrix(boolean[][] matrix){
		boolean ans= true;
		if(matrix == null)
			ans = false;
		else
		{
		for(int i = 0; i < matrix.length & ans; i = i+1)
		{
			for(int j = i; j<matrix[i].length & ans; j = j+1)
				if(matrix[i][j] != matrix[j][i])
				ans= false;
		}
		}
			return ans;
		}

	// Task 3
	public static boolean isAntiReflexiveMatrix(boolean[][] matrix){
		boolean anti = true;
		if(matrix == null)
			anti = false;
		else 
		{
		for (int i = 0; i < matrix.length & anti; i = i+1)
		{
			if(matrix[i].length != matrix.length || matrix[i][i] != false)
			anti = false;
		}
		}
			return anti;
		}

	// Task 4
	public static boolean isLegalInstance(boolean[][] matrix){

		boolean square=(Assignment2.isSquareMatrix(matrix));
		boolean symet=(Assignment2.isSymmetricMatrix(matrix));
		boolean anti= (Assignment2.isAntiReflexiveMatrix(matrix));
		boolean islegal = false;
		if((anti == true) & (symet == true) & (square == true))
			islegal = true; //if the conditions are true the trip is legal
		return islegal;
		}

	// Task 5
	public static boolean isPermutation(int[] array){
		boolean permition = true;
		int count = 0;
		for (int i = 0; i<array.length; i = i+1)
		{
			for (int j = 0; j<array.length; j = j+1)
			{
				if(array[j] == i)
					count = count+1;
			}
			if(count != 1)
				permition = false; //if the city is shown more than 1 time or isn't at all the trip is illegal
				count = 0;
		}
			return permition;
		}

	
	// Task 6
	public static boolean hasLegalSteps(boolean[][] flights, int[] tour){
		boolean LegalSteps = true;
		for(int i = 0; i<tour.length -1 & LegalSteps; i = i+1)
		{
			if(!flights[tour[tour.length-1]][tour[0]])
				LegalSteps = false;
			if(!flights[tour[i]][tour[i+1]])
			LegalSteps = false;
		}
			return LegalSteps;
		}

	// Task 7
	public static boolean isSolution(boolean[][] flights, int[] tour){
		boolean solution = true;
		if (tour == null)
			solution = false;
		else
		{
		if((tour.length) != (flights.length))
			throw new IllegalArgumentException("Illegal Variables");
		boolean Permition = (Assignment2.isPermutation(tour));
			if (tour[0] == 0 & Permition)
				solution = (Assignment2.hasLegalSteps(flights,tour)); 
			else 
			solution = false;
		}
			return solution;
		}

	// Task 8
	public static int[][] atLeastOne(int[] vars) {
		int[][] cnf = new int[1][vars.length];
		for (int i = 0; i<vars.length;i = i+1)
			cnf[0][i] = vars[i];
		return cnf;

	}

	// Task 9
	public static int[][] atMostOne(int[] vars) {
		int options = 0;
		for (int x = 1; x < vars.length; x = x + 1)
			options = options + x;
		int[][] cnf = new int[options][2];
		for (int i = 0; i < vars.length - 1; i = i + 1) {
			for (int j = i + 1; j < vars.length; j = j + 1) {
				cnf[options - 1][0] = -vars[i];
				cnf[options - 1][1] = -vars[j];
				options = options - 1;
			}
		}
		return cnf;
	}

	// Task 10
	public static int[][] exactlyOne(int[] vars) {
		int options = 1;
		for (int x = 1; x < vars.length; x = x + 1)
			options = options + x;
		int[][] cnf = new int[options][];
		for (int i = 0; i < options-1; i = i + 1)
			cnf[i] = (atMostOne(vars)[i]);
		cnf[options-1] = vars;
		return cnf;
	}

	// Task 11
	public static boolean[] solveExactlyOneForEachSet(int[][] varSets) {
		int sum = 0;
		int j = 0;
		int index = 0;
		int nVars = 0;
		for (int i = 0; i<varSets.length; i = i+1){
			sum = sum + ((varSets[i].length*(varSets[i].length-1))/2);
			for(int z = 0; z<varSets[i].length; z=z+1)
				if((varSets[i][z]) > nVars)
					nVars = varSets[i][z];
		}
		int [][] cnf = new int[sum][];
		while(j<cnf.length)
		{
			for(int x = 0; x<(exactlyOne(varSets[index]).length); x=x+1)
			{
				cnf[j] = (exactlyOne(varSets[index]))[x];
				j=j+1;
			}
			index = index + 1 ;
		} 
		SATSolver.init(nVars);
		SATSolver.addClauses(cnf);
		boolean[] assignment = SATSolver.getSolution() ; 
		if (assignment == null)       
			throw new RuntimeException("Timeout");
		return assignment;
	}

	// Task 12
	public static int[][] createVarsMap(int n) {
		int [][] map = new int [n][n];
		for (int i = 0; i<n; i=i+1)
		{
			for (int j = 0; j<n; j=j+1)
				map[i][j] = i*n + j + 1;
		}
		return map;
	}

	// Task 13
	public static int[][] oneCityInEachStep(int[][] map) {
		int sum = 0;
		int count = 0;
		sum = sum + ((map[0].length*(map[0].length-1)/2)+1)*map.length;
		int [][] cnf = new int [sum][];
		for(int j = 0; j<map.length; j=j+1)
		{
			for(int x=0; x<Assignment2.exactlyOne(map[j]).length; x=x+1)
			{
				cnf[count] = (Assignment2.exactlyOne(map[j]))[x];
			count = count+1;
			}
		}
		return cnf;
	}

	// Task 14
	public static int[][] fixSourceCity(int[][] map) {
		int [][] Source = new int [1][1];
		Source[0][0] = map[0][0];
		return Source;
	}

	// Task 15
	public static int[][] eachCityIsVisitedOnce(int[][] map) {
		int [][] newMap = new int [map[0].length][map.length];
		for(int i=0; i<map.length; i=i+1)
		{
			for(int j=0; j<map[0].length; j=j+1)
				newMap[i][j] = map[j][i] ;
		}
		int [][] cnf = Assignment2.oneCityInEachStep(newMap);
		return cnf;
	}

	// Task 16
	public static int[][] noIllegalSteps(boolean[][] flights, int[][] map) {
		int count1=0;
		   int count2=0;
		   for(int x=0;x<flights.length;x=x+1){
		      if((flights[0][x]==false)&(x!=0))
		         count2=count2+1;
		      for(int z=0;z<flights.length;z=z+1){
		         if((flights[x][z]==false)&(x!=z))
		            count1=count1+1;
		      }
		   }
		   int [][]cnf=new int[(count1*(map.length-1))+count2][];
		   int count=0;
		   for (int j=0;j<flights.length;j=j+1) {
		      for (int k = 0; k < flights.length; k = k + 1) {
		         if ((flights[j][k] == false) & (j != k)) {
		            for (int i = 0; i < map.length-1; i = i + 1) {
		            	int [] tmp = {-(map[i][j]),-(map[i + 1] [k])};
		            	cnf[count] = tmp;
		               count = count + 1;
		            }
		         }
		         if ((flights[0][k] == false)&(k!=0)&(j==0)) {
		        	 int [] tmp1 = {-map[flights.length - 1][k]};
		            cnf[count] = tmp1;
		            count = count + 1;
		         }
		      }
		   }

		   return cnf;
	}

	// Task 17
	public static void encode(boolean[][] flights, int[][] map) {
		boolean isMap = true;
		if(Assignment2.isLegalInstance(flights) == false)
			isMap = false;
		if(Assignment2.isSquare(map) == false)
			isMap = false;
		else
		{
		if(flights.length != map.length)
			isMap = false;
		}
		if(!isMap)
			throw new IllegalArgumentException("Illegal input");
		int nvars = map.length * map.length;
		SATSolver.init(nvars);
		SATSolver.addClauses(Assignment2.oneCityInEachStep(map));
		SATSolver.addClauses(Assignment2.eachCityIsVisitedOnce(map));
		SATSolver.addClauses(Assignment2.fixSourceCity(map));
		SATSolver.addClauses(Assignment2.noIllegalSteps(flights, map));
		
	}

	// Task 18
	public static int[] decode(boolean[] assignment, int[][] map) {
		if(assignment.length != ((map.length *map.length) +1))
			throw new RuntimeException("too short");
		int [] tour = new int [map.length];
		for (int i = 1; i<map.length; i = i+1)
		{
		for(int j = 0; j<map.length; j=j+1)
			if(assignment[map[i][j]] == true)
				tour[i] = j;
		}
		return tour;
		}

	// Task 19
	public static int[] solve(boolean[][] flights) {
		if(Assignment2.isLegalInstance(flights) == false)
			throw new IllegalArgumentException("Illegal Instance");
			int [][] map = (Assignment2.createVarsMap(flights.length));
		Assignment2.encode(flights, map);
		boolean [] Assignment = SATSolver.getSolution();
		if(Assignment == null)
			throw new RuntimeException("Timeout");
		int [] tour;
		if(Assignment.length == 0)
			tour = null;
		else
		{
			tour = Assignment2.decode(Assignment, map);
			boolean solution = Assignment2.isSolution(flights, tour);
			if(solution == false)
				throw new IllegalArgumentException("unsatisfied solution");
		}
		
		return tour;
	}

	// Task 20
	public static boolean solve2(boolean[][] flights) {
		boolean solve = true;
		int [] arr1 = Assignment2.solve(flights);
		if(arr1 == null)
			solve = false;
		else{
		int [] arr2 = new int [arr1.length];
		int k = arr1.length-1;
		for (int i = 1; i<arr1.length; i=i+1)
		{
			arr2[i] = arr1[k];
			k = k-1;
		}
		int[]cnf = new int[arr1.length];
		int [][] newmap = Assignment2.createVarsMap(flights.length);
		Assignment2.encode(flights, newmap);
		for (int j = 0; j<arr1.length; j=j+1)
		{
			cnf[j] = -newmap[j][arr1[j]];
		}
		SATSolver.addClause(cnf); //adding the blocking formula to the cnf
		for (int j = 0; j<arr2.length; j=j+1)
		{
			cnf[j] = -newmap[j][arr2[j]];
		}
		SATSolver.addClause(cnf); //adding the blocking formula to the cnf
		boolean [] assignment = SATSolver.getSolution();
		if (assignment == null)       
			throw new RuntimeException("TIMEOUT"); 
		if(assignment.length == 0)
			solve = false;
		else{
			int [] tour = Assignment2.decode(assignment, newmap);
			boolean solution = Assignment2.isSolution(flights, tour);
			if(!solution)
				throw new IllegalArgumentException("Illegal solution");
			solve = true;
		}
		}
		return solve;
	}

}
