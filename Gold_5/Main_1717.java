package Gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1717 {
    static int[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        node = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            node[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (command == 0) union(a, b);
            else {
                //a, b가 같은 집합인지 확인
                //같은 대표 노드를 가지고 있는지
                a = find(a);
                b = find(b);
                if (a == b) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        //a, b 집합 합치기
        a = find(a);
        b = find(b);
        if (a != b) node[b] = a;
    }

    private static int find(int a) {
        //대상 노드의 대표 노드 찾기
        //그래프 정리
        if (node[a] == a) return a;
        else return node[a] = find(node[a]); //재귀에서 나오면서 정리
    }
}
