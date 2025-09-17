package NiuKe;

import sun.awt.windows.WPrinterJob;

import java.util.*;

public class BISHI52 {
    public static void answer(Set<Student> arr) {
        for (Student s : arr) {
            System.out.print(s.id + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int s = sc.nextInt();
        int[] a_list = new int[n];
        int[] b_list = new int[n];
        for (int i = 0; i < n; i++) a_list[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b_list[i] = sc.nextInt();

        List<Student> students = new ArrayList<>();
        //先将这两个大堆添加student
        for (int i = 0; i < n; i++) {
            students.add(new Student(i + 1, a_list[i], b_list[i]));
        }

        students.sort((s1, s2) -> s2.ai - s1.ai);

        //先默认按照编程高的进编程队
        Set<Student> programTeam = new HashSet<>();
        for (int i = 0; i < p; i++) {
            Student stu = students.get(i);
            stu.status = "program";
            programTeam.add(stu);
        }

        //计算初始的总分
        int total_score = programTeam.stream().mapToInt(stu -> stu.ai).sum();

        //按照编程成绩排序，但没在编程队中，作为编程队替补
        PriorityQueue<Student> pq_a_unselected = new PriorityQueue<>((a, b) -> b.ai - a.ai);
        //在编程队中，按照bi-ai降序（交换价值）
        PriorityQueue<Student> pq_swap_selected = new PriorityQueue<>((a, b) -> (b.bi - b.ai) - (a.bi - a.ai));
        //未入选学生，按照bi降序
        PriorityQueue<Student> pq_b_unselected = new PriorityQueue<>((a, b) -> (b.bi - a.bi));

        //初始化队列数据
        for (Student stu : students) {
            if (stu.status.equals("unselected")) {
                pq_a_unselected.add(stu);
                pq_b_unselected.add(stu);
            } else {
                pq_swap_selected.add(stu);
            }
        }

        Set<Student> sportsTeam = new HashSet<>();
        for (int round = 0; round < s; round++) {
            //已被选中的学生需要移除
            while (!pq_b_unselected.isEmpty()) {
                Student top = pq_b_unselected.peek();
                if (!top.status.equals("unselected")) {
                    pq_b_unselected.poll();
                } else {
                    break;
                }
            }
            while (!pq_a_unselected.isEmpty()) {
                Student top = pq_a_unselected.peek();
                if (!top.status.equals("unselected")) {
                    pq_a_unselected.poll();
                } else {
                    break;
                }
            }
            // 移除已经离开编程队的学生
            while (!pq_swap_selected.isEmpty()) {
                Student top = pq_swap_selected.peek();
                if (!top.status.equals("program")) {
                    pq_swap_selected.poll();
                } else {
                    break;
                }
            }
            int gain1 = -1;
            if (!pq_b_unselected.isEmpty()) {
                gain1 = pq_b_unselected.peek().bi;
            }
            int gain2 = -1;
            if (!pq_swap_selected.isEmpty() && !pq_a_unselected.isEmpty()) {
                Student swap_out = pq_swap_selected.peek();
                Student swap_in = pq_a_unselected.peek();
                gain2 = swap_out.bi - swap_out.ai + swap_in.ai;
            }
            if (gain1 >= gain2 && gain1 != -1) {
                Student selected = pq_b_unselected.poll();
                selected.status = "sports";
                sportsTeam.add(selected);
                total_score += gain1;
            } else if (gain2 != -1) {
                Student swap_out = pq_swap_selected.poll();
                Student swap_in = pq_a_unselected.poll();

                swap_out.status = "sports";
                swap_in.status = "program";

                programTeam.remove(swap_out);
                programTeam.add(swap_in);
                sportsTeam.add(swap_out);

                total_score += gain2;

                pq_swap_selected.add(swap_in);
            }
        }

        System.out.println(total_score);
        answer(programTeam);
        System.out.println();
        answer(sportsTeam);
    }
}

class Student {
    int id;
    int ai;
    int bi;
    String status;

    public Student(int id, int ai, int bi) {
        this.id = id;
        this.ai = ai;
        this.bi = bi;
        this.status = "unselected";
    }
}
