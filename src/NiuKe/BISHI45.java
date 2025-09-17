package NiuKe;

import java.util.*;

public class BISHI45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        char[][] lists = new char[n][m];
        for (int i = 0; i < n; i++) {
            lists[i] = sc.next().toCharArray();
        }

        List<Integer> blockLength = new ArrayList<>();

        for (int j = 0; j < m; j++) {
            int currentBlock = 0;
            for (int i = 0; i < n; i++) {
                if (lists[i][j] == 'o') {
                    currentBlock++;
                }else {
                    if (currentBlock >= 2) {
                        blockLength.add(currentBlock);
                    }
                    currentBlock = 0;
                }
            }
            if (currentBlock >= 2) {
                blockLength.add(currentBlock);
            }
        }
        Collections.sort(blockLength, Collections.reverseOrder());

        int score = 0;
        for(int length: blockLength) {
            if (k == 0) {
                break;
            }
            int cellsToDye = Math.min(length, k);

            if (cellsToDye >= 2) {
                score += cellsToDye - 1;
            }
            k -= cellsToDye;
        }
        System.out.println(score);
    }
}
