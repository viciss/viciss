// bintree.cpp : Defines the entry point for the console application.
//

#include <stdio.h>
#include <stdlib.h>

#ifdef _WIN32
#define _CRT_SECURE_NO_WARNINGS
#pragma warning(disable: 4996)
#endif

typedef int ElementType;
typedef struct TNode *Position;
typedef Position BinTree;
struct TNode {
	ElementType Data;
	BinTree Left;
	BinTree Right;
};

void PreorderTraversal(BinTree BT); /* 先序遍历，由裁判实现，细节不表 */
void InorderTraversal(BinTree BT);  /* 中序遍历，由裁判实现，细节不表 */

BinTree Insert(BinTree BST, ElementType X);
BinTree Delete(BinTree BST, ElementType X);
Position Find(BinTree BST, ElementType X);
Position FindMin(BinTree BST);
Position FindMax(BinTree BST);
void FreeBinTree(BinTree * BST);

int main()
{
	BinTree BST, MinP, MaxP, Tmp;
	ElementType X;
	int N, i;

	BST = NULL;
	scanf("%d", &N);
	for (i = 0; i<N; i++) {
		scanf("%d", &X);
		BST = Insert(BST, X);
	}
	printf("Preorder:"); PreorderTraversal(BST); printf("\n");
	MinP = FindMin(BST);
	MaxP = FindMax(BST);
	scanf("%d", &N);
	for (i = 0; i<N; i++) {
		scanf("%d", &X);
		Tmp = Find(BST, X);
		if (Tmp == NULL) printf("%d is not found\n", X);
		else {
			printf("%d is found\n", Tmp->Data);
			if (Tmp == MinP) printf("%d is the smallest key\n", Tmp->Data);
			if (Tmp == MaxP) printf("%d is the largest key\n", Tmp->Data);
		}
	}
	scanf("%d", &N);
	for (i = 0; i<N; i++) {
		scanf("%d", &X);
		BST = Delete(BST, X);
	}
	printf("Inorder:"); InorderTraversal(BST); printf("\n");

    FreeBinTree(&BST);
    printf("Inorder after Free:");
    InorderTraversal(BST);
	return 0;
}

void FreeBinTree(BinTree * BST)
{
    if (BST && *BST)
    {
        FreeBinTree(&((*BST)->Left));
        FreeBinTree(&((*BST)->Right));
        free(*BST);
        (*BST) = NULL;
    }
}

void PreorderTraversal(BinTree BT)
{
	if (BT)
	{
		printf("%d ", BT->Data);
		PreorderTraversal(BT->Left);
		PreorderTraversal(BT->Right);
	}
}

void InorderTraversal(BinTree BT)
{
	if (BT)
	{
		InorderTraversal(BT->Left);
		printf("%d ", BT->Data);
		InorderTraversal(BT->Right);
	}
}

BinTree Insert(BinTree BST, ElementType X)
{
	if (BST == NULL)
	{
		BST = (BinTree)malloc(sizeof(struct TNode));
		BST->Data = X;
		BST->Left = NULL;
		BST->Right = NULL;

		return BST;
	}

	if (X < BST->Data)
	{
		BinTree temp = Insert(BST->Left, X);
		BST->Left = temp;
	}
	else
	{
		BinTree temp = Insert(BST->Right, X);
		BST->Right = temp;
	}
	return BST;
}

int DeleteWithPoint(BinTree * pBST, ElementType X)
{
	if (pBST == NULL || *pBST == NULL)
    {
		return -1;
    }

	if (X < (*pBST)->Data)
	{
		return DeleteWithPoint(&(*pBST)->Left, X);
	}
	else if (X > (*pBST)->Data)
	{
		return DeleteWithPoint(&(*pBST)->Right, X);
	}
	else
	{
		if ((*pBST)->Left == NULL)
		{
			BinTree temp = *pBST;
			(*pBST) = (*pBST)->Right;
			free(temp);
		}
		else if ((*pBST)->Right == NULL)
		{
			BinTree temp = *pBST;
			(*pBST) = (*pBST)->Left;
			free(temp);
		}
		else
		{
			BinTree replaceNode = (*pBST)->Left;
			BinTree replaceParentNode = (*pBST)->Left;

			while (replaceNode->Right)
			{
				replaceParentNode = replaceNode;
				replaceNode = replaceNode->Right;
			}
			(*pBST)->Data = replaceNode->Data;

			if (replaceNode == replaceParentNode)
			{
				(*pBST)->Left = replaceNode->Left;
				free(replaceNode);
			}
			else
			{
				replaceParentNode->Right = replaceNode->Left;
				free(replaceNode);
			}
		}
		return 0;
	}
}

BinTree Delete(BinTree BST, ElementType X)
{

	if ( DeleteWithPoint(&BST, X) == -1 )
    {
        printf("Not Found\n");
    }
	return BST;
}

Position Find(BinTree BST, ElementType X)
{
	if (BST == NULL)
		return NULL;

	if (X == BST->Data)
		return BST;
	else if (X < BST->Data)
		return Find(BST->Left, X);
	else
		return Find(BST->Right, X);
}

Position FindMin(BinTree BST)
{
	if (BST == NULL)
		return NULL;

	if (BST->Left == NULL)
		return BST;
	else
		return FindMin(BST->Left);
}

Position FindMax(BinTree BST)
{
	if (BST == NULL)
		return NULL;

	if (BST->Right == NULL)
		return BST;
	else
		return FindMax(BST->Right);
}
