#include <stdio.h>
#include <string.h>
#include <iostream>

using namespace std;

char* convertSpaces(char *str, int trueLen)
{
	if(str == NULL || trueLen == 0) return str;

	int len = strlen(str);
	if(trueLen > len) return NULL;
	if(trueLen == len) return str;

	str = str + (trueLen - 1);
	char *end = str + (len - trueLen);
	int i;

	for(i = trueLen - 1; i>=0; i--)
	{
		if(*str != ' ')
			*end = *str;
		else
		{
			*end-- = '0';
			*end-- = '2';
			*end = '%';
		}
		if(str == end) break;
		str--;
		end--;
	}
	str = str - i;
	return str;
}

int main()
{
	char str[] = {'M', 'r', ' ', 'J', ' ', 'D', ' ', 'S', 'm', 'i', 't', 'h', '0', '0', '0', '0', '0', '0'};
	char *out = convertSpaces(str, 12);
	cout << out << endl;
}
