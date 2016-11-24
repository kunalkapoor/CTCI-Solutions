/*
 * Permutations.cpp
 *
 *  Created on: Mar 12, 2016
 *      Author: Neo
 */

#include <iostream>
#include "Permutations.h"

using namespace std;

vector<string> Permutations::permute(string str) {
	vector<string> perm;
	if(str.empty())
		return perm;
	if(str.size() == 1) {
		perm.push_back(str);
		return perm;
	}

	int n = str.size();
	string lastchar (1, str[n-1]);
	string sub = str.substr(0, n-1);
	vector<string> temp = permute(sub);
	for(unsigned int i=0; i<temp.size(); i++) {
		for(unsigned int j=0; j<=temp[i].size(); j++) {
			string s = temp[i];
			s.insert(j, lastchar);
			perm.push_back(s);
		}
	}
	return perm;
}

int main() {
	Permutations p;
	string str = "abc";
	vector<string> perm = p.permute(str);

	cout << perm.size() << endl;
	for(unsigned int i=0; i<perm.size(); i++)
		cout << perm[i] << endl;

	str = "abcd";
	perm = p.permute(str);

	cout << endl << perm.size() << endl;
	for(unsigned int i=0; i<perm.size(); i++)
		cout << perm[i] << endl;

	return 0;
}
