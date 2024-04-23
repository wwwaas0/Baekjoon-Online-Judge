package Silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149 {
    final static int red = 0;
    final static int green = 1;
    final static int blue = 2;
    static int[][] costRGB, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        costRGB = new int[N][3];
        dp = new int[N][3]; //각 인덱스별 집까지 칠했을 때, 색깔별로 최소 비용
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            costRGB[i][red] = Integer.parseInt(st.nextToken());
            costRGB[i][green] = Integer.parseInt(st.nextToken());
            costRGB[i][blue] = Integer.parseInt(st.nextToken());
        }

        dp[0][red] = costRGB[0][red];
        dp[0][green] = costRGB[0][green];
        dp[0][blue] = costRGB[0][blue];

        for (int i = 1; i < N; i++) {
            dp[i][red] = costRGB[i][red] + Math.min(dp[i - 1][green], dp[i - 1][blue]);
            dp[i][green] = costRGB[i][green] + Math.min(dp[i - 1][red], dp[i - 1][blue]);
            dp[i][blue] = costRGB[i][blue] + Math.min(dp[i - 1][red], dp[i - 1][green]);
        }
        System.out.println(Math.min(dp[N - 1][red], Math.min(dp[N - 1][green], dp[N - 1][blue])));
    }
}
