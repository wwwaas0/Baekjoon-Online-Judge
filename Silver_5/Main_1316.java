package Silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGroupWord(word)) {
                count++;
            }
        }
        System.out.println(count);
    }
    private static boolean isGroupWord(String word) {
        Set<String> set = new HashSet<>();
        int count = 0;
        String[] array = word.split("");
        for (int i = 0; i < word.length(); i++) {
            set.add(array[i]);
        }
        for (int i = 0; i < word.length() - 1; i++) {
            if (!array[i].equals(array[i + 1])) {
                count++;
            }
        }
        if (count + 1 == set.size()) {
            return true;
        } else {
            return false;
        }
    }
}
