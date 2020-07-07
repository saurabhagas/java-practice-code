package com.saurabh.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
  public static void main(String[] args) {
    GenerateParentheses s = new GenerateParentheses();
    List<String> ans = s.generateParenthesis(3);
    System.out.println(ans);
  }

  public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    generate(ans, "", 0, 0, n);
    return ans;
  }

  private void generate(List<String> ans, String cur, int open, int close, int max) {
    if (cur.length() == max * 2) {
      ans.add(cur);
      return;
    }

    if (open < max) generate(ans, cur + "(", open + 1, close, max);
    if (close < open) generate(ans, cur + ")", open, close + 1, max);
  }
}
