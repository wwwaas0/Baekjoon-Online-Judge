package Silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        String str;

        int count = 1;
        while (A < B) {
            str = String.valueOf(B);

            if (str.charAt(str.length() - 1) != '1' && B % 2 != 0) {
                sb.append(-1);
                break;
            }

            if (B % 2 == 0) B = B / 2;
            else if (B % 2 == 1) B = (B - 1) / 10;

            count++;
        }

        if(sb.isEmpty()){
            if (count == 1) sb.append(-1);
            else sb.append(A == B ? count : -1);
        }
        System.out.println(sb);
    }
}
