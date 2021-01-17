
public class Assignment2A {
	
	public static boolean isSquareMatrix(boolean[][] matrix){
		boolean ans= true;
		if (matrix == null)
			ans= false;
		for (int i=0; i<matrix.length; i = i+1)
		{
			if (matrix[i] == null)
				ans= false;
			if (matrix.length != matrix[i].length)
				ans= false;
		}
		return ans;
	}
	
	public static boolean isSymmetricMatrix(boolean[][] matrix){
	boolean ans= true;
	for(int i = 0; i < matrix.length; i = i+1)
	{
		for(int j = 0; j<matrix[i].length; j = j+1)
		{
			if(matrix[i][j] != matrix[j][i])
			ans= false;
		}
	}
		return ans;
	}
	
	public static boolean isAntiReflexiveMatrix(boolean[][] matrix){
	boolean anti = true;
	for (int i = 0; i < matrix.length; i = i+1)
	{
		if(matrix[i][i] != false)
		anti = false;
	}
		return anti;
	}
	
	public static boolean isLegalInstance(boolean[][] matrix){

	boolean anti= (Assignment2A.isAntiReflexiveMatrix(matrix));
	boolean symet=(Assignment2A.isSymmetricMatrix(matrix));
	boolean square=(Assignment2A.isSquareMatrix(matrix));
	boolean islegal = false;
	if((anti == true) & (symet == true) & (square == true))
		islegal = true; //if the conditions are true the trip is legal
	return islegal;
	}
	
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
	
	public static boolean hasLegalSteps(boolean[][] flights, int[] tour){
	boolean LegalSteps = true;
	for(int i = 0; i<tour.length -1; i = i+1)
	{
		if(!flights[tour[i]][tour[i+1]])
		LegalSteps = false;
	}
		if(!flights[tour[tour.length-1]][tour[0]])
		LegalSteps = false;
		return LegalSteps;
	}
	
	public static boolean isSolution(boolean[][] flights, int[] tour){
	if (tour == null)
		throw new RuntimeException();
	if((tour.length) != (flights.length))
		throw new IllegalArgumentException("Illegal Variables");
	boolean solution = true;
	boolean Permition = (Assignment2A.isPermutation(tour));
	boolean Legal = (Assignment2A.hasLegalSteps(flights,tour));
		if (tour[0] != 0)
		solution = false; //checking if the first city is 0
	if ((!Legal) | (!Permition))
		solution = false;
		return solution;
	}

}
