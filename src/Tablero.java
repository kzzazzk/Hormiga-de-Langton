import java.io.IOException;

public class Tablero{
    private char[][] tablero2D;
    private int[][] mapaApariencias;
    public static int length = 0 ,width = 0;
    public static final char celdaEncendida = '-';
    public static final char celdaApagada = '+';
    private static final char[] fichaDireccion = {'!','>',':','<'};
    public Tablero(int length, int width) throws ExceptionTableroSize{
        //if (length < 50 || width < 50 || length == 0 || width == 0)
            //throw new ExceptionTableroSize();
        //else
            this.width = width;
            this.length = length;
            tablero2D = new char[length][width];
            mapaApariencias = new int[length][width];
    }

    public void mostrar(Hormiga hormiga){
        for (int i = 0; i < tablero2D.length; i++) {
            for (int j = 0; j < tablero2D.length; j++) {
                if(hormiga.getX() == i && hormiga.getY() == j) System.out.print(hormiga.simboloHormiga+" ");
                else System.out.print(tablero2D[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void inicializarTablero(){
        for (int i = 0; i < tablero2D.length; i++) {
            for (int j = 0; j < tablero2D.length; j++) {
                tablero2D[i][j] = celdaEncendida;
                mapaApariencias[i][j] = 0;
            }
        }
    }

    public boolean isCeldaEncendida(Hormiga hormiga){
        return (tablero2D[hormiga.getX()][hormiga.getY()] == celdaEncendida);
    }

    public void setCeldaIntercambiada(Hormiga ubicacion){
        if(this.isCeldaEncendida(ubicacion)) {
            tablero2D[ubicacion.getX()][ubicacion.getY()] = celdaApagada;
            mapaApariencias[ubicacion.getX()][ubicacion.getY()]++;
        }
        else {
            tablero2D[ubicacion.getX()][ubicacion.getY()] = celdaEncendida;
            mapaApariencias[ubicacion.getX()][ubicacion.getY()]++;
        }

    }

    public Hormiga getUbicacionNueva(Hormiga hormiga){
        Hormiga cambioUbicacion = new Hormiga();
        switch (hormiga.getIndice()){
                case 0:
                    cambioUbicacion = new Hormiga(hormiga.getX()+1, hormiga.getY());
                    break;
                case 1:
                    cambioUbicacion = new Hormiga(hormiga.getX(), hormiga.getY()+1);
                    break;
                case 2:
                    cambioUbicacion = new Hormiga(hormiga.getX()-1, hormiga.getY());
                    break;
                case 3:
                    cambioUbicacion = new Hormiga(hormiga.getX(), hormiga.getY()-1);
                    break;
            }
        return cambioUbicacion;
    }

    public void movimientoHormiga(Hormiga ubicacion,PanelGrafico panelGrafico){
        Hormiga nuevaHormiga = getUbicacionNueva(ubicacion);
        setCeldaIntercambiada(ubicacion);
        ubicacion.setCoordenada(nuevaHormiga.getX(), nuevaHormiga.getY());
        nuevaHormiga.girar90(this);
        ubicacion.setSimboloHormiga(fichaDireccion[ubicacion.getIndice()]);
    }

    public void mostrarTableroHormiga(Tablero tablero, Hormiga hormiga){
        System.out.println(hormiga);
        String stringCelda = "La hormiga está encima de una celda ";
        stringCelda += tablero.isCeldaEncendida(hormiga) ? "encendida" : "apagada";
        System.out.println(stringCelda);
        hormiga.mostrarDireccion();
        tablero.mostrar(hormiga);
    }

    public void mostrarTablaApariencias(){
        for (int i = 0; i < mapaApariencias.length; i++) {
            for (int j = 0; j < mapaApariencias[i].length; j++) {
                System.out.printf("[%02d]",mapaApariencias[i][j]);
            }
            System.out.println();
        }
    }
    public int casillaMasVisitada(){
        int mayor = mapaApariencias[0][0];
        for (int i = 0; i < mapaApariencias.length; i++) {
            for (int j = 0; j < mapaApariencias[i].length; j++) {
                if(mapaApariencias[i][j] > mayor){
                    mayor = mapaApariencias[i][j];
                }
            }
        }
        return mayor;
    }
    public static void clearScreen() throws IOException,InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
