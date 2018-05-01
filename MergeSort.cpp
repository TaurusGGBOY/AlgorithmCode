#include <cstdio>
#include <memory>
//有错 暂未发现bug所在
void output(int r[], int n)
{
	for (int i = 0; i < n; i++)
	{
		printf("%d ", r[i]);
	}
	printf("\n");
}

void Merge1(int r1[], int r[], int s, int m, int t)
{
	int i = s;
	int j = m + 1;
	int k = s;//传入的参数还是尽量不要动
	while (i <= m && j <= t) //如果不等于 那么肯定不会赋值到r1[m]和r1[t]
	{
		if (r[i] <= r[j])
		{
			r1[k++] = r[i++]; // while不会自己增加
		}
		else
			r1[k++] = r[j++];
        printf("r1第%d个：%d\n", k, r1[k-1]);
	}
	if(i<=m)
	{
	    while(i<=m)
            {
                r1[k++] = r[i++];
                printf("r1第%d个：%d\n", k, r1[k-1]);
    }       }
    else
        while(j<=t)
            {
                r1[k++] = r[j++];
                printf("r1第%d个：%d\n", k, r1[k-1]);}
}

void MergeSort(int r1[], int r[], int s, int t)
{
	int m;

	if (s == t)
		{
		    r1[s] = r[s]; //在两个相等的时候就不会进入MergeSort就不会赋值
		     printf("s=%d\n", s);
		     printf("r1第%d个：%d\n", s+1, r1[s]);
 		}*/

	{
	    m = (t + s) / 2;
		MergeSort(r1, r, s, m);
		MergeSort(r1, r, m + 1, t);printf("r1第%d个：%d\n", s+1, r
		Merge1(r1, r, s, m, t);
	}

}
/*
//将有二个有序数列a[first...mid]和a[mid...last]合并。
void mergearray(int a[], int first, int mid, int last, int temp[])
{
    int i = first, j = mid + 1;
    int m = mid,   n = last;
    int k = 0;

    while (i <= m && j <= n)
    {
        if (a[i] <= a[j])
            temp[k++] = a[i++];
        else
            temp[k++] = a[j++];
    }

    while (i <= m)
        temp[k++] = a[i++];

    while (j <= n)
        temp[k++] = a[j++];

    for (i = 0; i < k; i++)
        a[first + i] = temp[i];
}
void mergesort(int a[], int first, int last, int temp[])
{
    if (first < last)
    {
        int mid = (first + last) / 2;
        mergesort(a, first, mid, temp);    //左边有序
        mergesort(a, mid + 1, last, temp); //右边有序
        mergearray(a, first, mid, last, temp); //再将二个有序数列合并
    }
}

bool MergeSort(int a[], int n)
{
    int *p = new int[n];
    if (p == NULL)
        return false;
    mergesort(a, 0, n - 1, p);
    delete[] p;
    return true;
}
*/
int main()
{
	int r[1007] = { 10,2,1,5,67,3,45,1 };
	int r1[1007] = {0};
	int n = 8;
    output(r, n);
	MergeSort(r1, r, 0, n - 1);
	//MergeSort(r,n);
	output(r, n);
	output(r1, n);
	return 1;
}
