/*
 * Maze.h
 *
 *  Created on: Mar 12, 2016
 *      Author: Neo
 */

#ifndef MAZE_H_
#define MAZE_H_

#include <vector>

using namespace std;

typedef struct Point {
		int x, y;
} Point;

class Maze {
public:
	int X, Y;
	int findPaths(int, int, int, int);
	int findPathsFast(int, int, int, int);
	void findPathDFS(int, int, int, int);
private:
	int findPaths(int, int, int, int, int**);
	int factorial(int);
	int findPathDFS(int, int, int, int, vector<Point>*);
	int isPathBlocked(int, int);
};

#endif /* MAZE_H_ */
