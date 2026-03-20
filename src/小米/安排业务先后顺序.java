package 小米;
// </https://codefun2000.com/p/P4606>
import java.util.*;

class 安排业务先后顺序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Person[] persons = new Person[n];
        for (int i = 0; i < n; i++) {
            long time = sc.nextLong();
            long addTime = sc.nextLong();
            Person person = new Person(time, addTime);
            persons[i] = person;
        }

        Arrays.sort(persons, (a,b)->{
            long val1 = a.time * b.addTime;
            long val2 = b.time * a.addTime;
            return Long.compare(val1, val2);
        });
        long currentTime = 0; // 营业员已经忙碌的时间
        long totalTime = 0; // 总时间
        for(Person p : persons) {
            long waitTime = currentTime;
            long serviceTime = p.time + waitTime * p.addTime;
            totalTime = (serviceTime + waitTime);
            currentTime += serviceTime;
        }
        System.out.println(totalTime);
    }
}

class Person {
    long time;
    long addTime;

    public Person(long time, long addTime) {
        this.time = time;
        this.addTime = addTime;
    }
}
