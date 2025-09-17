package NiuKe;

import java.util.*;

public class BISHI54 {
    static class Item {
        long w, v, c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item();
            items[i].w = sc.nextLong();
            items[i].v = sc.nextLong();
            items[i].c = sc.nextLong();
        }

        Arrays.sort(items, (a, b) -> {
            long val = b.w * a.c - a.w * b.c;
            if (val > 0) {
                return -1;
            }
            if (val < 0) {
                return 1;
            }else {
                return 0;
            }
        });

        long totalVolume = 0;
        long weightAbove = 0;
        for(int i=n-1;i>=0;i--){
            totalVolume += items[i].v - weightAbove * items[i].c;
            weightAbove += items[i].w;
        }

        System.out.println(totalVolume);
    }
}
