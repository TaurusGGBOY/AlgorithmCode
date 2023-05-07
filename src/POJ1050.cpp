#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

#define MAXNUM 1000000007
#define MAXN 107
int a[MAXN][MAXN];
int maxSum[MAXN][MAXN][MAXN];

int main()
{
    int n;
    int i, j, k;
    int sum = -MAXNUM;
    int thisRowSum;
  //  freopen("d:\\cyy\\a.txt","r",stdin);
   // freopen("d:\\cyy\\b.txt","w",stdout);
    memset(maxSum, 0, sizeof(maxSum));
    scanf("%d", &n);

    for(i=1;i<=n;i++)//��Ϊ����Ҫ-1 �����0��ʼҪ��
        for(j=1;j<=n;j++)
            scanf("%d", &a[i][j]);
    for(i=1;i<=n;i++)
    {
        for(j=1;j<=n;j++)
        {
            thisRowSum = 0;
            for(k=j;k<=n;k++)
            {
                thisRowSum += a[i][k];
                if(maxSum[i-1][j][k]>0)
                    maxSum[i][j][k] =maxSum[i-1][j][k] + thisRowSum;//��Ϊ�����ڶ�������Ҫ�Ƚϵ��Ǽ��˱�������һ��ͬһλ�úͱ��к͵Ĵ�С
                else
                    maxSum[i][j][k] = thisRowSum;

                if(maxSum[i][j][k]>sum)
                    sum = maxSum[i][j][k];
            }
        }
    }
    printf("%d\n", sum);
    return 0;
}
