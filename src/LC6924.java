import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }
}

class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Trie trie = new Trie();
        for (String s : forbidden) {
            trie.insert(s);
        }

        int left = 0, right = 0;
        int maxLen = 0;

        while (right < word.length()) {
            if (!trie.search(word.substring(left, right + 1))) {
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                right++;
                left++;
            }
        }

        return maxLen;
    }
}
