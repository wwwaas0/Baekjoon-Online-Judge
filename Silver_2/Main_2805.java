package Silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); //상근이가 가져가려고 하는 나무 길이의 최소 합

        st = new StringTokenizer(br.readLine());
        int tall = 0;
        int[] height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            if (tall < height[i]) tall = height[i];
        }

        int start = 0;
        int end = tall;
        int middle = 0;
        long sum = 0;

        while (start <= end) {
            middle = (start + end) / 2;
            sum = sum(middle, height);
            if (sum >= M) start = middle + 1;
            else if (sum < M) end = middle - 1;
        }
        System.out.println(end);
    }

    private static long sum(int height, int[] trees) {
        long sum = 0;
        for (int tree : trees) {
            if (tree > height) sum += tree - height;
        }
        return sum;
    }
}
