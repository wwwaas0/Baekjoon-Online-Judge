package Silver_5;

import java.util.Scanner;

public class Main_1476 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int e = 1;
        int s = 1;
        int m = 1;

        int i = 1;
        while(!((E == e) && (S == s) && (M == m))){
            if (e == 15) {
                e = 1;
            } else {
                e++;
            }

            if (s == 28) {
                s = 1;
            } else {
                s++;
            }

            if (m == 19) {
                m = 1;
            } else {
                m++;
            }

            i++;
        }

        System.out.println(i);
    }
}
