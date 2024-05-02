package Gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[] visited = new boolean[26];
    static int R, C;
    static char[][] board;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                board[i][j] = str[j].charAt(0);
            }
        }
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int row, int col, int count) {
        char start = board[row][col];
        visited[start - 'A'] = true;
        for (int i = 0; i < 4; i++) {
            int cx = row + dx[i];
            int cy = col + dy[i];

            if (cx >= 0 && cx < R && cy >= 0 && cy < C) {
                char next = board[cx][cy];
                if (!visited[next - 'A']) {
                    dfs(cx, cy, count + 1);
                    visited[next - 'A'] = false;
                }
            }
        }
        max = Math.max(max, count);
    }
}
