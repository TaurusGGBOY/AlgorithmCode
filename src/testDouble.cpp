#include <cstdio>
#include <memory>
//�д� ��δ����bug����
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
            r[i] = r[j],i++;//�ѱ�r[0]С�ķŵ��������������Ҫ�䣬��Ϊ�����´ο��ܻ������Ļ�
        while(i<j && r[i]<r[0])
            i++;
       //      printf("3i=%d j=%d\n", i, j);
        if(i<j)
            r[j] = r[i],j--;//�ѱ�r[0]��ķŵ��ұߣ�����Ҳ������
     //       printf("4i=%d j=%d\n", i, j);
        }while(i!=j);
    r[i]=r[0];//������ ������ܻ�δ��ʼ��i
   // printf("5i=%d j=%d\n", i, j);
  //  printf("2s=%d t=%d\n", s, t);
    QuickSort(r,s,i-1);//���ù�r[i]�������
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
            while(i<j && s[j]>=x)//���ҵ����ҵ���һ��С��x����
                j--;
            if(i<j)
                s[i++]=s[j];

            while(i<j && s[i]<=x)//���������ҵ���һ������x����
                i++;
            if(i<j)
                s[j--]=s[i];

        }

        s[i]=x;//i = j��ʱ�򣬽�x�����м�λ��
        quick_sort(s,l,i-1);//�ݹ����
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
