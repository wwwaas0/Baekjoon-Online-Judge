package Gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<BusInfo>[] bus = new ArrayList[N + 1];
        PriorityQueue<BusInfo> q = new PriorityQueue<>();

        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            bus[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            bus[start].add(new BusInfo(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        //맨 처음에는 현재 도시에 start 값 넣기
        distance[start] = 0;
        //큐에는 방문한 도시 넣기
        //도착지, start에서 도착지까지 걸리는 distance값 넣기
        q.offer(new BusInfo(start, 0));

        while (!q.isEmpty()) {
            BusInfo current = q.poll();
            int endPoint = current.endPoint; //내가 현재 방문하고 있는 도시
            visited[endPoint] = true;

            for (BusInfo b : bus[endPoint]) {
                int city = b.endPoint;
                int nextCost = b.cost;

                if (visited[city]) continue;
                distance[city] = Math.min(distance[endPoint] + nextCost, distance[city]);
                q.offer(b);
            }
        }

        System.out.println(distance[end]);
    }
}

class BusInfo implements Comparable<BusInfo> {
    int endPoint;
    int cost;

    public BusInfo(int endPoint, int cost) {
        this.endPoint = endPoint;
        this.cost = cost;
    }

    public int compareTo(BusInfo b) {
        if (this.cost < b.cost) return -1;
        else return 1;
    }
}
