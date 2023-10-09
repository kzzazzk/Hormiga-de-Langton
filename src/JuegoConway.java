import java.util.Random;

public class JuegoConway {
    private int[][] tablero;
    public JuegoConway(int length, int width){
        tablero = new int[length][width];
    }
    public String toString(){
        String stringTablero = "";
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                stringTablero+=tablero[i][j]+" ";
            }
        }
        return stringTablero;
    }}
