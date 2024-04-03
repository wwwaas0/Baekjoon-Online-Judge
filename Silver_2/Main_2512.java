package Silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2512 {
    static int[] budgets;
    static int N;
    static int totalAmount;
    static final int NONE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        budgets = new int[N];
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(budgets);
        totalAmount = Integer.parseInt(br.readLine());

        if (totalAmount >= sum(NONE)) {
            System.out.println(budgets[N - 1]);
            return;
        }

        int start = 1;
        int end = budgets[N - 1];
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            int sum = sum(mid);
            if (totalAmount > sum) start = mid + 1;
            else if (totalAmount < sum) end = mid - 1;
            else break;
        }
        System.out.println((start + end) / 2);
    }

    private static int sum(int upperLimit) {
        int sum = 0;
        if (upperLimit == NONE) {
            for (int i = 0; i < N; i++) {
                sum += budgets[i];
            }
            return sum;
        }

        for (int i = 0; i < N; i++) {
            int budget = budgets[i];
            if (budget > upperLimit) {
                budget = upperLimit;
            }
            sum += budget;
        }

        return sum;
    }
}

