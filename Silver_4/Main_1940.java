package Silver_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> uniqueNumbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            uniqueNumbers.add(sc.nextInt());
        }

        Collections.sort(uniqueNumbers);

        int count = 0; //갑옷 만들 수 있는 개수
        int firstIndex = 0;
        int secondIndex = N - 1;

        while (firstIndex < secondIndex) {
            int sum = uniqueNumbers.get(firstIndex) + uniqueNumbers.get(secondIndex);

            if (sum < M) {
                firstIndex++;
            } else if (sum > M) {
                secondIndex--;
            } else { //sum == M
                count++;
                firstIndex++;
                secondIndex--;
            }

        }

        System.out.println(count);

    }
}
