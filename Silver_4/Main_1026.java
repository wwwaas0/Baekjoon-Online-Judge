package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] A_str = br.readLine().split(" ");
        String[] B_str = br.readLine().split(" ");
        int[] A = Arrays.stream(A_str).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(B_str).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        for(int k = 0 ; k < N ; k++){
            int biggest = 0;
            int indexBig = N;
            for(int i=0 ; i<N ;i++){
                if(biggest <= B[i]){
                    biggest = B[i];
                    indexBig = i;
                }
            }
            B[indexBig] = 0;

            int smallest = 100;
            int indexSmall = N;
            for(int j =0 ; j<N ; j++){
                if(smallest >= A[j]){
                    smallest = A[j];
                    indexSmall = j;
                }
            }
            A[indexSmall] = 100;
            sum += smallest * biggest;
        }

        System.out.println(sum);
    }
}
