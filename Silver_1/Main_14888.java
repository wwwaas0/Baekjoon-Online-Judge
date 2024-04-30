package Silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888 {
    static int[] sequence, operation;
    static int N;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        sequence = new int[N];
        operation = new int[4];

        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        func(0, sequence[0]);
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    private static void func(int index, int previousResult) {
        if (index == N - 1) {
            //최소 or 최대값인지 판단
            max = Math.max(previousResult, max);
            min = Math.min(previousResult, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int result = 0;
            if (operation[i] > 0) {
                operation[i]--;

                switch (i) {
                    case 0:
                        result = previousResult + sequence[index + 1];
                        break;
                    case 1:
                        result = previousResult - sequence[index + 1];
                        break;
                    case 2:
                        result = previousResult * sequence[index + 1];
                        break;
                    case 3:
                        if (previousResult < 0) {
                            previousResult = 0 - previousResult;
                            result = 0 - (previousResult / sequence[index + 1]);
                        } else {
                            result = previousResult / sequence[index + 1];
                        }
                        break;
                }
                func(index + 1, result);
                operation[i]++;
            }
        }

    }
}
