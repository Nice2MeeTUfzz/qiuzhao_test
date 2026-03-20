package 小米;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 字符串迭代 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            // 字符串长度
            int n = sc.nextInt();
            // 字符集大小
            int m = sc.nextInt();
            // 字符集
            String zfj_ = sc.next();
            // 字符串s
            String s = sc.next();
            // 迭代次数
            int q = sc.nextInt();
            List<StringBuilder> list = new ArrayList<StringBuilder>();
            for (int j = 0; j < q; j++) {
                // 每一轮迭代
                String zfj = sc.nextLine();
                HashMap<Character, Integer> map = new HashMap<>();
                // 将字符集中的字母和优先级排进 map 中，value越低优先级越高
                for(int k = 0; k < zfj.length(); k++) {
                    char c = zfj.charAt(k);
                    map.put(c, k);
                }
                StringBuilder sb = new StringBuilder();
                int start = 0;
                int index = 0;
                while(start < n){
                    if(map.get(s.charAt(start)) < map.get(s.charAt(index))){
                        index++;
                    }else{
                        sb.append(s.charAt(start));

                    }
                }
            }
        }
    }
}
