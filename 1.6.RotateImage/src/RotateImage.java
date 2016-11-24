
public class RotateImage {
	public void rotate(int[][] matrix, int N)
	{
		int i, j, temp;
		
		for(i=0; i<N-1; i++)
		{
			for(j=i+1; j<N; j++)
			{
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		for(i=0; i<N; i++)
		{
			for(j=0; j<N/2; j++)
			{
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][N-j-1];
				matrix[i][N-j-1] = temp;
			}
		}
	}
	
	public void rotateUsingSingleLoop(int[][] matrix, int N)
	{
		int layer, j, temp;
		
		for(layer = 0; layer < N/2; layer++)
		{
			for(j=layer; j<N-layer-1; j++)
			{
				// Top
				temp = matrix[layer][j];
				
				// Top = Left
				matrix[layer][j] = matrix[N-1-layer-j][layer];
				
				// Left = Bottom
				matrix[N-1-layer-j][layer] = matrix[N-1-layer][N-1-layer-j];
				
				// Bottom = Right
				matrix[N-1-layer][N-1-layer-j] = matrix[layer+j][N-1-layer];
				
				// Right = Top
				matrix[layer+j][N-1-layer] = temp;
			}
		}
	}
	
	public static void main(String args[])
	{
		int[][] matrix1 = {{1,2,3}, {4,5,6}, {7,8,9}};
		int[][] matrix2 = {{1,2,3}, {4,5,6}, {7,8,9}};
		int N = 3;
		
//		new RotateImage().rotate(matrix1, N);
		new RotateImage().rotateUsingSingleLoop(matrix1, N);
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				System.out.print(matrix1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
//		new RotateImage().rotate(matrix1, N);
		new RotateImage().rotateUsingSingleLoop(matrix1, N);
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				System.out.print(matrix1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
//		new RotateImage().rotate(matrix1, N);
		new RotateImage().rotateUsingSingleLoop(matrix1, N);
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				System.out.print(matrix1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
//		new RotateImage().rotate(matrix1, N);
		new RotateImage().rotateUsingSingleLoop(matrix1, N);
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				System.out.print(matrix1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
