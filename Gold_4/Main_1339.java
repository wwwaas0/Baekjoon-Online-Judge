package Gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main_1339 {
//    static List<Character> alphabet;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        String[] words = new String[n];
//
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            words[i] = br.readLine();
//            if (max < words[i].length()) max = words[i].length();
//        }
//        String[] wordsCopy = words.clone();
//
//        alphabet = new ArrayList<>();
//        for (int i = max; i > 0; i--) {
//            for (int j = 0; j < n; j++) {
//                if (wordsCopy[j].length() == i) {
//                    alphabet.add(wordsCopy[j].charAt(0));
//                    wordsCopy[j] = wordsCopy[j].substring(1);
//                }
//            }
//        }
//
//        LinkedHashSet<Character> set = new LinkedHashSet<>(alphabet);
//        alphabet = new ArrayList<>(set);
//
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            char[] charArray = words[i].toCharArray();
//            for (int j = 0; j < charArray.length; j++) {
//                charArray[j] = alphabetToNumber(charArray[j]);
//            }
//            String str = new String(charArray);
//            sum += Integer.parseInt(str);
//        }
//        System.out.println(sum);
//    }
//
//    static char alphabetToNumber(char c) {
//        return (char) ((9 - alphabet.indexOf(c)) + '0');
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Character, Integer> charValues = new HashMap<>(); //Map의 key는 중복 허용X
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int pow = 1;
            for (int j = word.length() - 1; j >= 0; j--) {
                char ch = word.charAt(j);

                //각 알파벳, 몇 자리수인지
                //ex) 셋째 자릿수라면, pow == 100
                charValues.put(ch, charValues.getOrDefault(ch, 0) + pow);
                pow *= 10;
            }
        }

        for (Map.Entry<Character, Integer> entry : charValues.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }


        //내림차순 우선 순위 큐
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(charValues.entrySet());

        int value = 9;
        int sum = 0;
        Map<Character, Integer> charToNum = new HashMap<>();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            charToNum.put(entry.getKey(), value--); //각 알파벳당 매치되는 숫자
        }

        for (Map.Entry<Character, Integer> entry : charValues.entrySet()) {
            sum += charToNum.get(entry.getKey()) * entry.getValue();
        }

        System.out.println(sum);
    }

}
