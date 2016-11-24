#include <stdio.h>
#include <string.h>
#include <iostream>

using namespace std;

void reverse(char* str)
{
	if(str == NULL) return;

	char *end = str;

	while(*end++ != '\0');
	end -= 2;
	while(str < end)
	{
		char tmp = *str;
		*str++ = *end;
		*end-- = tmp;
	}
}

int main()
{
	char arr[] = {'a', 'b', 'c', 'd', 'e'};
	reverse(arr);
	printf("%s ", arr);
	return 0;
}
