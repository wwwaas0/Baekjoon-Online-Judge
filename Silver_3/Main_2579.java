package Silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stairNumber = Integer.parseInt(br.readLine());
        int[] point = new int[stairNumber + 1];
        int[] dp = new int[stairNumber + 1]; //각 인덱스 계단까지 밟았을 때 최대 점수
        for (int i = 1; i <= stairNumber; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = point[1];
        if (stairNumber > 1) dp[2] = point[1] + point[2];

        for (int i = 3; i <= stairNumber; i++) {
            //현재 계단을 밟는 경우
            //전계단을 밟고 현재 밟기 //전전 계단을 밟고 현재 밟기
            dp[i] = point[i] + Math.max(point[i - 1] + dp[i - 3], dp[i - 2]);
        }
        System.out.println(dp[stairNumber]);
    }
}