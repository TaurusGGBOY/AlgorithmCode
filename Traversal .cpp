#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
    struct Node* lt;
    struct Node* rt;
    int index;
}*Tree, TreeNode;

void BuildTree(Tree &T) //C语言编译器不存在指针的引用。由于一开始T是没有赋值的 所以后面malloc之后改变了T的地址这个如果不引用传不回来
{
    T = (Tree)malloc(sizeof(TreeNode));
    int num;
    scanf("%d", &num);
    T->index = num;

    if(num == 0)
        return ;

    BuildTree(T->lt);
    BuildTree(T->rt);
}

void Traversal(Tree T)
{
  if(T->index != 0)
    printf("%d ", T->index);
  else
    return ;
  Traversal(T->lt);
  Traversal(T->rt);
}
int main()
{
    Tree T1;

    BuildTree(T1);

    Traversal(T1);

    return 0;
}
