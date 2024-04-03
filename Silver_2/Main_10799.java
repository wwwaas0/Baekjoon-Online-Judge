package Silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new ArrayDeque<>();

        String[] array = br.readLine().split("");
        int count = 0;
        String preElement = null;

        for (String element : array) {
            if (element.equals(")"))
            {
                deque.pollLast();

                if (preElement.equals("(")) {
                    count += deque.size();

                } else {
                    count++;
                }

            } else {
                deque.offer(element);
            }

            preElement = element;
        }

        System.out.println(count);
    }
}
