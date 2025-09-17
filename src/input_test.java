import java.util.Scanner;

public class input_test {
    public static void main(String[] args) {
        test3();
    }
    // 全都是数字的输入，每行数字个数不定
    public static void test1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            int sum = 0;
            for (String s : arr) {
                int x = Integer.parseInt(s);
                sum += x;
            }
            System.out.println(sum);
        }
    }
    // 每行的第一个数字为数字n，后面跟n个数字
    public static void test2() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }
    //  每行确定有n个数字的情况
    public static void test3(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += Integer.parseInt(arr[i]);
            }
            System.out.println(sum);
        }
    }
}
