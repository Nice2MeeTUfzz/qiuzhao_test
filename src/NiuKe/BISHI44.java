package NiuKe;
import java.util.*;

public class BISHI44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ji = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            if (s % 2 == 1) {
                ji.add(s);
            } else {
                count += s;
            }
        }
        Collections.sort(ji);
        if (ji.size() % 2 == 0) {
            for (int j = 0; j < ji.size(); j++) {
                count += ji.get(j);
            }
        }else {
            for (int j = 1; j < ji.size(); j++) {
                count += ji.get(j);
            }
        }
        System.out.println(count);
    }
}
