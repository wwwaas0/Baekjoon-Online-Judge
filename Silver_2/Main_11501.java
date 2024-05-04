package Silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] price = new int[N];
            for (int j = 0; j < N; j++) {
                price[j] = Integer.parseInt(st.nextToken());
            }

            int max = price[N - 1];
            long total = 0;
            for (int j = N - 2; j >= 0; j--) {
                //해당 날짜에 주식사서 max에 팔았을 때의 수익 더하기
                if (price[j] < max) total += (max - price[j]);
                else if (price[j] > max) max = price[j];
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }
}
