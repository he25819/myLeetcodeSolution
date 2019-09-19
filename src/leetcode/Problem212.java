package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem212 {
    // 题目没有说明，但是这道题的返回不能有重复的
    // 37 / 37 test cases passed.
    //Status: Accepted
    //Runtime: 519 ms
    // Your runtime beats 15.88 % of java submissions.
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        if (board == null || board.length == 0)
            return list;

        for (String word : words) {
            addWordIfExist(list, board, word);
        }
        return list;
    }

    private void addWordIfExist(List<String> list, char[][] board, String word) {
        if (word == null || word.length() == 0)
            return;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (list.indexOf(word) < 0 && exist(board, word, 0, i, j))
                    list.add(word);
    }

    private boolean exist(char[][] board, String word, int index, int x, int y) {
        if (index == word.length())
            return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(index++))
            return false;

        board[x][y] = '*';
        if (exist(board, word, index, x - 1, y)
                || exist(board, word, index, x, y - 1)
                || exist(board, word, index, x + 1, y)
                || exist(board, word, index, x, y + 1)) {
            board[x][y] = word.charAt(index - 1);
            return true;
        }
        board[x][y] = word.charAt(index - 1);
        return false;
    }


    // learn from https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
    // 37 / 37 test cases passed.
    //Status: Accepted
    //Runtime: 24 ms
    // Your runtime beats 66.16 % of java submissions.
    public List<String> findWords2(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null)
            return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;      // de-duplicate
        }
        board[i][j] = '#';
        if (i > 0)
            dfs(board, i - 1, j, p, res);
        if (j > 0)
            dfs(board, i, j - 1, p, res);
        if (i < board.length - 1)
            dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1)
            dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null)
                    p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
