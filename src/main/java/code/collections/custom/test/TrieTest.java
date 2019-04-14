package code.collections.custom.test;

import code.collections.custom.impl.Trie;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TrieTest {
  private static final List<String> uniqueKeys = Arrays.asList("the", "a", "there", "answer", "any", "by", "bye", "their", "abc");
  private static final List<String> duplicateKeys = Arrays.asList("the", "a", "any", "by");
  private static final List<String> nonExistentKeys = Arrays.asList("foo", "bar", "therefore", "answered", "an", "ab");
  private static final List<String> toDelete = Arrays.asList("the", "a", "by");
  private static final List<String> toDelete2 = Arrays.asList("there", "answer", "any", "bye", "their", "abc");
  private final Trie trie = new Trie();

  @Test
  public void testInsertDuplicateWords() {
    uniqueKeys.forEach(uniqueKey -> assertTrue(trie.insert(uniqueKey)));
    duplicateKeys.forEach(duplicateKey -> assertFalse(trie.insert(duplicateKey)));
    assertThat(trie.getWordCount(), is(uniqueKeys.size()));
  }

  @Test
  public void testWords() {
    List<String> toInsert = Arrays.asList("geeks", "for", "a", "portal",
        "to", "learn", "can", "be", "computer",
        "science", "zoom", "yup", "fire", "in", "data");
    toInsert.forEach(uniqueKey -> assertTrue(trie.insert(uniqueKey)));
    Collection<String> words = trie.getWords();
    System.out.println(words);
    assertThat(words, hasItems(toInsert.toArray(new String[0])));
    assertThat(trie.getWordCount(), is(toInsert.size()));
  }

  @Test
  public void testSearch() {
    uniqueKeys.forEach(uniqueKey -> assertTrue(trie.insert(uniqueKey)));
    uniqueKeys.forEach(uniqueKey -> assertTrue("Assertion failed for: " + uniqueKey, trie.search(uniqueKey)));
    nonExistentKeys.forEach(nonExistentKey -> assertFalse("Assertion failed for: " + nonExistentKey, trie.search(nonExistentKey)));
  }

  @Test
  public void testDelete() {
    uniqueKeys.forEach(uniqueKey -> assertTrue(trie.insert(uniqueKey)));

    toDelete.forEach(toDeleteKey -> assertTrue(trie.remove(toDeleteKey)));
    List<String> survived = new ArrayList<>(uniqueKeys);
    survived.removeAll(toDelete);
    assertThat(trie.getWordCount(), is(survived.size()));

    toDelete2.forEach(toDeleteKey -> assertTrue(trie.remove(toDeleteKey)));
    assertThat(trie.getWordCount(), is(0));

    nonExistentKeys.forEach(nonExistentKey -> assertFalse(trie.remove(nonExistentKey)));
  }

  @Test
  public void testLongestPrefixMatch_someOverlap() {
    trie.clear();
    trie.insert("geeksforgeeks");
    trie.insert("geeks");
    trie.insert("geek");
    trie.insert("geezer");
    assertThat(trie.longestCommonPrefix(), is("gee"));
  }

  @Test
  public void testLongestPrefixMatch_exactOverlap() {
    trie.clear();
    trie.insert("geeks");
    trie.insert("geeks");
    assertThat(trie.longestCommonPrefix(), is("geeks"));
  }

  @Test
  public void testLongestPrefixMatch_noOverlap() {
    trie.clear();
    trie.insert("geeksforgeeks");
    trie.insert("geeks");
    trie.insert("geek");
    trie.insert("geezer");
    trie.insert("the");
    assertThat(trie.longestCommonPrefix(), is(""));
  }

  @Test
  public void testLongestPrefixMatch_emptyTrie() {
    trie.clear();
    assertThat(trie.longestCommonPrefix(), is(""));
  }

  @Test
  public void testAutocompleteSuggestions() {
    uniqueKeys.forEach(uniqueKey -> assertTrue(trie.insert(uniqueKey)));

    assertThat(trie.getAutoCompleteSuggestions("the"), hasItems("the", "their", "there"));
    assertThat(trie.getAutoCompleteSuggestions("a"), hasItems("a", "answer", "any", "abc"));
    assertThat(trie.getAutoCompleteSuggestions("b"), hasItems("by", "bye"));
  }

  @Test
  public void testInputWordFormationFromTrie_Ok() {
    uniqueKeys.forEach(uniqueKey -> assertTrue(trie.insert(uniqueKey)));
    assertTrue(isPossible("thereby"));
    assertTrue(isPossible("aby"));
  }

  @Test
  public void testInputWordFormationFromTrie_not_ok() {
    uniqueKeys.forEach(uniqueKey -> assertTrue(trie.insert(uniqueKey)));
    assertFalse(isPossible("therefore"));
    assertFalse(isPossible("blah"));
  }

  private boolean isPossible(String word) {
    String wordCopy = word;
    List<String> allMatching = trie.allCommonPrefixes(wordCopy);
    for (int i = allMatching.size() - 1; i >= 0; i--, wordCopy = word) {
      String matching = allMatching.get(i);
      wordCopy = wordCopy.replaceAll(matching, "");

      List<String> allNextMatching = trie.allCommonPrefixes(wordCopy);
      for (int j = allNextMatching.size() - 1; j >= 0; j--) {
        String nextMatching = allNextMatching.get(j);
        wordCopy = wordCopy.replaceAll(nextMatching, "");
        if (wordCopy.length() == 0) {
          return true; // Nothing left in the original string to substring(), match found
        }
      }
    }
    return false;
  }
}
