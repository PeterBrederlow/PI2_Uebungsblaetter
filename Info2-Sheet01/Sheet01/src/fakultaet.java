public class fakultaet {
    public static void faculty(int n){ //n is defining the boardsize{
        int fact = 1;
        for (int j = 1; j <= n; j++) {
                    fact = fact * j;
        };
        System.out.println(fact);
    }
    public static void main(String[] args){
        faculty(5);
    }
}
