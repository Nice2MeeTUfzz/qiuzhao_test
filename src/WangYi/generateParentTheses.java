package WangYi;

import java.util.ArrayList;
import java.util.List;

public class generateParentTheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println(result);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String cur, int left, int right, int n) {
        if (cur.length() == 2 * n) {
            result.add(cur);
            return;
        }

        if (left < n) {
            backtrack(result, cur + "(", left + 1, right, n);
        }
        if (right<left) {
            backtrack(result, cur + ")", left, right + 1, n);
        }
    }
}

