#include <stdio.h>

void Merge1(int a[], int t[], int l, int m, int h)
{
    int low = l;
    int i = l;
    int j=m;
    int k=m+1;
    int n=h;
    if(i < k)
    {
        while(i <= j && k <= n)
            {
                if(a[i] < a[k])
                    t[l++]=a[i++];
                else
                    t[l++]=a[k++];
            }
            while(i<=j)
            {
                t[l++]=a[i++];
            }
            while(k<=n)
                t[l++]=a[k++];

           for(int z = low; z<=n; z++)
                a[z] = t[z];


    }
}

void MergeSort(int a[], int t[], int l, int h)
{
    int m;
    if(l == h)
        t[l] = a[l];
    else
    {
        m = (l+h)/2;
        MergeSort(a, t, l, m);
        MergeSort(a, t, m+1, h);
        Merge1(a, t, l, m, h);
    }
}

int main()
{
    int temp[1009];
    int r[1009] = {10,1,3,5,7,3,45};
    int n = 7;

    MergeSort(r, temp, 0, n-1);

    for(int i=0; i<n; i++)
        printf("%d ", r[i]);
    printf("\n");
  for(int i=0; i<n; i++)
        printf("%d ", temp[i]);
    printf("\n");
    return 0;

}
