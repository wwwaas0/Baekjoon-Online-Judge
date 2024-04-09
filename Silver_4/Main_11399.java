package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p);

        int[] time = new int[N];
        time[0] = p[0];
        int totalTime = time[0];
        for (int i = 1; i < N; i++) {
            time[i] = time[i - 1] + p[i];
            totalTime += time[i];
        }
        System.out.println(totalTime);
    }
}
