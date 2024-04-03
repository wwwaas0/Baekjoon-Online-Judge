package Silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 이진 탐색
 */
public class Main_2343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] lectures = new int[N];
        st = new StringTokenizer(br.readLine());

        lectures[0] = Integer.parseInt(st.nextToken());
        int start = lectures[0];
        int end = 0;
        for (int i = 1; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            if (start < lectures[i]) {
                start = lectures[i];
            }
            end = end + lectures[i];
        }

        //블루레이 크기의 최솟값 찾기
        while (start <= end) {
            int middle = (start + end) / 2;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (sum + lectures[i] > middle) {
                    sum = 0;
                    count++;
                }
                sum += lectures[i];
            }

            if (sum > 0) count++;
            if (count > M) start = middle + 1; //주어진 블루레이 개수를 넘었을 때 start 증가
            else end = middle - 1; //아니면 계속 end 값 감소
        }

        System.out.println(start);
    }

}