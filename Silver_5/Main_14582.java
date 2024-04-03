package Silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main_14582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isReversalDefeat = false;
        int jTotalScore =0;
        int sTotalScore=0;
        String jScore = br.readLine();
        String sScore = br.readLine();

        String [] jScoreArray_str= jScore.split("\\s"); //공백을 의미하는 정규식
        String [] sScoreArray_str = sScore.split("\\s");

        int [] jScoreArray = Stream.of(jScoreArray_str).mapToInt(Integer::parseInt).toArray();
        int [] sScoreArray = Stream.of(sScoreArray_str).mapToInt(Integer::parseInt).toArray();

        for(int i =0;i<9;i++){
            jTotalScore+=jScoreArray[i];

            if(jTotalScore > sTotalScore){
                isReversalDefeat =true;
            }

            sTotalScore+=sScoreArray[i];

            if(jTotalScore > sTotalScore){
                isReversalDefeat =true;
            }
        }

        if(isReversalDefeat){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }

    }
}
