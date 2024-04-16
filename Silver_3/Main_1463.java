package Silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463 {
    /**
     * 바텀-업 구현 방식
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //dp[2]는 N이 2일때의 연산 횟수 최솟값
        int[] dp = new int[N + 1];
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; //-1 연산
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1); //2로 나눠떨어짐
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1); //3으로 나눠떨어짐
        }
        System.out.println(dp[N]);
    }

    /**
     * 톱-다운 구현 방식
     */
//    static int[] dp;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        dp = new int[N + 1]; //각 인덱스 == n일때 최소 횟수
//
//        for (int i = 2; i <= N; i++) {
//            dp[i] = -1;
//        }
//        dp[1] = 0;
//        System.out.println(dfs(N));
//    }
//
//    private static int dfs(int n) {
//        if (dp[n] == -1) { //dp에 해당값이 저장 안된 경우
//            dp[n] = dfs(n - 1) + 1;
//            if (n % 2 == 0) dp[n] = Math.min(dp[n], dfs(n / 2) + 1);
//            if (n % 3 == 0) dp[n] = Math.min(dp[n], dfs(n / 3) + 1);
//        }
//        return dp[n];
//    }
}
