package Silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_25758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }

        Set<Character> ans = new TreeSet<>();

        for (char x = 'A'; x <= 'Z'; x++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) { // 각 알파벳별 개수 구하기
                if (arr[i].charAt(0) == x) cnt++;
            }

            if (cnt > 1) { // 자기자신과 조합할 걱정 x
                for (int i = 0; i < N; i++) {
                    ans.add(x > arr[i].charAt(1) ? x : arr[i].charAt(1));
                }
            } else if (cnt == 1) { // 자기자신과 조합될 가능성 고려
                for (int i = 0; i < N; i++) {
                    if (arr[i].charAt(0) == x) continue; //자기자신인 경우 패스
                    ans.add(x > arr[i].charAt(1) ? x : arr[i].charAt(1));
                }
            }
        }

        sb.append(ans.size()).append("\n");
        for (char c : ans) {
            sb.append(c).append(" ");
        }
        System.out.println(sb);
    }
}
