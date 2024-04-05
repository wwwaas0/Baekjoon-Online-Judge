package Silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strNumbers = br.readLine().split("-");
        int[] intNumbers = new int[strNumbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            String[] elements = strNumbers[i].split("\\+");
            int sum = 0;
            for (String element : elements) {
                sum += Integer.parseInt(element);
            }
            intNumbers[i] = sum;
        }

        int answer = intNumbers[0];
        for (int i = 1; i < intNumbers.length; i++) {
            answer -= intNumbers[i];
        }
        System.out.println(answer);
    }
}
