/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long left = 1;
        long right = n;
        long mid = (left+right)/2;
        while (left <= right) {
            if (isBadVersion((int)mid)) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            mid = (left+right)/2;
        }
        if (isBadVersion((int)mid)) {
            return (int)mid;
        }
        return (int)mid+1;
    }
}