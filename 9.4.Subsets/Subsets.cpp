/*
 * Subsets.cpp
 *
 *  Created on: Mar 12, 2016
 *      Author: Neo
 */

#include <iostream>
#include "Subsets.h"

void Subsets::findSubsets(vector<string> curr, vector<string> remaining, vector<vector<string> > *subsets) {
	subsets->push_back(curr);

	while(!remaining.empty()) {
		vector<string> temp1 = curr;
		temp1.push_back(*remaining.begin());
		remaining.erase(remaining.begin());
		findSubsets(temp1, remaining, subsets);
	}
}

void Subsets::findSubsetsCombinatorics(vector<string> set, vector<vector<string> > *subsets) {
	int n = set.size();
	int num = 1 << n;
	for(int i=0; i<num; i++) {
		vector<string> subset;
		int index = 0;
		for(int j=i; j>0; j >>= 1) {
			if(j & 1)
				subset.push_back(set[index]);
			index ++;
		}
		subsets->push_back(subset);
	}
}

int main() {
	Subsets sub;
	string mystrings[] = { "a", "b", "c" };
	vector<string> curr(mystrings, mystrings + 3);
	vector<string> rem;

	vector<vector<string> > subsets;
	sub.findSubsets(rem, curr, &subsets);
	for (vector<vector<string> >::iterator i = subsets.begin(); i != subsets.end();
			i++) {
		cout << "{ ";
		for (vector<string>::iterator j = (*i).begin(); j != (*i).end(); j++) {
			cout << *j << " ";
		}
		cout << "}" << endl;
	}

	cout << endl;

	subsets.clear();
	sub.findSubsetsCombinatorics(curr, &subsets);
	for (vector<vector<string> >::iterator i = subsets.begin(); i != subsets.end();
			i++) {
		cout << "{ ";
		for (vector<string>::iterator j = (*i).begin(); j != (*i).end(); j++) {
			cout << *j << " ";
		}
		cout << "}" << endl;
	}

	return 0;
}
