import java.io.*;
import java.util.*;

class TopKUseCase {
    public static void main(String[] args) throws IOException {
        try {
            final int divNum = 1000;
            System.out.println("test");
            File outputfile = new File("d:\\bigdata.txt");
            StringBuilder stringBuilder = new StringBuilder();
            PrintWriter output = new PrintWriter(outputfile);
            for (int i = 0; i < 1000000000; i++) {
                stringBuilder.append("user" + (int) (Math.random() * 10000) + "who" + System.lineSeparator());
            }
            if (!outputfile.exists())
                outputfile.createNewFile();
            output = new PrintWriter(outputfile);
            output.println(stringBuilder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}