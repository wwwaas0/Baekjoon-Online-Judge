package Gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] lectures = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] time = new int[2];
            time[0] = Integer.parseInt(st.nextToken());
            time[1] = Integer.parseInt(st.nextToken());
            lectures[i] = time;
        }

        Arrays.sort(lectures, (o1, o2) -> {
            int start1 = o1[0];
            int start2 = o2[0];

            if (start1 == start2) return o1[1] - o2[1];
            return start1 - start2;
        });

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.offer(lectures[0][1]);
        for (int i = 1; i < N; i++) {
            if (lectures[i][0] >= endTimes.peek()) endTimes.poll();
            endTimes.offer(lectures[i][1]);
        }

        System.out.println(endTimes.size());
    }
}

