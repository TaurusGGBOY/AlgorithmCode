#include <cstdio>
#include <memory>
//�д� ��δ����bug����
void output(int r[], int n)
{
	for (int i = 0; i < n; i++)
	{
		printf("%d ", r[i]);
	}
	printf("\n");
}

int BinSearch(int n, int r[], int num)
{
    int mid;
    int low = 0;
    int high = n-1;
    while(low != high)
    {
        mid = (low + high)/2;
        if(r[mid] == num)
            return 1;
        if(r[mid] < num)
            low = mid +1;
        else
            high = mid - 1;
    }
    return -1;
}
int main()
{
	int a[1007] = {0,10,2,1,5,67,3,45,1};
	int n = 8;
	int num = 1;
    //output(a, n);
	printf("%d", BinSearch(n, a, num));
	//quick_sort(a, 1, n);
	//MergeSort(r,n);
	//output(a, n);
	//output(r1, n);
	return 0;
}
