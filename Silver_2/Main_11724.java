package Silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_11724 {
    static ArrayList<Integer>[] nodes;
    static boolean[] visit;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        nodes = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            nodes[u].add(v);
            nodes[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(nodes[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void DFS(int startNode) {
        visit[startNode] = true;

        for (int node : nodes[startNode]) {
            if (!visit[node]) {
                DFS(node);
            }
        }
    }
}
