public class zifferExtrahieren {
    public static void extractor(int n){ //n is defining the boardsize{
        if (n == 0){System.out.println("The number to be extracted should be higher than 0.");}
        else{
            while(n >= 1) {
            int i = n % 10;
            n = n/10;
            System.out.println(i);
            }
        }
    }
    public static void main(String[] args){
        extractor(1239);
    }
}

