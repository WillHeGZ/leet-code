package xyz.gzzh.leetcode.application;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    int n;
    ArrayList<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        this.n = n;//括号对数
        int left = 0;//左括号的个数
        int right = 0;//右括号的个数
        dfs(0, 0, "");
        return res;
    }

    private void dfs(int left, int right, String str) {
        if (left == n && right == left) {//一个匹配结果
            res.add(str);
            return;
        }
        if (left + 1 <= n) {
            dfs(left + 1, right, str + "(");
        }
        if (right + 1 <= left) {
            dfs(left, right + 1, str + ")");
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(3);

        System.out.println(strings);
    }
}
