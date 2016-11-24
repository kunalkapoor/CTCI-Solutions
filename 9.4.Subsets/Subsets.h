/*
 * Subsets.h
 *
 *  Created on: Mar 12, 2016
 *      Author: Neo
 */

#ifndef SUBSETS_H_
#define SUBSETS_H_

#include <vector>
#include <string>

using namespace std;

class Subsets {
public:
	void findSubsetPermutations(vector<string>, vector<string>, vector<vector<string> >*);
	void findSubsets(vector<string>, vector<string>, vector<vector<string> >*);
	void findSubsetsCombinatorics(vector<string>, vector<vector<string> >*);
};

#endif /* SUBSETS_H_ */
