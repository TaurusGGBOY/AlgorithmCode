class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<=2)
            return true;
        boolean flag=true;
        for(int i=0;i<coordinates.length-1;i++)
        {
            if(coordinates[i][0]!=coordinates[i+1][0])
            {
                flag=false;
                break;
            }
        }
        if(flag)
            return true;
        flag=true;
        for(int i=0;i<coordinates.length-1;i++)
        {
            if(coordinates[i][1]!=coordinates[i+1][1])
            {
                flag=false;
                break;
            }
        }
        if(flag)
            return true;
        flag=true;
        for(int i=0;i<coordinates.length-2;i++)
        {
            int x1=coordinates[i+1][0]-coordinates[i][0];
            int y1=coordinates[i+1][1]-coordinates[i][1];
            int x2=coordinates[i+2][0]-coordinates[i+1][0];
            int y2=coordinates[i+2][1]-coordinates[i+1][1];
            if(x1*y2!=x2*y1)
            {
                flag=false;
                break;
            }
        }
        return flag;
    }
}