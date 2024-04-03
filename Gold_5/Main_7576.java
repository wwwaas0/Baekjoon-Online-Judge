package Gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_7576 {
    static int[][] tomato;
    static int totalRipeTomato;
    static int M;
    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        List<int[]> ripeTomato = new ArrayList<>();
        tomato = new int[N][M];
        totalRipeTomato = N * M;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == -1) {
                    totalRipeTomato--;
                } else if (tomato[i][j] == 1) {
                    int[] ripe = new int[2];
                    ripe[0] = j;
                    ripe[1] = i;
                    ripeTomato.add(ripe);
                    totalRipeTomato--;
                }
            }
        }

        if (totalRipeTomato == 0) {
            System.out.println(0);
        } else {
            BFS(ripeTomato);
        }
    }

    private static void BFS(List<int[]> startNodes) {
        Deque<int[]> deque = new ArrayDeque<>();
        int currentRipeTomato = 0;
        int day = -1;

        for (int[] startNode : startNodes) {
            deque.offer(startNode);
        }

        int size;
        while ((size = deque.size()) != 0) {
            for (int i = 0; i < size; i++) {
                int[] visit = deque.pollFirst();
                for (int j = 0; j < 4; j++) {
                    int currentX = visit[0] + dx[j];
                    int currentY = visit[1] + dy[j];

                    if (currentY >= 0 && currentX >= 0 && currentX < M && currentY < N) {
                        if (tomato[currentY][currentX] == 0) {
                            tomato[currentY][currentX] = 1;
                            currentRipeTomato++;

                            int[] coordinate = new int[2];
                            coordinate[0] = currentX;
                            coordinate[1] = currentY;
                            deque.offerLast(coordinate);
                        }
                    }
                }
            }
            day++;
        }
        if (currentRipeTomato == totalRipeTomato) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }

    }
}
