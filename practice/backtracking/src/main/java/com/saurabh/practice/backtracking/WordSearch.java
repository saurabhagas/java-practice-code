package com.saurabh.practice.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.saurabh.source.data_structures.Trie;

public class WordSearch {

  private static Trie trie;

  public static void main(String[] args) {
    WordSearch obj = new WordSearch();

    trie = new Trie();
    String[] words = {"oath", "pea", "eat", "rain"};
    for (String word : words) {
      trie.insert(word);
    }
    char[][] board = {
      {'o', 'a', 'a', 'n'},
      {'e', 't', 'a', 'e'},
      {'i', 'h', 'k', 'r'},
      {'i', 'f', 'l', 'v'},
    };
    System.out.println(obj.findWords(board));
  }

  public List<String> findWords(char[][] board) {
    boolean[][] visited = new boolean[board.length][board[0].length];
    Set<String> matchingWords = new HashSet<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (!trie.allCommonPrefixes("" + board[i][j]).isEmpty()) {
          findWords(board, i, j, visited, "", matchingWords);
        }
      }
    }
    return new ArrayList<>(matchingWords);
  }

  private void findWords(char[][] board, int x, int y, boolean[][] visited, String soFar, Set<String> matchingWords) {
    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) return;

    soFar += board[x][y];
    if (trie.search(soFar)) matchingWords.add(soFar);

    visited[x][y] = true;
    findWords(board, x - 1, y, visited, soFar, matchingWords); //up
    findWords(board, x + 1, y, visited, soFar, matchingWords); //down
    findWords(board, x, y - 1, visited, soFar, matchingWords); //left
    findWords(board, x, y + 1, visited, soFar, matchingWords); //right
    visited[x][y] = false;
  }
}