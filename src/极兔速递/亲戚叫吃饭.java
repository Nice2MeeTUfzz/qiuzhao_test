package 极兔速递;

import java.util.Scanner;

//</https://codefun2000.com/p/P3804>
public class 亲戚叫吃饭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        for (int i = 0; i < days; i++) {
            int n = sc.nextInt();   // 亲戚人数
            long k = sc.nextLong(); // 查询的第k次
            long[] ts = new long[n]; // 每个亲戚来的间隔 1，2，3
            long minA = Long.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                ts[j] = sc.nextLong();
                minA = Math.min(minA, ts[j]);
            }
            long left = 1;
            long right = minA * k;
            long targetTime = right;
            while(left<=right){
                long mid = left + (right-left)/2;
                if(check(ts, k, mid)){
                    targetTime = mid;
                    right = mid-1;
                } else{
                    left = mid+1;
                }
            }

            long visitedbefore = 0;
            for(int t = 0;t< n;t++){
                visitedbefore += (targetTime - 1) / ts[t];
            }

            long rem = k - visitedbefore;
            int ans = -1;
            for(int r = 0;r<n;r++){
                if(targetTime % ts[r] == 0){
                    rem--;
                    if(rem == 0){
                        ans = r + 1;
                        break;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    //在时间t内，总访问次数是否>=k
    static boolean check(long[] nums, long k, long t) {
        long res = 0;
        for(long interval: nums){
            res+= t/ interval;
            if(res >=k){
                return true;
            }
        }
        return false;
    }
}
