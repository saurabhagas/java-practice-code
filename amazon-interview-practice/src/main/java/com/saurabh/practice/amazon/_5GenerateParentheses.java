package com.saurabh.practice.amazon;

import java.util.ArrayList;
import java.util.List;

public class _5GenerateParentheses {
  public static void main(String[] args) {
    _5GenerateParentheses s = new _5GenerateParentheses();
    List<String> ans = s.generateParenthesis(3);
    System.out.println(ans);
  }

  public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    backtrack(ans, "", 0, 0, n);
    return ans;
  }

  private void backtrack(List<String> ans, String cur, int open, int close, int max) {
    if (cur.length() == max * 2) {
      ans.add(cur);
      return;
    }

    if (open < max)
      backtrack(ans, cur + "(", open + 1, close, max);
    if (close < open)
      backtrack(ans, cur + ")", open, close + 1, max);
  }
}
