package Silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int computerNumber = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        ArrayList<Integer>[] nodes = new ArrayList[computerNumber];
        Deque<Integer> queue = new ArrayDeque<>();

        //Boolean은 기본적으로 null로 초기화됨
        //boolean은 false 초기화
        boolean[] visited = new boolean[computerNumber];

        for (int i = 0; i < computerNumber; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a - 1].add(b);
            nodes[b - 1].add(a);
        }

        for (ArrayList<Integer> connectedNodes : nodes) {
            Collections.sort(connectedNodes);
        }

        //BFS
        // 1번 컴퓨터가 바이러스에 걸림
        int out = 1;
        queue.offer(out);
        visited[out - 1] = true;

        while (!queue.isEmpty()) {
            out = queue.poll();
            count++;
            for (int node : nodes[out - 1]) {
                if (!visited[node - 1]) {
                    queue.add(node);
                    visited[node - 1] = true;
                }
            }
        }
        System.out.println(count - 1); //1번 컴퓨터 경우 제외

    }
}
