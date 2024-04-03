package Silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String roomNum = br.readLine();
        roomNum = roomNum.replace('9','6');

        String[] input = roomNum.split("");
        int biggest = 1;
        for (int i = 0; i < input.length; i++) {
            int count = 1;
            for (int j = i + 1; j < input.length; j++) {
                if (input[i].equals(input[j])) {
                    count++;
                }
            }
            if(input[i].equals("6")){
                count = (int) Math.ceil(count/2.0);
            }
            if (biggest < count) {
                biggest = count;
            }
        }
        System.out.println(biggest);
    }
}
