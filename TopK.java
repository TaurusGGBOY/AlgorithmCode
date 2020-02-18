import java.io.*;
import java.util.*;

class TopK {
    public static void main(String[] args) throws IOException {
        final int divNum = 1000;
        File inputFile = new File("d:\\bigdata.txt");
        FileInputStream inputStream = new FileInputStream(inputFile);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        File outputfile;
        PrintWriter output;
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            int order = str.hashCode() & divNum;
            outputfile = new File("D:\\div\\d" + order + "file.txt");
            if (!outputfile.exists())
                outputfile.createNewFile();
            output = new PrintWriter(outputfile);
            output.println(str);
        }
		String[] strArray;
		Map<String,Integer> map;
		Queue<Map.Entry<String,Integer>> queue = new PriorityQueue<>(10, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getValue()-o2.getValue();
			}
		});
        for (int i = 0; i < divNum; i++) {
            inputFile = new File("D:\\div\\d" + i + "file.txt");
			str = readToString(inputFile);
			strArray = str.split(System.lineSeparator());
			map = new HashMap<>();
			for(String string:strArray)
			{
				try {
					map.put(string,map.get(string)+1);
				}
				catch (Exception e)
				{
					map.put(string, 1);
				}
			}

			for(Map.Entry<String,Integer> entry:map.entrySet())
			{
				if (queue.size() < 10) {
					queue.add(entry);
					continue;
				}
				if(entry.getValue()>queue.peek().getValue())
				{
					queue.poll();
					queue.add(entry);
				}
			}
        }
        Iterator<Map.Entry<String, Integer>> iterator = queue.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String,Integer> entry = iterator.next();
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
    }
    public static String readToString(File file) {
        Long filelength = file.length();     //获取文件长度
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(filecontent);//返回文件内容,默认编码
    }
}