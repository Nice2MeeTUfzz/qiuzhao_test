package 叠纸831;

import java.util.*;
public class CourseSchedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        input = input.replaceAll("[^0-9]", " ");
        String[] numStrs = input.split(" +");
        List<Integer> nums = new ArrayList<>();
        for (String s : numStrs) {
            if(!s.isEmpty())
                nums.add(Integer.parseInt(s));
        }
        int num = nums.get(0);

        List<int[]> processList = new ArrayList<>();
        for (int i = 1; i + 1 < nums.size(); i += 2) {
            int a = nums.get(i);
            int b = nums.get(i + 1);
            processList.add(new int[]{a, b});
        }
        int[][] prerequisites = processList.toArray(new int[0][]);
        int[] result = findOrder(num, prerequisites);
        System.out.println(Arrays.toString(result));
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adjacency.get(prerequisite).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()){
            int currCourse = queue.poll();
            result[index++] = currCourse;

            for (int nextCourse : adjacency.get(currCourse)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        return index == numCourses ? result : new int[0];
    }

}
