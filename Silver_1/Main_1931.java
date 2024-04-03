package Silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] conferences = new int[N][2];
        int count = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            conferences[i][0] = startTime;
            conferences[i][1] = endTime;
        }
        br.close();

        //회의 종료 시간 빠른순으로, 시작 시간 빠른 순으로
        Arrays.sort(conferences, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) { //o1, o2에는 각 행이 들어감
                if (o1[1] == o2[1]) { //회의 종료 시간이 같은 경우
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int preEndTime = 0;
        for (int j = 0; j < N; j++) {
            if (preEndTime <= conferences[j][0]) {
                count++;
                preEndTime = conferences[j][1];
            }
        }
        System.out.println(count);
    }
}
