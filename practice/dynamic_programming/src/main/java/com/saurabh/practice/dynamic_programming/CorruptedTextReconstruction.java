package com.saurabh.practice.dynamic_programming;

import java.util.HashSet;
import java.util.Set;

/**
 * A text got corrupted as all of the punctuation (including spaces) vanished. The task is to check if this text can be
 * reconstructed using a dictionary of words, and print the resurrected text if possible.
 */
public class CorruptedTextReconstruction {
  private final String text;
  private final Set<String> dictionary;
  private final boolean[] matrix;

  public CorruptedTextReconstruction(String text) {
    this(text, defaultDictionary());
  }

  public CorruptedTextReconstruction(String text, Set<String> dictionary) {
    this.text = text;
    this.dictionary = dictionary;
    this.matrix = new boolean[text.length() + 1];
  }

  public boolean isReconstructionPossible() {
    matrix[0] = true;
    matrix[1] = dictionary.contains(text.substring(0, 1));
    for (int i = 0; i < text.length(); i++) {
      for (int j = 1; j <= i; j++) {
        matrix[i + 1] = matrix[i + 1] || (matrix[j - 1] && dictionary.contains(text.substring(j - 1, i + 1)));
      }
    }
    return matrix[text.length()];
  }

  private static Set<String> defaultDictionary() {
    Set<String> dictionary = new HashSet<>();
    dictionary.add("i");
    dictionary.add("me");
    dictionary.add("you");
    dictionary.add("we");
    dictionary.add("it");
    dictionary.add("was");
    dictionary.add("the");
    dictionary.add("bet");
    dictionary.add("best");
    dictionary.add("of");
    dictionary.add("toft");
    dictionary.add("time");
    dictionary.add("times");
    return dictionary;
  }
}
