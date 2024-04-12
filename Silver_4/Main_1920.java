package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] numbers = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        boolean isExsit;
        for (int number : numbers) {
            int startIndex = 0;
            int endIndex = A.length - 1;

            isExsit = false;
            while (startIndex <= endIndex) {
                int midIndex = (startIndex + endIndex) / 2;

                if (A[midIndex] > number) endIndex = midIndex - 1;
                else if (A[midIndex] < number) startIndex = midIndex + 1;
                else {
                    isExsit = true;
                    break;
                }
            }
            sb.append(isExsit ? 1 : 0).append("\n");

        }
        System.out.println(sb);
    }
}
