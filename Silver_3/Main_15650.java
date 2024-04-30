package Silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650 {
    static int N, M;
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        answer = new int[M + 1];
        answer[0] = 1;
        func(1);
        System.out.println(sb);
    }

    private static void func(int index) {
        if (index > M) {
            for (int i = 1; i <= M; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = answer[index - 1]; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            answer[index] = i;
            func(index + 1);
            visited[i] = false;

        }
    }
}
