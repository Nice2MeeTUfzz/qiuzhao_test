package NiuKe;

import java.util.*;
public class BISHI31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int count = 0;
        while(m >0 || n >0){
            if ((m & 1) != (n & 1)) {
                count++;
            }
            m >>>= 1;
            n >>>= 1;
        }
        System.out.println(count);
    }
}
