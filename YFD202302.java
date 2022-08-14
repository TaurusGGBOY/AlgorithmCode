import java.util.*;

public class Main {

    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = Integer.parseInt(scanner.nextLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < p; i++) set.add(scanner.nextLine());

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        Map<String, String> map3 = new HashMap<>();
        Map<String, String> map4 = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            String s = scanner.nextLine();
            String[] strs = s.split("\\/");
            map1.put(strs[0], strs[1]);
            map2.put(strs[0], strs[2]);
            map3.put(strs[1], strs[0]);
            for (String s1 : strs[2].split(",")) {
                map4.put(s1, strs[0]);
            }
        }

        Map<String, String> map5 = new HashMap<>();
        Map<String, String> map6 = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            String s = scanner.nextLine();
            String[] strs = s.split("\\/");
            map5.put(strs[1], strs[0]);
            map6.put(strs[0], strs[1]);
        }

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < s.length() / 2; j++) {
                String str1 = String.valueOf(s.charAt(2 * j));
                String str2 = String.valueOf(s.charAt(2 * j + 1));
                String str3 = str1+str2;
                if(map5.containsKey(str3)){
                    stringBuilder.append(map5.get(str3)).append(" ");
                    continue;
                }
                if (!map1.containsKey(str1) || !map2.containsKey(str2)) {
                    stringBuilder.append(s.charAt(2 * j)).append(s.charAt(2 * j + 1)).append(" ");
                    continue;
                }

                String prefix = map1.get(str1);
                String[] strs = map2.get(str2).split(",");
                boolean flag = false;
                for (String str : strs) {
                    if(set.contains(prefix+str)){
                        stringBuilder.append(prefix).append(str).append(" ");
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    stringBuilder.append(s.charAt(2 * j)).append(s.charAt(2 * j + 1)).append(" ");
                    continue;
                }
            }
            System.out.println(stringBuilder.toString().trim());
        }


        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String s = scanner.nextLine();
            String[] strs = s.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if(map6.containsKey(str)){
                    stringBuilder.append(map6.get(str));
                    continue;
                }

                if(!set.contains(str)){
                    stringBuilder.append(str);
                    continue;
                }
                String prefix = "";
                for (String v : map1.values()) {
                    if (v.length() != 1) continue;
                    if (str.startsWith(v)) prefix = v;
                }
                for (String v : map1.values()) {
                    if (v.length() != 2) continue;
                    if (str.startsWith(v)) prefix = v;
                }
                if(prefix.isEmpty()){
                    stringBuilder.append(str);
                    continue;
                }
                String subfix = str.substring(prefix.length());
                if(map4.containsKey(subfix)) stringBuilder.append(map3.get(prefix)).append(map4.get(subfix));
                else{
                    stringBuilder.append(str);
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }

}
