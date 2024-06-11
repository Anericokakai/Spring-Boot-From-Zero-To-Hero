package oauth.testapp.custom_error_handling.Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TowersOfHanoi {

        static void towerOfHanoi(int n, char from_rod,
        char to_rod, char aux_rod,FileWriter myObj) throws IOException {
            int num=1;
            if (n == 0) {
                return;
            }

            towerOfHanoi(n - 1, from_rod, aux_rod, to_rod,myObj);

            System.out.println("Move disk " + n + " from rod "
                    + from_rod + " to rod "
                    + to_rod);
            myObj.write("Move disk " + n + " from rod "
                    + from_rod + " to rod "
                    + to_rod+"\n");

            towerOfHanoi(n - 1, aux_rod, to_rod, from_rod,myObj);

        }

    public static void main(String[] args) throws IOException {
            FileWriter myObj=new FileWriter("algo.txt");

            int N=6;
        towerOfHanoi(N,'A','C','B',myObj);
    }
}
