package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        while (N % 5 != 0 && N >= 0) {
            N -= 3;
            count++;
        }

        if (N < 0) {
            System.out.println(-1);
        } else {
            System.out.println(count + N / 5);
        }
    }
}
