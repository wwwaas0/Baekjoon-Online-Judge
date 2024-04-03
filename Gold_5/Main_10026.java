package Gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026 {
    static int[] directionX = {1, -1, 0, 0};
    static int[] directionY = {0, 0, 1, -1};
    static boolean[][] visit;
    static String[][] nodes;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        nodes = new String[N][N];

        for (int i = 0; i < N; i++) {
            String[] sp = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                nodes[i][j] = sp[j];
            }
        }

        visit = new boolean[N][N];
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    count++;
                    dfsNonBlind(i, j, nodes[i][j]);
                }
            }
        }
        sb.append(count + " ");

        visit = new boolean[N][N];
        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    count++;
                    dfsBlind(i, j, nodes[i][j]);
                }
            }
        }
        sb.append(count);
        System.out.println(sb);

    }

    private static void dfsNonBlind(int startX, int startY, String color) {
        visit[startX][startY] = true;
        for (int i = 0; i < 4; i++) {
            int currentX = startX + directionX[i];
            int currentY = startY + directionY[i];
            if (currentX >= 0 && currentY >= 0 && currentX < N && currentY < N) {
                if (color.equals(nodes[currentX][currentY]) && !visit[currentX][currentY]) {
                    dfsNonBlind(currentX, currentY, color);
                }
            }
        }
    }

    private static void dfsBlind(int startX, int startY, String color) {
        visit[startX][startY] = true;
        if (color.equals("R")) {
            color = "G";
        }

        for (int i = 0; i < 4; i++) {
            int currentX = startX + directionX[i];
            int currentY = startY + directionY[i];
            if (currentX >= 0 && currentY >= 0 && currentX < N && currentY < N) {
                if (!visit[currentX][currentY]
                        && ((color.equals(nodes[currentX][currentY])) || (color.equals("G") && nodes[currentX][currentY].equals("R")))) {
                    dfsBlind(currentX, currentY, nodes[currentX][currentY]);
                }
            }
        }
    }
}
