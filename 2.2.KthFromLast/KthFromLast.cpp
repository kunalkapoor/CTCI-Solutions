#include <stdio.h>
#include <iostream>

using namespace std;

struct Node
{
	int data;
	Node *next;
};

int kthToLast(Node* head, int k)
{
	if( k<=0 )
		return -1;
	Node *follow, *first;
	first = head;

	for(int i=0; i<k; i++)
	{
		if(first == NULL)
			return -1;
		first = first -> next;
	}

	follow = head;
	while(first != NULL)
	{
		first = first -> next;
		follow = follow -> next;
	}

	return follow -> data;
}

int kthToLastRecursive(Node *head, int k, int i)
{
	if (head == NULL)
	{
		if(i<k-1)
			return -1;
		return 1;
	}

	int n = kthToLastRecursive(head->next, k, i+1);

	if(i==0)
		return n-k;
	if(n<k || n<0)
		return n+1;
	if(n == k)
		return head->data + k;
	return n;
}

int kthToLastRecursive(Node *head, int k)
{
	if(k<=0)
		return -1;
	return kthToLastRecursive(head, k, 0);
}

int main()
{
	Node *head, *a, *b, *c, *d, *e;
	head = new Node;
	a = new Node;
	b = new Node;
	c = new Node;
	d = new Node;
	e = new Node;
	head->data = 1;
	a -> data = 2;
	b -> data = 3;
	c -> data = 4;
	d -> data = 5;
	e -> data = 6;
	head -> next = a;
	a -> next = b;
	b -> next = c;
	c -> next = d;
	d -> next = e;
	e -> next = NULL;

//	cout << kthToLast(head, 3);
	cout << kthToLastRecursive(head, 4);
}
