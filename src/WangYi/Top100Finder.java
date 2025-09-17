package WangYi;

import java.util.Arrays;
import java.util.Random;

public class Top100Finder {
    public static void main(String[] args) {
        int[] data = generateRandomNumbers(1000, 0, 10000);
        System.out.println("原始数据（前十个）:" + Arrays.toString(Arrays.copyOf(data, 10)));
        int[] top100 = findTop100(data, 100);
        System.out.println("最大的100个数（前十个）:" + Arrays.toString(Arrays.copyOf(top100, 10)));
    }


    public static int[] findTop100(int[] data, int k) {
        if (k <= 0 || data == null || data.length == 0) {
            return new int[0];
        }

        int[] minHeap = new int[k];
        System.arraycopy(data, 0, minHeap, 0, k);
        buildMinHeap(minHeap, k);

        for (int i = k; i < data.length; i++) {
            if (data[i] > minHeap[0]) {
                minHeap[0] = data[i];
                heapify(minHeap, 0, k);
            }
        }
        return minHeap;
    }

    private static void buildMinHeap(int[] minHeap, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(minHeap, i, size);
        }
    }

//    private static void heapify(int[] minHeap, int index, int size) {
//        int smallest = index;
//        int left = index * 2 + 1;
//        int right = index * 2 + 2;
//        if (left < size && minHeap[left] < minHeap[smallest]) {
//            smallest = left;
//        }
//        if (right<size && minHeap[right] < minHeap[smallest]) {
//            smallest = right;
//        }
//        if (smallest != index) {
//            int temp = minHeap[index];
//            minHeap[index] = minHeap[smallest];
//            minHeap[smallest] = temp;
//            heapify(minHeap, smallest, size);
//        }
//    }
    private static void heapify(int[] minHeap, int index, int size) {
        int smallest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left <size && minHeap[left]< minHeap[smallest]) {
            smallest = left;
        }
        if (right<size && minHeap[right]< minHeap[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            int temp = minHeap[index];
            minHeap[index] = minHeap[smallest];
            minHeap[smallest] = temp;
            heapify(minHeap, smallest, size);
        }
    }

    private static int[] generateRandomNumbers(int count, int min, int max) {
        int[] numbers = new int[count];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(max - min + 1) + min;
        }
        return numbers;
    }
}
