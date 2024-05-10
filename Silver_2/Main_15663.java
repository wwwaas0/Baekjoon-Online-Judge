package Silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15663 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] numbers, answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[m];

        numbers = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        backTracking(0);
        System.out.println(sb);
    }

    private static void backTracking(int index) {
        if (index == m) {
            for (int a : answer) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && before != numbers[i]) {
                visited[i] = true;
                before = numbers[i];
                answer[index] = numbers[i];
                backTracking(index + 1);
                visited[i] = false;
            }
        }
    }
}
