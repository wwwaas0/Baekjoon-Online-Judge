package Silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> tempSums = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            tempSums.add(sum);
        }

        int max = tempSums.get(K - 1); //가장 처음의 max값
        for (int startIndex = K; startIndex < tempSums.size(); startIndex++) {

            int endIndex = startIndex - K;
            int sequenceSum = tempSums.get(startIndex) - tempSums.get(endIndex);

            if (max < sequenceSum) {
                max = sequenceSum;
            }
        }

        System.out.println(max);
    }
}
