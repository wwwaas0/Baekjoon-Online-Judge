package Silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /*
        메모리가 128MB 제한, int: 4바이트
        1000001 * 4 = 4000004 = 4MB이므로 크기가 1000001인 int 배열을 생성한다.
         */
        int[] ices = new int[1000001];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int iceAmount = Integer.parseInt(st.nextToken()); // 얼음의 양
            int coord = Integer.parseInt(st.nextToken()); // 양동이 좌표
            ices[coord] = iceAmount;
        }

        for (int i = 1; i < ices.length; i++) {
            ices[i] += ices[i - 1]; // 얼음 누적 양
        }

        int theMostIce = ices[0];
        int iceSum = 0;
        int slidingRange = K * 2 + 1;
        for (int j = 1; j < ices.length; j++) {
            if (j > slidingRange) {
                iceSum = ices[j] - ices[j - slidingRange];
            } else {
                iceSum = ices[j];
            }

            if (theMostIce < iceSum) {
                theMostIce = iceSum;
            }

        }
        System.out.println(theMostIce);
    }
}
