#include <cstdio>
#include <memory>
//有错 暂未发现bug所在
void output(int r[], int n)
{
	for (int i = 1; i <= n; i++)
	{
		printf("%d ", r[i]);
	}
	printf("\n");
}

void QuickSort(int r[],int s,int t)
{
    int i,j;
    if(s<t)
    {
    //    printf("1s=%d t=%d\n", s, t);
        i = s;
        j=t;
        r[0]=r[i];
        do
        {
       // printf("1i=%d j=%d\n", i, j);
        while(i<j && r[j] > r[0])
            j--;
      //   printf("2i=%d j=%d\n", i, j);
        if(i<j)
            r[i] = r[j],i++;//把比r[0]小的放到左边来。本身不要变，因为可能下次可能会和下面的换
        while(i<j && r[i]<r[0])
            i++;
       //      printf("3i=%d j=%d\n", i, j);
        if(i<j)
            r[j] = r[i],j--;//把比r[0]大的放到右边，本身也不动。
     //       printf("4i=%d j=%d\n", i, j);
        }while(i!=j);
    r[i]=r[0];//放里面 否则可能会未初始化i
   // printf("5i=%d j=%d\n", i, j);
  //  printf("2s=%d t=%d\n", s, t);
    QuickSort(r,s,i-1);//不用管r[i]的情况了
  //  printf("3s=%d t=%d\n", s, t);
    QuickSort(r,i+1,t);
    }

}

void quick_sort(int s[],int l,int r)
{
    if(l < r)
    {
        int i=l,j=r,x=s[l];
        while(i<j)
        {
            while(i<j && s[j]>=x)//从右到左找到第一个小于x的数
                j--;
            if(i<j)
                s[i++]=s[j];

            while(i<j && s[i]<=x)//从左往右找到第一个大于x的数
                i++;
            if(i<j)
                s[j--]=s[i];

        }

        s[i]=x;//i = j的时候，将x填入中间位置
        quick_sort(s,l,i-1);//递归调用
        quick_sort(s,i+1,r);
    }
}
int main()
{
	int a[1007] = {0,10,2,1,5,67,3,45,1};

	int n = 8;
    output(a, n);
	QuickSort(a, 1, n );
	//quick_sort(a, 1, n);
	//MergeSort(r,n);
	output(a, n);
	//output(r1, n);
	return 0;
}
