public class multiplicationTable {
    public static void MultiplTable(int n){
        int i = 1;
        while(i <= 10) {
          int x = i*n;
          System.out.println(n + " x " + i + " = " + x);
          i++;
        }
    }
    public static void main(String[] args){
        MultiplTable(3);
    }
}

