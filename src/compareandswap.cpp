#include <cstdio>
#include <memory>

bool compareandswap(int *addr, int old, int new)
{
    if(*addr!=old)
        return false;
    *addr = new;
    return true;
}

void cas(int *i)
{
    int old;
    int new;
    do{
        old=*i;
        new=*i+1;
    }while(compareandswap(i,old,new));
}
