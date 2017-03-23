// mergelist.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <stdio.h>
#include <stdlib.h>

#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable: 4996)

typedef int ElementType;
typedef struct Node *PtrToNode;
struct Node {
	ElementType Data;
	PtrToNode   Next;
};
typedef PtrToNode List;

/*
3
1 3 5
5
2 4 6 8 10*/
List Read()
{
	FILE * fp = fopen("input.txt", "rt");
	if (NULL == fp)
		return NULL;

	int nCount = 0;
	fscanf(fp, "%d\n", &nCount);
	if (0 == nCount)
	{
		fclose(fp);
		return NULL;
	}

	List list = (List)malloc(sizeof(struct Node));
	int nElement = 0;
	fscanf(fp, "%d ", &nElement);
	list->Data = nElement;
	list->Data = NULL;
	List listHeader = list;

	for (int i = 0; i < nCount - 1; i++)
	{
		List temp = (List)malloc(sizeof(struct Node));
		fscanf(fp, "%d ", &nElement);
		temp->Data = nElement;
		temp->Next = NULL;

		list->Next = temp;
		list = temp;
	}

	fclose(fp);
	
	return listHeader;
}

void Print(List L)
{
	while (L)
	{
		printf("%d ", L->Data);
		L = L->Next;
	}
	printf("\n");
}

List Merge(List L1, List L2)
{
	return NULL;
}

int main()
{
	List L1, L2, L;
	L1 = Read();
	L2 = Read();
	L = Merge(L1, L2);
	Print(L);
	Print(L1);
	Print(L2);
	return 0;
}