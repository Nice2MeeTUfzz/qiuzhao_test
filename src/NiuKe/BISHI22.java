package NiuKe;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BISHI22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int m = in.nextInt();
        Applicant[] applicants = new Applicant[n];
        for (int i = 0; i < n; i++) {
            applicants[i] = new Applicant(in.nextInt(), in.nextInt());
        }
        Arrays.sort(applicants, new Comparator<Applicant>() {
            @Override
            public int compare(Applicant o1, Applicant o2) {
                if (o1.score != o2.score) {
                    return o2.score - o1.score;
                }
                return o1.id - o2.id;
            }
        });

        int t = (int) (1.5 * m);
        int scoreLine = applicants[t - 1].score;

        int qucount = 0;
        for (Applicant applicant : applicants) {
            if (applicant.score >= scoreLine) {
                qucount++;
            } else {
                break;
            }
        }

        System.out.println(scoreLine + " " + qucount);
        for (int i = 0; i < qucount; i++) {
            System.out.println(applicants[i].id + " " + applicants[i].score);
        }
    }
}

class Applicant {
    int id;
    int score;

    public Applicant(int id, int score) {
        this.id = id;
        this.score = score;
    }
}
