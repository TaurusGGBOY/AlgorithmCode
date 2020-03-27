class Solution {
  public boolean lemonadeChange(int[] bills) {
    int[] moneys = new int[21];
    for (int i = 0; i < bills.length; i++) {
      moneys[bills[i]]++;
      if (bills[i] == 20) {
        if (moneys[10] != 0) {
          moneys[10]--;
          moneys[5]--;
        }
        else
        {
            moneys[5]-=3;
        }
      }
      else if(bills[i]==10)
      {
          moneys[5]--;
      }
      if(moneys[5]<0||moneys[10]<0)
          return false;
    }
    return true;
  }
}
