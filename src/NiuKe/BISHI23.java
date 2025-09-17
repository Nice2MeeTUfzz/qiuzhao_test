package NiuKe;

import java.util.*;
import java.util.ArrayList;


public class BISHI23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> counts = new HashMap<>();

        if (in.hasNextLine()) {
            String[] words = in.nextLine().split(" ");
            for (String word : words) {
                if (!counts.containsKey(word)) {
                    counts.put(word, 1);
                } else {
                    counts.put(word, counts.get(word) + 1);
                }
            }
        }
        List<Keyword> keywords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() >= 3) {
                keywords.add(new Keyword(entry.getKey(), entry.getValue()));

            }
        }

        Collections.sort(keywords,new Comparator<Keyword>() {
            @Override
            public int compare(Keyword o1, Keyword o2) {
                if (o1.count != o2.count) {
                    return Integer.compare(o2.count, o1.count);
                }else {
                    return o1.word.compareTo(o2.word);
                }
            }
        });

        for (Keyword keyword : keywords) {
            System.out.printf("key:%s,value:%d",keyword.word,keyword.count);
        }
    }
}

class Keyword {
    String word;
    int count;

    Keyword(String word, int count) {
        this.word = word;
        this.count = count;
    }
}