// mergelist.cpp : Defines the entry point for the console application.
//

#include <stdio.h>
#include <stdlib.h>

#ifdef _WIN32
#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable: 4996)
#endif

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
List Read(FILE * fp)
{
	int nCount = 0;
	fscanf(fp, "%d\n", &nCount);
	if (0 == nCount)
		return NULL;

	List list = (List)malloc(sizeof(struct Node));
	list->Data = -1;
	list->Next = NULL;
	List listHeader = list;

	int nElement = 0;
	for (int i = 0; i < nCount; i++)
	{
		List temp = (List)malloc(sizeof(struct Node));
		fscanf(fp, "%d ", &nElement);
		temp->Data = nElement;
		temp->Next = NULL;

		list->Next = temp;
		list = temp;
	}

	return listHeader;
}

void Print(List L)
{
	if (L == NULL || L->Next == NULL)
	{
		printf("NULL");
	}
	L = L->Next;
	while (L)
	{
		printf("%d ", L->Data);
		L = L->Next;
	}
	printf("\n");
}

void FreeList(List L)
{
	while (L)
	{
		List lTemp = L;
		L = L->Next;
		free(lTemp);
	}
}

List Merge(List L1, List L2)
{
	if (L1 == NULL && L1->Next == NULL && L2 == NULL && L2->Next == NULL)
		return NULL;

	List listHeader = (List)malloc(sizeof(struct Node));
	listHeader->Data = -1;
	listHeader->Next = NULL;
	List listTail = listHeader;

	List L1Header = L1;
	List L2Header = L2;
	L1 = L1->Next;
	L2 = L2->Next;
	L1Header->Next = NULL;
	L2Header->Next = NULL;

	while (L1 || L2)
	{
		if (L1 && L2)
		{
			if (L1->Data > L2->Data)
			{
				listTail->Next = L2;
				L2 = L2->Next;
				listTail = listTail->Next;
				listTail->Next = NULL;
			}
			else
			{
				listTail->Next = L1;
				L1 = L1->Next;
				listTail = listTail->Next;
				listTail->Next = NULL;
			}
		}
		else if (L1)
		{
			listTail->Next = L1;
			break;
		}
		else if (L2)
		{
			listTail->Next = L2;
			break;
		}
	}
	return listHeader;
}

int main()
{
	List L1, L2, L;

	FILE * fp = fopen("input.txt", "rt");
	if (NULL == fp)
		return 0;


	L1 = Read(fp);
	L2 = Read(fp);

	fclose(fp);

	Print(L1);
	Print(L2);
	L = Merge(L1, L2);
	Print(L);
	Print(L1);
	Print(L2);

	FreeList(L1);
	FreeList(L2);
	FreeList(L);
	return 0;
}