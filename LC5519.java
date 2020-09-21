import java.util.ArrayList;
import java.util.List;

class Solution {
    public String reorderSpaces(String text) {
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        int count=0;
        for (int i = 0; i < text.toCharArray().length; i++) {
            if(text.charAt(i)!=' ')
                stringBuilder.append(text.charAt(i));
            else
            {
                count++;
                if(stringBuilder.length()!=0)
                {
                    list.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            }
        }
        if(stringBuilder.length()!=0)
        {
            list.add(stringBuilder.toString());
            stringBuilder = new StringBuilder();
        }
        int average;
        if(list.size()>1)
            average = count/(list.size()-1);
        else
            average = 0;
        int remind = count-average*(list.size()-1);
//        System.out.println(average+"          "+count+ "    "+remind);
        for(int i =0;i<list.size()-1;i++)
        {
            stringBuilder.append(list.get(i));
            for(int j=0;j<average;j++)
            {
                stringBuilder.append(' ');
            }
        }
        stringBuilder.append(list.get(list.size()-1));
        for(int j=0;j<remind;j++)
        {
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }
}