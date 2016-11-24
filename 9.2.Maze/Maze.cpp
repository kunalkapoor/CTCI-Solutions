/*
 * Maze.cpp
 *
 *  Created on: Mar 12, 2016
 *      Author: Neo
 */

#include <stdio.h>
#include <iostream>
#include "Maze.h"

using namespace std;

int Maze::findPaths(int startX, int startY, int destX, int destY) {
	if (startX == destX || startY == destY)
		return 1;

	int i, j;
	int** numPaths = new int*[X];
	for (i = 0; i < X; i++)
		numPaths[i] = new int[Y];

	for (i = 0; i < X; i++)
		for (j = 0; j < Y; j++)
			numPaths[i][j] = -1;

	return findPaths(startX, startY, destX, destY, numPaths);
}

int Maze::findPaths(int startX, int startY, int destX, int destY,
		int** numPaths) {
	if (startX >= X || startX > destX)
		return 0;
	if (startY >= Y || startY > destY)
		return 0;
	if (startX == destX && startY == destY)
		return 1;
	if (numPaths[startX][startY] != -1)
		return numPaths[startX][startY];

	numPaths[startX][startY] = findPaths(startX + 1, startY, destX, destY)
			+ findPaths(startX, startY + 1, destX, destY);
	return numPaths[startX][startY];
}

int Maze::findPathsFast(int startX, int startY, int destX, int destY) {
	int diffX, diffY, total;
	diffX = factorial(destX - startX);
	diffY = factorial(destY - startY);
	total = factorial((destX - startX) + (destY - startY));
	return total / (diffX * diffY);
}

int Maze::factorial(int value) {
	int fact = 1;
	int i;
	for (i = 2; i <= value; i++)
		fact *= i;
	return fact;
}

void Maze::findPathDFS(int startX, int startY, int destX, int destY) {
	vector<Point> path;
	int ret = findPathDFS(startX, startY, destX, destY, &path);
	if(ret == 0) {
		cout << "No path found" << endl;
		return;
	}

	vector<Point>::const_iterator i;
	for(i = path.begin(); i != path.end(); i++)
		printf("(%d,%d) -> ", i->x, i->y);
	cout<<endl;
}

int Maze::findPathDFS(int startX, int startY, int destX, int destY, vector<Point> *path) {
	if(destX < 0 || destY < 0)
		return 0;
	if(isPathBlocked(startX, startY))
		return 0;

	if((destX == startX && destY == startY) || findPathDFS(startX, startY, destX-1, destY, path) || findPathDFS(startX, startY, destX, destY-1, path)) {
		Point point;
		point.x = destX;
		point.y = destY;
		path->push_back(point);
		return 1;
	}
	return 0;
}

int Maze::isPathBlocked(int x, int y) {
	if(x == 1 && y == 1)
		return 1;
	if(x == 2 && y == 2)
		return 1;
	if(x == 2 && y == 1)
		return 1;
	return 0;
}

int main() {
	Maze maze;
	maze.X = 4;
	maze.Y = 4;
	cout << maze.findPaths(0, 0, maze.X - 1, maze.Y - 1) << endl;
	cout << maze.findPaths(0, 0, maze.X - 2, maze.Y - 2) << endl;
	cout << maze.findPaths(0, 0, 0, maze.Y - 1) << endl;

	cout << maze.findPathsFast(0, 0, maze.X - 1, maze.Y - 1) << endl;
	cout << maze.findPathsFast(0, 0, maze.X - 2, maze.Y - 2) << endl;
	cout << maze.findPathsFast(0, 0, 0, maze.Y - 1) << endl;

	maze.findPathDFS(0, 0, maze.X-1, maze.Y-1);
	return 0;
}
