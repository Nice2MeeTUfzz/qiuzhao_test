package 美团0913;
/*
描述:
给定一个长度为n的数组{a1,a2,...,an}以及一个长度为n的数组{b1,b2,...,bn}
你可以分别对数组a与数组b进行任意重排。设重排后的数组分别为α'和b',记di =ai'-bi'
要求对所有1<i<n,均满足d_{i-1} ≥ d_i ≤ di+1或 d_{i-1} ≤ d_i ≥ d_{i+1}
请输出任意一组满足要求的重排后的数组α'与b'
我们可以证明，答案一定存在

 */

import java.util.*;
public class BISHI2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList();
        ArrayList<Integer> b = new ArrayList();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            b.add(sc.nextInt());
        }
        a.sort(Comparator.reverseOrder());
        b.sort(Comparator.naturalOrder());

        int[] result = new int[n];
        int right = n - 1;
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result[i] = a.get(left) - b.get(left);
                left++;
            }else if (i % 2 == 1) {
                result[i] = a.get(right) - b.get(right);
                right--;
            }
        }
        for (int i = 0; i <5; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
