class LCPerson20200418_05 {
  public int minCount(int[] coins) {
    int count=0;
    for(int coin:coins)
    {
      count+=(coin+1)/2;
    }
    return count;
  }
}