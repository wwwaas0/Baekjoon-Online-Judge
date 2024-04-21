package Silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] amount = new int[N + 1];
        int[] dp = new int[N + 1]; //각 인덱스별 최대 포도주 양

        for (int i = 1; i <= N; i++) {
            amount[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = amount[1];
        if(N > 1) dp[2] = amount[1] + amount[2];

        for (int i = 3; i <= N; i++) {
            //현재 와인 + 전 와인을 마신 경우, 현재 와인 + 전전 와인을 마신 경우 중 최댓값
            int drink = amount[i] + Math.max(amount[i - 1] + dp[i - 3], dp[i - 2]);

            //현재 와인을 마신 경우, 안 마신 경우 중 최댓값
            dp[i] = Math.max(dp[i - 1], drink);
        }

        System.out.println(dp[N]);
    }
}
