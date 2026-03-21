package 小米;

import java.util.Scanner;

public class 宇宙能量项链 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 1; i < n-1; i++){
            res += getCount(arr,i);
        }
        System.out.println(res);
    }
    static int getCount(int[] arr, int index){
        int left = 0;
        int right = 0;
        for(int i = 0;i<arr.length;i++){
            if (i < index && arr[i] < arr[index]) {
                left++;
            }else if(i> index && arr[i] > arr[index]){
                right++;
            }
        }
        return left * right;
    }
}
