package 得物914;
/*
得物-2026届秋招-0913
树上逆序对
题目描述:
小红给小明画了一棵n个节点的树,这棵树的每个节点上都有一个值a.现在小红想要小明回答以下问题:
在树上选择一条简单路径(每个点经过最多一次),并将沿途经过的点的直接顺序写下来(包括起点与终点),之后得到一个序列B,并计算这个序列的逆序对个数.
小红想知道能够选择的所有路径中逆序对数量最多是多少.
(i,j)）是逆序对当且仅当iB[]。
输入描述：
第一行一个正整数n；
接下来一行n个正整数a，表示节点1的值;
接下来来一行n-1个正整数p,(2≤i,1≤p,<)，表示节点i与p,之间有一条边。
1sn≤300,1≤as10^5
输出描述：
输出一个整数，表逆序对最多的数量。
样例输入：
5
1 2 3 4 5
1 2 2 4
样例输出：
6
提示:
选择的路径为5421，共6个逆序对。
 */

import java.util.*;

public class BISHI3 {
    private static int maxInversions = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            values[i] = sc.nextInt();
        }

        //构建树的邻接表
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 2; i <= n; i++) {
            int parent = sc.nextInt();
            tree.get(i).add(parent);
            tree.get(parent).add(i);
        }

        maxInversions = 0;

        for (int start = 1; start <= n; start++) {
            boolean[] visited = new boolean[n + 1];
            visited[start] = true;
            List<Integer> path = new ArrayList<>();
            path.add(start);
            dfs(tree, start, values, visited, path, 0);
        }
    }

    private static void dfs(List<List<Integer>> tree, int current, int[] values,
                            boolean[] visited, List<Integer> path, int currentInv) {
        // 更新最大逆序对数量
        maxInversions = Math.max(maxInversions, currentInv);

        // 探索所有相邻节点
        for (int neighbor : tree.get(current)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;

                // 计算添加新节点后新增的逆序对数量
                int newInv = currentInv;
                for (int node : path) {
                    if (values[node] > values[neighbor]) {
                        newInv++;
                    }
                }

                // 加入路径，继续DFS
                path.add(neighbor);
                dfs(tree, neighbor, values, visited, path, newInv);
                // 回溯
                path.remove(path.size() - 1);

                visited[neighbor] = false;
            }
        }
    }

}
