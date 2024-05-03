import java.util.Arrays;

public class chessBoard {
    public static void Chess(int n){ //n is defining the boardsize
        int x = 0; // Variable, um Zeilenbeginn zu definieren
        int y = 0; // Variable, um tatsächlichen Inhalt jeder Zeile zu definieren
        for(int i = 0; i < n; i++) {
            if (x == 0) {x = 1;} //Wechsel des Inhalts je nach vorherigem Wert von x
            else {x = 0;}
            y = x;
                for (int j = 0; j < n; j++) {
                   if (j == n-1){System.out.println(y);} //Zeilenende
                   else {
                       System.out.print(y + " ");
                       if (y == 0) { //Wechsel des Inhalts je nach vorherigem Wert von y
                           y = 1;
                       } else {
                           y = 0;
                       }
                   }
                }
        }
    }
    public static void main(String[] args){
        Chess(4);
    }
}

