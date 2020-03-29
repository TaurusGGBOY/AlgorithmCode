class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphas=new int[128];

        for(int i=0;i<magazine.length();i++)
        {
            alphas[magazine.charAt(i)]++;
        }
        for(int i=0;i<ransomNote.length();i++)
        {
            alphas[ransomNote.charAt(i)]--;
            if(alphas[ransomNote.charAt(i)]<0)
                return false;
        }
        return true;
    }
}