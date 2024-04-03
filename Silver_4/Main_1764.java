package Silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int notHear = Integer.parseInt(inputs[0]);
        int notSee = Integer.parseInt(inputs[1]);

        Set<String> set = new HashSet<>();
        ArrayList<String> notHearSeeName = new ArrayList<>();

        for(int i=0; i<notHear; i++){
            set.add(br.readLine());
        }

        for(int i=0; i<notSee; i++){
            String notSeeName = br.readLine();
            if(set.contains(notSeeName)){
                notHearSeeName.add(notSeeName);
            }
        }

        Collections.sort(notHearSeeName);

        System.out.println(notHearSeeName.size());
        for(int i =0; i< notHearSeeName.size(); i++){
            System.out.println(notHearSeeName.get(i));
        }
    }
}
