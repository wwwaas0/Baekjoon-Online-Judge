package Silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1260 {
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken()); //방문 시작점

        nodes = new ArrayList[N + 1];
        for (int j = 1; j <= N; j++) {
            nodes[j] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].add(b);
            nodes[b].add(a);
        }

        for (int j = 1; j <= N; j++) {
            Collections.sort(nodes[j]);
        }

        visited = new boolean[N + 1];
        DFS(V);
        sb.append("\n");

        visited = new boolean[N + 1];
        BFS(V);
        System.out.println(sb);
    }

    static void DFS(int start) {
        sb.append(start + " ");
        visited[start] = true;

        for (int node : nodes[start]) {
            if(!visited[node]){
                DFS(node);
            }
        }
    }

    static void BFS(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int out = queue.poll();
            sb.append(out + " ");

            for (int node : nodes[out]) {
                if (!visited[node]) {
                    queue.offer(node);
                    visited[node] = true;
                }
            }
        }
    }
}
