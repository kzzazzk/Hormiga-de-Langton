import java.io.IOException;
import java.util.*;
public class Ejecucion {
    public static void main(String[] args) throws ExceptionTableroSize, IOException,InterruptedException {
        int i = 1;
        Ejecucion ejecucion = new Ejecucion();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca la dimension deseada para el tablero: ");
        int sizeTablero = scanner.nextInt();
        Tablero tablero = new Tablero(sizeTablero,sizeTablero);
        int x = sizeTablero/2;
        PanelGrafico panelGrafico = new PanelGrafico(sizeTablero);
        tablero.inicializarTablero();
        Hormiga ubicacionHormiga = new Hormiga(x, x);
        System.out.println("Generacion 0: ");
        tablero.mostrarTableroHormiga(tablero,ubicacionHormiga);
        do {
            System.out.print("\nGeneracion " + i+": ");
            tablero.movimientoHormiga(ubicacionHormiga,panelGrafico);
            System.out.println();
            tablero.mostrarTableroHormiga(tablero,ubicacionHormiga);
            i++;
        }
        while(i!=11654);
        System.out.println("El mapa de apariencias es este: ");
        tablero.mostrarTablaApariencias();
        System.out.println("La hormiga ha pasado "+tablero.casillaMasVisitada()+"veces por la casilla más visitada");

    }
}
