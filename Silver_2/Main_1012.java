package Silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012 {
    static int count;
    static int[][] cabbages;
    static boolean[][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //test case 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //배추밭 가로 길이
            N = Integer.parseInt(st.nextToken()); //배추밭 세로 길이
            int K = Integer.parseInt(st.nextToken()); //배추 위치 개수

            cabbages = new int[M][N];
            visit = new boolean[M][N];
            //visit 2차원 배열 선언
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbages[x][y] = 1;
            }

            //양배추가 있고, 방문하지 않은 곳 찾았을 때
            // 해당 좌표를 dfs로 전달, count 증가
            count = 0;
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (cabbages[x][y] == 1 && !visit[x][y]) {
                        DFS(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void DFS(int x, int y) {
//      방문한 좌표 x, y의 visit 배열 값을 true로 변경
        visit[x][y] = true;
//        방문 좌표 상하좌우를 살핀다.
//        currentX, Y에 각각 상하좌우를 의미하는 좌표 넣기
        for (int i = 0; i < 4; i++) {
            int currentX = x + dx[i];
            int currentY = y + dy[i];

//        currentX, currentY가 0~M,N의 범위를 넘지 않게 하고,
            if (currentX >= 0 && currentY >= 0 && currentX < M && currentY < N) {
                if (!visit[currentX][currentY] && cabbages[currentX][currentY] == 1) {
                    //현재 좌표에 방문한적 없음 && 양배추 존재한다면 해당 좌표를 dfs로 전달.
                    DFS(currentX, currentY);
                }
            }
        }


    }
}
