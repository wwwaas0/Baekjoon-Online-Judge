package Gold_4;

import java.io.*;
import java.util.*;

public class Main_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> cardNumber = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            cardNumber.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (cardNumber.size() > 1) {
            int first = cardNumber.poll();
            int second = cardNumber.poll();
            int sum = first + second;
            answer += sum;
            cardNumber.add(sum);
        }
        System.out.println(answer);
    }
}
