package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int sum;
        if(input < 100){
            sum = input;
        } else{
            sum = 99;
            for(int i=100;i <= input;i++){
                int[] array = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();
                if(isArithmetic(array)){
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
    }
    private static boolean isArithmetic (int[] array){
        int size = array.length;
        int num = array[1] - array[0];

        for(int i=1; i<size-1 ; i++){
            if(array[i+1] - array[i] != num){
                return false;
            }
        }
        return true;
    }
}
