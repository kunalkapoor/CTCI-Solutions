#include <stdio.h>
#include <iostream>

using namespace std;

struct Node {
	int data;
	Node *next;
};

int getLoopSize(Node *head) {
	Node *singleRun, *doubleRun;
	int i, first, second;

	if (head == NULL || head->next == NULL)
		return NULL;

	first = second = -1;
	singleRun = head;
	doubleRun = head->next;

	for (i = 1; second == -1; i++) {
		if (singleRun == doubleRun) {
			if (first == -1)
				first = i;
			else
				second = i;
		}
		if (doubleRun == NULL || doubleRun->next == NULL)
			break;
		singleRun = singleRun->next;
		doubleRun = doubleRun->next->next;
	}

	if (second == -1)
		return NULL;
	return second - first;
}

Node* findLoop(Node *head) {
	int loopSize;
	if ((loopSize = getLoopSize(head)) == NULL)
		return NULL;

	int i;
	Node *first, *follow;

	first = follow = head;

	for (i = 1; i <= loopSize; i++)
		follow = follow->next;

	while (first != follow) {
		first = first->next;
		follow = follow->next;
	}

	return first;
}

int main() {
	Node *a1, *b1, *c1, *d1, *e1;
	Node *a2, *b2, *c2, *d2, *e2;
	Node *a3, *b3, *c3, *d3;
	a1 = new Node;
	b1 = new Node;
	c1 = new Node;
	d1 = new Node;
	e1 = new Node;
	a1->data = 1;
	b1->data = 2;
	c1->data = 3;
	d1->data = 4;
	e1->data = 5;
	a1->next = b1;
	b1->next = c1;
	c1->next = d1;
	d1->next = e1;
	e1->next = c1;

	a2 = new Node;
	b2 = new Node;
	c2 = new Node;
	d2 = new Node;
	e2 = new Node;
	a2->data = 1;
	b2->data = 2;
	c2->data = 3;
	d2->data = 4;
	e2->data = 5;
	a2->next = b2;
	b2->next = c2;
	c2->next = a2;
	d2->next = e2;
	e2->next = NULL;

	a3 = new Node;
	b3 = new Node;
	c3 = new Node;
	d3 = new Node;
	a3->data = 1;
	b3->data = 2;
	c3->data = 3;
	d3->data = 4;
	a3->next = b3;
	b3->next = c3;
	c3->next = d3;
	d3->next = NULL;

	cout << findLoop(a1)->data << endl;
	cout << findLoop(a2)->data << endl;
	cout << findLoop(a3);
}
