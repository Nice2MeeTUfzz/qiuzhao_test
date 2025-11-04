package 邦盛1025;

import java.util.*;
public class BISHI2 {
    // 本题面试官已设置测试用例
    public static String formatDuration(int seconds) {
        // 在这⾥写代码
        if(seconds==0){
            return "now";
        }
        LinkedList list = new LinkedList<String>();
        int seconds_str = seconds % 60;
        list.add(seconds_str+" seconds, ");
        int minutes = seconds / 60;
        if(minutes >=60){
            int minutes_str = minutes%60;
            list.add(minutes_str+" minutes, ");
            int hours = minutes/60;
            if(hours>=24){
                int hours_str = hours%24;
                list.add(hours_str+" hours, ");
                int days = hours / 24;
                if(days>=365){
                    int days_str = days%365;
                    list.add(days_str+" days, ");
                    int year = days/365;
                    list.add(year+" years, ");
                }else{
                    list.add(days+" days, ");
                }
            }else{
                list.add(hours+" hours, ");
            }
        }else{
            list.add(minutes+" minutes, ");
        }
        return list.toString();
    }
    public static void main(String[] args) {
        formatDuration(62);
    }
}
