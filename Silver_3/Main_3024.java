package Silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] array = new String[N][N];
        for (int i = 0; i < N; i++) {
            array[i] = br.readLine().split("");
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!array[i][j].equals(".")){
                    if(DFS(i,j,array, N)){
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("ongoing");
    }
    private static boolean DFS(int a, int b, String[][] array, int N){
        int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
        int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
        String c = array[a][b];

        for(int i =0; i<8;i++){
            int oneRow = a + dy[i];
            int oneCol = b + dx[i];
            int twoRow = a + 2*dy[i];
            int twoCol = b + 2*dx[i];
            try{if(c.equals(array[oneRow][oneCol]) && (c.equals(array[twoRow][twoCol]))){
                System.out.println(c);
                return true;
            }}
            catch (ArrayIndexOutOfBoundsException e){
                continue;
            }
        }
        return false;
    }
}
