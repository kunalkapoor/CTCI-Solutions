/*
 * MagicNumber.cpp
 *
 *  Created on: Mar 12, 2016
 *      Author: Neo
 */

#include <iostream>
#include "MagicNumber.h"

using namespace std;

int MagicNumber::findMagicNumber(int *a, int min, int max) {
	if(min > max)
			return -1;

		int mid = (min + max) / 2;
		if(a[mid] == mid)
			return mid;
		if(a[mid] > mid)
			return findMagicNumber(a, min, mid-1);
		return findMagicNumber(a, mid+1, max);
}

int MagicNumber::findMagicNumberRepetition(int *a, int min, int max) {
	if(min > max)
			return -1;

		int mid = (min + max) / 2;
		if(a[mid] == mid)
			return mid;
		if(a[mid] > mid) {
			int less = findMagicNumberRepetition(a, min, mid-1);
			if(less != -1)
				return less;
			return findMagicNumberRepetition(a, a[mid], max);
		}
		int great = findMagicNumberRepetition(a, mid+1, max);
		if(great != -1)
			return great;
		return findMagicNumberRepetition(a, min, a[mid]);
}

int main() {
	MagicNumber mn;
	int a[] =  {-1, 0, 1, 4, 4, 5};
	int b[] = {-1, 2, 3, 4, 5, 7, 7, 8, 9, 9};
	int c[] = {-1, 2, 2, 4, 5, 7, 7, 8, 9, 10};
	cout << mn.findMagicNumber(a, 0, 5) << endl;
	cout << mn.findMagicNumber(b, 0, 9) << endl;
	cout << mn.findMagicNumber(c, 0, 9) << endl;
	cout << mn.findMagicNumberRepetition(a, 0, 5) << endl;
	cout << mn.findMagicNumberRepetition(b, 0, 9) << endl;
	cout << mn.findMagicNumberRepetition(c, 0, 9) << endl;
	return 0;
}
