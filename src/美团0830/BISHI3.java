package 美团0830;
/*
题目内容
给定一棵以节点1为根的有n个节点的树，每个节点i有一个正整数权值w;，初始被涂成黑色
或白色。你需要支持以下两种操作：
1.翻转节点こ的颜色(黑色变白色，自色变黑色)；
2.查询从根节点1到节点的路径上所有黑色节点的权值的最小公倍数（若路径上无黑色节点，
则记为1）
【名词解释】
最小公倍数：最小公倍数是能够被给定整数集合中每个整数整除的最小正整数，记为Lcm。
输入描述
第一行输入两个整数n和q(1≤n，q≤2x10)，分别表示树的节点数量和操作数量。
第二行输入n个整数w1,W2,.,wn(1≤w≤100)，分别表示节点1到节点n的权值。
第三行输入一个长度为n、仅由字符B和W构成的字符串c，其中=B表示节点i初始
化为黑色，=W表示初始化为白色。
接下来n一1行，每行输入两个整数u;和u(1≤u，0n;uv)，表示一条连接节点
u和节点的无向边，保证这n个节点构成一颗根为1的树。
接下来行，每行输入两个整数t和∞(t∈1,2,1≤≤n)，表示一次操作。
1.当t=1时，执行翻转操作；
2.当t=2时，执行查询操作。
输出描述
对于每次查询操作，在一行中输出一个整数，表示对应路径上黑色节点权值的最小公倍数对
(10°+7）取模后的结果。
 */

import java.util.*;

public class BISHI3 {
    private static final int MOD = 1000000007;
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static long lcm(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a * b) / gcd(a, b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        String[] color = new String[n];
        String str = sc.next();
        for (int i = 0; i < n; i++) {
            color[i] = String.valueOf(str.charAt(i));
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int ui = sc.nextInt();
            int vi = sc.nextInt();
            list.get(ui).add(vi);
            list.get(vi).add(ui);
        }
        //计算每个节点的父节点（通过BFS从根节点1遍历）
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        parent[1] = -1;
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : list.get(u)) {
                //如果v未访问过且不是u的父节点
                if (parent[v] == -1 && v != parent[u]) {
                    parent[v] = u;
                    queue.add(v);
                }
            }
        }
        while (q-- > 0) {
            int t = sc.nextInt();
            int x = sc.nextInt();
            if (t == 1) {
                int idx = x - 1;
                color[idx] = color[idx].equals("B") ? "W" : "B";
            } else if (t == 2) {
                List<Integer> path = new ArrayList<>();
                int current = x;
                while (current != -1) {
                    path.add(current);
                    current = parent[current];
                }

                long currentLcm = 1;
                for (int node : path) {
                    int idx = node - 1;
                    if (color[idx].equals("B")) {
                        long weight = w[idx];
                        currentLcm = lcm(currentLcm, weight);
                    }
                }
                System.out.println(currentLcm%MOD);
            }
        }
    }
}
