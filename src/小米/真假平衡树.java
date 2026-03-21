package 小米;

import java.util.Scanner;

public class 真假平衡树 {
    static int[] leftChild;
    static int[] rightChild;
    static boolean isBalanced;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n =  sc.nextInt();
            leftChild = new int[n+1];
            rightChild = new int[n+1];
            for (int i = 1; i <= n; i++) leftChild[i] = sc.nextInt();
            for (int i = 1; i <= n; i++) rightChild[i] = sc.nextInt();
            isBalanced = true;
            dfs(1);
            System.out.println(isBalanced ? "YES" : "NO");
        }
    }

    static int dfs(int u){
        // 后序遍历
        if(!isBalanced){
            return 0;
        }
        int hL = (leftChild[u] == -1)? 0: 1 + dfs(leftChild[u]);
        int hR = (rightChild[u] == -1)? 0: 1 + dfs(rightChild[u]);

        if(Math.abs(hL - hR) > 2){
            isBalanced = false;
        }

        int currentH = 0;
        if (leftChild[u] != -1) currentH = Math.max(currentH, hL);
        if (rightChild[u] != -1) currentH = Math.max(currentH, hR);

        return currentH;
    }
}
