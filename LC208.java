import java.util.ArrayList;
import java.util.List;

class Trie {
    public TrieNodeList trieNodeList = new TrieNodeList();

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] cstr = word.toCharArray();
        TrieNode node = trieNodeList.findNode(cstr[0]);
        if (node == null)
            node = trieNodeList.insert(cstr[0]);

        for (int i = 1; i < word.length(); i++) {
            node = node.insert(cstr[i]);
        }
        // System.out.println(node.ca);
        // System.out.println(node.isEnd);
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] cstr = word.toCharArray();
        TrieNode node = trieNodeList.findNode(cstr[0]);
        if (node == null)
            return false;
        for (int i = 1; i < word.length(); i++) {
            node = node.findNode(cstr[i]);
            if (node == null)
                return false;
        }
        // System.out.println(node.ca);
        // System.out.println(node.isEnd);
        if (node.isEnd)
            return true;
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] cstr = prefix.toCharArray();
        TrieNode node = trieNodeList.findNode(cstr[0]);
        if (node == null)
            return false;
        for (int i = 1; i < prefix.length(); i++) {
            node = node.findNode(cstr[i]);
            if (node == null)
                return false;
        }
        return true;

    }
}

class TrieNode {
    public char ca;
    TrieNodeList trieNodeList = new TrieNodeList();
    public boolean isEnd = false;

    public TrieNode() {
        isEnd = false;
    }

    public TrieNode(char c) {
        ca = c;
        isEnd = false;
    }

    public boolean contains(char c) {
        if (trieNodeList.findNode(c) == null)
            return false;
        return true;
    }

    public TrieNode findNode(char c) {
        return trieNodeList.findNode(c);
    }

    public TrieNode insert(char c) {
        return trieNodeList.insert(c);
    }

    public boolean isEmpty() {
        return trieNodeList.isEmpty();
    }

}

class TrieNodeList {
    List<TrieNode> list = new ArrayList<>();

    public TrieNodeList() {

    }

    public TrieNodeList(List<TrieNode> nodeList) {
        list = nodeList;
    }

    public TrieNode findNode(char c) {
        for (TrieNode node : list)
            if (node.ca == c)
                return node;
        return null;
    }

    public TrieNode insert(char c) {
        TrieNode node = findNode(c);
        if (node == null) {
            node = new TrieNode(c);
        }
        list.add(node);
        return node;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */