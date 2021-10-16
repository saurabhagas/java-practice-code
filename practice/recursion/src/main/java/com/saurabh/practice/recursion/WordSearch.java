package com.saurabh.practice.recursion;

/**
 * Problem at: https://leetcode.com/problems/word-search/
 */
public class WordSearch {
  public static void main(String[] args) {
    WordSearch wordSearch = new WordSearch();
//    char[][] board = {
//      {'A', 'B', 'C', 'E'},
//      {'S', 'F', 'C', 'S'},
//      {'A', 'D', 'E', 'E'}
//    };
    char[][] board = {
      {'A', 'A', 'A', 'A', 'A', 'A'},
      {'A', 'A', 'A', 'A', 'A', 'A'},
      {'A', 'A', 'A', 'A', 'A', 'A'},
      {'A', 'A', 'A', 'A', 'A', 'A'},
      {'A', 'A', 'A', 'A', 'A', 'A'},
      {'A', 'A', 'A', 'A', 'A', 'A'}
    };
//    System.out.println(wordSearch.exist(board, "ABCCED"));
    System.out.println(wordSearch.exist(board, "AAAAAAAAAAAABAA"));
  }

  public boolean exist(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;
    boolean[][] visited = new boolean[rows][cols];
    Trie trie = new Trie();
    trie.insert(word);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (exists(board, i, j, trie, word,"" + board[i][j], visited)) return true;
      }
    }
    return false;
  }

  private boolean exists(char[][] board, int x, int y, Trie trie, String word, String soFar, boolean[][] visited) {
    if (x < 0 || y < 0 || y >= board[0].length || x >= board.length || visited[x][y]) return false;
    if (soFar.length() == word.length() && word.equals(soFar)) return true;
    visited[x][y] = true;
    String next = soFar + board(board, x, y + 1);
    boolean found = trie.startsWith(next) && exists(board, x, y + 1, trie, word, next, visited);
    if (!found) {
      next = soFar + board(board, x, y - 1);
      found = trie.startsWith(next) && exists(board, x, y - 1, trie, word, next, visited);
    }

    if (!found) {
      next = soFar + board(board, x + 1, y);
      found = trie.startsWith(next) && exists(board, x + 1, y, trie, word, next, visited);
    }

    if (!found) {
      next = soFar + board(board, x - 1, y);
      found = trie.startsWith(next) && exists(board, x - 1, y, trie, word, next, visited);
    }
    visited[x][y] = false;
    return found;
  }

  private String board(char[][] board, int x, int y) {
    if (x < 0 || y < 0 || y >= board[0].length || x >= board.length) return "";
    return "" + board[x][y];
  }
}

class Trie {
  private final TrieNode root = new TrieNode();

  public void insert(String word) {
    char[] chars = word.toCharArray();
    TrieNode current = root;
    for (char ch : chars) {
      int pos = toPosition(ch);
      TrieNode rightNode = current.children[pos];
      if (rightNode == null) {
        current.children[pos] = new TrieNode();
      }
      current = current.children[pos];
    }
    current.isEndOfWord = true;
  }

  public boolean startsWith(String prefix) {
    char[] chars = prefix.toCharArray();
    TrieNode current = root;
    for (char ch : chars) {
      int pos = toPosition(ch);
      TrieNode rightNode = current.children[pos];
      if (rightNode == null) {
        return false;
      }
      current = rightNode;
    }
    return true;
  }

  private int toPosition(char ch) {
    return Character.getNumericValue(ch);
  }

  private static class TrieNode {
    private final TrieNode[] children = new TrieNode[128];
    private boolean isEndOfWord;
  }
}
