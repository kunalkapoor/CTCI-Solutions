#include <stdio.h>
#include <iostream>

using namespace std;

void matrixSetZeros(int *matrix[], int M, int N)
{
	int i,j;
	bool *rows = new bool[M];
	bool *cols = new bool[N];

	for(i=0; i<M; i++)
	{
		rows[i] = false;
		if(i<N)
			cols[i] = false;
	}

	for(i=M; i<N; i++)
		cols[i] = false;

	for(i=0; i<M; i++)
	{
		for(j=0; j<N; j++)
		{
			if(matrix[i][j] == 0)
			{
				rows[i] = true;
				cols[j] = true;
			}
		}
	}

//	for(i=0; i<M; i++)
//		cout << rows[i] << " ";
//	cout << endl;
//	for(i=0; i<N; i++)
//		cout << cols[i] << " ";
//	cout << endl;

	for(i=0; i<M; i++)
		for(j=0; j<N; j++)
			if(rows[i] || cols[j])
				matrix[i][j] = 0;

	delete(rows);
	delete(cols);
}

void matrixSetZerosBitwise(int *matrix[], int M, int N)
{
	int i,j;
	int rowBits = 0, colBits = 0;

	for(i=0; i<M; i++)
	{
		for(j=0; j<N; j++)
		{
			if(matrix[i][j] == 0)
			{
				rowBits |= 1<<i;
				colBits |= 1<<j;
			}
		}
	}

	for(i=0; i<M; i++)
		for(j=0; j<N; j++)
			if(((rowBits & (1<<i)) > 0) || ((colBits & (1<<j)) > 0))
				matrix[i][j] = 0;
}

int main()
{
	int matrix[4][3] = {{1, 2, 0}, {0, 3, 4}, {5, 6, 7}, {0, 8, 9}};
	int M = 4;
	int N = 3;
	int i, j;

	int **m = new int*[M];
	for(i=0; i<M; i++)
	{
		m[i] = new int[N];
		m[i] = matrix[i];
	}

//	for(i=0; i<M; i++)
//	{
//		for(j=0; j<N; j++)
//			cout << m[i][j] << " ";
//		cout << endl;
//	}

//	matrixSetZeros(m, M, N);
	matrixSetZerosBitwise(m, M, N);

	for(i=0; i<M; i++)
	{
		for(j=0; j<N; j++)
			cout << m[i][j] << " ";
		cout << endl;
	}

	delete(m);
}
