package 小米;

import java.util.Scanner;

public class 幸运套圈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 商品数量
        int n = sc.nextInt();
        // 套圈大小
        int L = sc.nextInt();
        int[] likes = new int[n];
        for (int i = 0; i < n; i++) {
            likes[i] = sc.nextInt();
        }
        int maxLike = Integer.MIN_VALUE;
        for(int i = 0;i<= n - L;i++){
            int sum = sumLike(likes, L, i);
            maxLike = Math.max(maxLike, sum);
        }
        System.out.println(maxLike);
    }

    static int sumLike(int[] likes, int L, int start){
        int res = 0;
        for(int j = start;j<= start + L -1;j++){
            res += likes[j];
        }
        return res;
    }
}
