package leetcode.dp;//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionHuiWen_131 {
    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            System.out.println("judging i =" + i + ", j =" + j);
            if (f[i][j]) {
                System.out.println("succeed i =" + i + ", j=" + j);
                ans.add(s.substring(i, j + 1));

                dfs(s, j + 1);
                //System.out.println("removing " + ans.get(ans.size() - 1 ));
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PartitionHuiWen_131 partitionHuiWen_131 = new PartitionHuiWen_131();
        List<List<String>> aabbcdcb = partitionHuiWen_131.partition("aabbcdcb");
        System.out.println("aabbcdcb = " + aabbcdcb);


    }
}
/**
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 *
 */
