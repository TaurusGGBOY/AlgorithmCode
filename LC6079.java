import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] strs = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            if (!str.startsWith("$")) {
                stringBuilder.append(str).append(" ");
                continue;
            }
            try {
                BigDecimal pre = new BigDecimal(str.substring(1));
                pre = pre.multiply(new BigDecimal(100 - discount)).divide(new BigDecimal(100));
                StringBuilder stringBuilder1 = new StringBuilder(pre.toString());
                int index = stringBuilder1.indexOf(".");
                if (index < 0) stringBuilder1.append(".00");
                else stringBuilder1.append("00");
                stringBuilder.append("$");
                index = stringBuilder1.indexOf(".");
                stringBuilder.append(stringBuilder1.substring(0, index + 3)).append(" ");
            } catch (Exception e) {
                stringBuilder.append(str).append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }
}