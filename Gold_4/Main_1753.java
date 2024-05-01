package Gold_4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1753 {
    static int V, E, K;
    static int[] distance;
    static boolean[] visited;
    static List<Edge>[] list;
    static PriorityQueue<Edge> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        distance = new int[V + 1];
        visited = new boolean[V + 1];
        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v, w));
        }

        queue.offer(new Edge(K, 0));
        distance[K] = 0;
        while (!queue.isEmpty()) {
            Edge currentEdge = queue.poll();
            int currentNode = currentEdge.node;

            //만약 이미 방문한 노드라면 패스
            if(visited[currentEdge.node]) continue;

            visited[currentEdge.node] = true;
            for (Edge e : list[currentEdge.node]) {
                int next = e.node;
                int value = e.weight;
                if(distance[next] > distance[currentNode] + value){
                    distance[next] = distance[currentNode] + value;
                    queue.offer(new Edge(next, distance[next]));
                }
            }

        }

        for (int i = 1; i <= V; i++) {
            sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
        }
        System.out.println(sb);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        int V = Integer.parseInt(st.nextToken());
//        int E = Integer.parseInt(st.nextToken());
//
//        int start = Integer.parseInt(br.readLine());
//        boolean[] visited = new boolean[V + 1];
//        int[] distance = new int[V + 1];
//        Arrays.fill(distance, Integer.MAX_VALUE);
//
//        Map<Integer, Integer>[] map = new Map[V + 1];
//        for (int i = 1; i <= V; i++) {
//            map[i] = new HashMap<>();
//        }
//        for (int i = 0; i < E; i++) {
//            st = new StringTokenizer(br.readLine());
//            int u = Integer.parseInt(st.nextToken());
//            int v = Integer.parseInt(st.nextToken());
//            int w = Integer.parseInt(st.nextToken());
//            map[u].put(v, w);
//        }
//
//        distance[start] = 0;
//
//        for (int i = 0; i < V - 1; i++) {
//            //!visited인 값들 중 가장 distance가 작은 값을 currentNode로 설정
//            int currentNode = Integer.MAX_VALUE;
//            for (int j = 1; j <= V; j++) {
//                if (!visited[j]) currentNode = currentNode > distance[j] ? j : currentNode;
//            }
//            if (currentNode == Integer.MAX_VALUE) break;
//            visited[currentNode] = true;
//
//            if (map[currentNode].size() == 0) continue;
//            for (int key : map[currentNode].keySet()) {
//                if (!visited[key])
//                    distance[key] = Math.min(distance[currentNode] + map[currentNode].get(key), distance[key]);
//            }
//        }
//
//        for (int i = 1; i <= V; i++) {
//            sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
//        }
//        System.out.println(sb);
//    }
}

class Edge implements Comparable<Edge> {
    int node, weight;

    Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int compareTo(Edge e) {
        if (this.weight > e.weight) return 1;
        else return -1;
    }
}
