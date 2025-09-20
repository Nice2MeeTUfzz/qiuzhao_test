package 美团823;
/*
题目内容
给定一棵以节点1为根的树，树上共有n个节点，其中某些节点被标记为“红点"。每条边（u，0）具有正整数权重wu
接下来有次操作，每次操作有两种类型：
1.切换节点的红点状态（若为红点则变为非红点，反之亦然）
2.查询节点v到所有当前红点的带权距离之和S。。
请对所有查询操作输出对应结果。
【名词解释】：
●带权距离：带权距离指路径上所有边权的总和。
输入描述
第一行输入两个整数n，g(1≤n，q2x10)，分别表示节点数和操作数。
第二行输入n个整数c1，C2,···,CnE(0,1)，其中c;=1表示第i个节点初始为红点，C=0表示非红点。
接下来n一1行，每行输入三个整数ui,Vi，w;(1ui,u;n,ui+vi,1w;≤10)，表示一条无向带权边。
随后q行，每行输入两个整数t和v(t€{1,2），1un)，表示一次操作。
保证所有输入的边构成一棵树，并且至少存在一个操作2。
 */

import java.util.*;

public class BISHI3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] RedOrNot = new int[n];
        for (int i = 0; i < n; i++) {
            RedOrNot[i] = sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> weight = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int ui = sc.nextInt();
            int vi = sc.nextInt();
            int wi = sc.nextInt();
            list.get(ui).add(vi);
            list.get(vi).add(ui);
            weight.put(ui, vi);
        }
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        parent[1] = -1;
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : list.get(u)) {
                if(parent[v] ==-1&& v!=parent[u]) {
                    parent[v] = u;
                    queue.add(v);
                }
            }
        }

        while(q-- > 0) {
            int t = sc.nextInt();
            int v = sc.nextInt();
            if (t == 1) {
                int index = v - 1;
                RedOrNot[index] = RedOrNot[index] == 0 ? 1 : 0;
            }else {

            }
        }
    }
}
