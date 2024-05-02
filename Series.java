package info2;
//Peter Brederlow, Ulrike Hunfeld
public class Series {
    // Exercise Task
    // 1.1 a)
    public static int sumUp(int n) {
        int result = 0;
        for (int i = n; i > 0; i--) {
            result += i;
        }
        return result;
    }

    // Exercise Task
    // 1.2 b)
    public static void multiplicationTable(int n) {
        int result;
        int count = 1;
        for (int i = 0; i < 10; i++) {
            result = n * count;
            System.out.println(n + " x " + count + " = " + result);
            count++;
        }
    }

    // Exercise Task
    // 1.3 c)
    public static void fizzBuzz() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0 && i % 3 != 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else {
                System.out.println(i);
            }
        }
    }

    // Exercise Task
    // 1.4 d)
    public static void chessBoard(int n) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    if (j % 2 == 0) {
                        System.out.print(1);
                    } else {
                        System.out.print(0);
                    }
                    if (j != n - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            } else {
                for (int j = 0; j < n; j++) {
                    if (j % 2 != 0) {
                        System.out.print(1);
                    } else {
                        System.out.print(0);
                    }
                    if (j != n - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }

    // Exercise Task
    // 1.5 e)
    public static int factorial(int n) {
        int result = 1;
        if (n == 0){
            return 1;
        } else {
            while (n != 0){
                result = result * n;
                n--;
            }
        }
        return result;
    }

    // Exercise Task
    // 1.6 f)
    public static double e(int n) {
        double result = 1;
        double factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
            result = result + (1 / factorial);
        }
        return result;
        //source: https://stackoverflow.com/questions/63839131/issue-finding-eulers-number-in-java
    }

    // Exercise Task
    // 1.7 g)
    public static void reverseDigits(int n) {
        String s = Integer.toString(n);
        String r = "";
        for (int i = s.length()-1; i >= 0; i--){
            System.out.println(s.charAt(i));
        }
    }

    // Exercise Task
    // 1.8 h)
    public static double leibnizSeries(int n) {
        double res = 0;
        for (int i = 0; i < n; i++){
           if (i %2 == 0){
               res += 1/((double)2*i+1);
           } else {
               res += (-1)/((double)2*i+1);
           }
        }
        return 4*res;
    }

    public static void main(String[] args) {

        System.out.println("1.1 a) ");
        System.out.println(sumUp(10));

        System.out.println("1.2 b) ");
        multiplicationTable(4);

        System.out.println("1.3 c) ");
        fizzBuzz();

        System.out.println("1.4 d) ");
        chessBoard(4);

        System.out.println("1.5 e) ");
        System.out.println(factorial(4));

        System.out.println("1.6 f) ");
        System.out.println(e(100));

        System.out.println("1.7 g) ");
        reverseDigits(1239);

        System.out.println("1.8 h) ");
        System.out.println(leibnizSeries(3));

    }
}
