#include <stdio.h>
#include <string.h>
#include <iostream>

using namespace std;

bool checkPermutation(char* inp, char* perm)
{
	if(inp == NULL || perm == NULL || strlen(inp) != strlen(perm))
		return false;

	int i;
	int count[128] = {0};

	while(*inp)
	{
		count[*inp++]++;
		count[*perm++]--;
	}

	for(i=0; i<128; i++)
		if(count[i] < 0)
			return false;

	return true;
}

int main()
{
	char c1[] = {'a', 'b', 'c', 'a', 'a', 'a', 'a'};
	char c2[] = {'b', 'a', 'a', 'a', 'a', 'c', 'a'};

	cout << checkPermutation(c1, c2) << endl;
}
