package Gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 시간 초과
 */
public class Main_11657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Bus[] edges = new Bus[M]; //버스의 개수만큼
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) { //M번 반복
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            edges[i] = new Bus(s, e, t);
        }

        //distance 배열 값 채우기
        dist[1] = 0;
        for (int i = 1; i < N; i++) { // N - 1번 반복
            for (int j = 0; j < M; j++) { //각 버스 정보 탐색하면서 거리 업데이트
                Bus busInfo = edges[j];
                if ((dist[busInfo.start] != Integer.MAX_VALUE) && (dist[busInfo.end] > dist[busInfo.start] + busInfo.time)) {
                    dist[busInfo.end] = dist[busInfo.start] + busInfo.time;
                }
            }
        }

        //마이너스 값 있는지 확인
        boolean isMinus = false;
        for (int i = 0; i < M; i++) { //각 버스 정보 탐색하면서 거리 업데이트
            Bus busInfo = edges[i];
            if ((dist[busInfo.start] != Integer.MAX_VALUE) && (dist[busInfo.end] > dist[busInfo.start] + busInfo.time)) {
                isMinus = true;
                break;
            }
        }

        if(!isMinus){
            for (int i =2; i <= N; i++) { //각 버스 정보 탐색하면서 거리 업데이트
                if(dist[i] == Integer.MAX_VALUE) sb.append(-1);
                else sb.append(dist[i]);

                if(i != N) sb.append("\n");
            }
        } else{
            sb.append(-1);
        }

        System.out.println(sb);
    }
}

class Bus implements Comparable<Bus> {
    int start;
    int end;
    int time;

    public Bus(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }

    @Override
    public int compareTo(Bus o) {
        return 0;
    }
}
