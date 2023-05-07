class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] split1 = num1.split("[+i]");
        String[] split2 = num2.split("[+i]");
        int[] num1_num2 = new int[4];
        if (split1[0].isEmpty()) num1_num2[0] = 0;
        else num1_num2[0] = Integer.parseInt(split1[0]);
        if (split1[1].isEmpty()) num1_num2[1] = 0;
        else num1_num2[1] = Integer.parseInt(split1[1]);
        if (split2[0].isEmpty()) num1_num2[2] = 0;
        else num1_num2[2] = Integer.parseInt(split2[0]);
        if (split2[1].isEmpty()) num1_num2[3] = 0;
        else num1_num2[3] = Integer.parseInt(split2[1]);
        int real = num1_num2[0] * num1_num2[2] + (num1_num2[1] * num1_num2[3]) * -1;
        int virtual = num1_num2[0] * num1_num2[3] + num1_num2[1] * num1_num2[2];
        return real + "+" + virtual + "i";
    }
}