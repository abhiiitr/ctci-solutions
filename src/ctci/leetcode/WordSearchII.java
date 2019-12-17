package ctci.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    class Node {
        // Good to store the word at the end of valid word
        String word;
        Node[] children;

        Node() {
            children = new Node[26];
        }
    }

    class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.children[ch - 'a'] == null)
                    node.children[ch - 'a'] = new Node();
                node = node.children[ch - 'a'];
            }
            node.word = word;
        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        List<String> result = new ArrayList<>();
        boolean visited[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                findWords(board, i, j, trie.root, result, visited);
            }
        }
        return result;

    }

    public void findWords(char[][] board, int row, int col, Node node, List<String> result, boolean visited[][]) {
        char ch = board[row][col];
        Node child = node.children[ch - 'a'];
        if (child == null)
            return;
        if (child.word != null) {
            result.add(child.word);
            child.word = null;
        }

        visited[row][col] = true;
        int neighbour[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        for (int i = 0; i < 4; i++) {
            int r = row + neighbour[i][0];
            int c = col + neighbour[i][1];
            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && !visited[r][c]) {
                findWords(board, r, c, child, result, visited);
            }
        }
        visited[row][col] = false;
    }

    public static void main(String[] args) {

        WordSearchII obj = new WordSearchII();
        char[][] board = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};

        String words[] = {"oath", "pea", "eat", "rain", "oathf", "aat"};
        System.out.println(obj.findWords(board, words));
    }

}
