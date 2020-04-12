import java.util.ArrayList;
import java.util.List;

class Test {
  public static void main(String[] args) {
      int i=1024*1024*8;
      List<Byte[]> lists = new ArrayList<>();
    while (true) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Byte[] bytes = new Byte[i++];
      lists.add(bytes);
    }
  }
}
