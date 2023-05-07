class TextEditor {

    class Node {
        char c;
        Node prev;
        Node next;
    }

    void delete(Node node) {
        Node n = node.next;
        Node p = node.prev;
        n.prev = p;
        p.next = n;
    }

    void insert(Node node, Node temp) {
        Node n = node.next;

        node.next = temp;
        temp.prev = node;

        temp.next = n;
        n.prev = temp;
    }

    Node yummy;
    Node tail;
    Node cursor;


    public TextEditor() {
        yummy = new Node();
        tail = new Node();
        yummy.next = tail;
        tail.prev = yummy;
        cursor = yummy;
    }

   /* void print() {
        Node temp = yummy;
        while (temp.next != tail) {
//            System.out.print(temp.next.c + " ");
            temp = temp.next;
        }
//        System.out.println("cursor:" + cursor.c);
//        System.out.println();
    }*/

    public void addText(String text) {
        for (int i = 0; i < text.length(); i++) {
            Node node = new Node();
            node.c = text.charAt(i);
            insert(cursor, node);
            cursor = node;
        }
//        print();
    }

    public int deleteText(int k) {
        int count = 0;
        for (int i = 0; i < k && cursor != yummy; i++, count++) {
            Node prev = cursor.prev;
            delete(cursor);
            cursor = prev;
        }
//        System.out.println("delete");
//        print();
        return count;
    }

    public String cursorLeft(int k) {
        for (int i = 0; i < k && cursor != yummy; i++) {
            cursor = cursor.prev;
        }
        Node temp = cursor;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10 && temp != yummy; i++) {
            stringBuilder.append(temp.c);
            temp = temp.prev;
        }
        return stringBuilder.reverse().toString();
    }

    public String cursorRight(int k) {
        for (int i = 0; i < k && cursor.next != tail; i++) {
            cursor = cursor.next;
        }
        Node temp = cursor;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10 && temp != yummy; i++) {
            stringBuilder.append(temp.c);
            temp = temp.prev;
        }
        return stringBuilder.reverse().toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */