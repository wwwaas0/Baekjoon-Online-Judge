package Silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            int[][] grades = new int[N][2];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int documentReview = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());

                grades[j][0] = documentReview;
                grades[j][1] = interview;
            }

            //서류 성적 순으로 정렬
            Arrays.sort(grades, (o1, o2) -> {
                return o1[0] - o2[0];
            });

            int minInterview = grades[0][1];
            int count = 1; //서류 1등은 이미 선발 가능
            for (int k = 1; k < N; k++) {
                if (minInterview > grades[k][1]) {
                    count++;
                    minInterview = grades[k][1];
                }
            }

            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}

