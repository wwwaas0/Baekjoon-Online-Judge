package Silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //배열 개수
        int M = Integer.parseInt(st.nextToken()); //구해야하는 합의 개수

        st = new StringTokenizer(br.readLine());
        List<Integer> arraySum = new ArrayList<>();
        int sum = 0;
        for (int a = 0; a < N; a++) {
            sum += Integer.parseInt(st.nextToken());
            arraySum.add(sum);
        }

        for (int b = 0; b < M; b++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if (i == 1) {
                System.out.println(arraySum.get(j - 1));
            } else {
                System.out.println(arraySum.get(j - 1) - arraySum.get(i - 2));
            }
        }
    }
}
