public class leibnizMethode {
    public static void Leibniz(int k) { //n is defining the boardsize{
        float sum = 0;
        float result;
        for(int i = 0; i < k; i++) {
            float numerator = 1;
            if(i % 2 == 0){numerator = 1;}
            else{numerator = -1;}
            float denominator = 2*i + 1;
            sum = sum + (numerator / denominator);
        }
        result = 4*sum;
        System.out.println(result);
    }

    public static void main(String[] args) {
        Leibniz(1000000);
    }
}

