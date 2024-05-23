package Silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_17391 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][M];
        Deque<int[]> queue = new ArrayDeque<>();

        int[] dx = {1, 0};
        int[] dy = {0, 1};
        int count = 0;

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int q = queue.size();
            count++;

            for (int j = 0; j < q; j++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                int booster = map[row][col];

                for (int i = 0; i < 2; i++) {
                    for (int k = 1; k <= booster; k++) {
                        int cx = row + dx[i] * k;
                        int cy = col + dy[i] * k;

                        if (cx >= N || cy >= M) break;
                        if (!visited[cx][cy]) {
                            visited[cx][cy] = true;
                            queue.offer(new int[]{cx, cy});
                            if (cx == N - 1 && cy == M - 1) {
                                System.out.println(count);
                                return;
                            }

                        }
                    }
                }
            }

        }

    }
}
