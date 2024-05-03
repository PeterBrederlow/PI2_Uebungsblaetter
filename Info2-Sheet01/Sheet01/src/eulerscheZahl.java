import java.util.Scanner;
public class eulerscheZahl {
        public static float eulerIterative(int n) {
            float e = 1;
            for (float i = 1; i < n; i++) {
                float fact = 1;
                for (float j = 1; j <= i; j++) {
                    fact = fact * j;
                }
                e = e + (1 / fact);
            }
            return (e);
        }

        public static float eulerRecursive(int n) { //stack overflow bei hohen n
            float e = 1;
            int i = 1;
            while (i < n) {
                float fact = 1;
                float j = 1;
                while (j <= i) {
                    fact = fact * j;
                    j++;
                }
                e = e + (1 / fact);
                i++;
            }
            return (e);
        }

        public static void main(String args[]) {
            System.out.println(eulerIterative(100));
        }
}
