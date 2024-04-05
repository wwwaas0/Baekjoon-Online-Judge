package Silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strNumbers = br.readLine().split("-");

        int answer = 0;
        for (int i = 0; i < strNumbers.length; i++) {
            String[] elements = strNumbers[i].split("\\+");
            int sum = 0;
            for (String element : elements) {
                sum += Integer.parseInt(element);
            }

            if(i==0) answer = sum;
            else answer -= sum;
        }

        System.out.println(answer);
    }
}
