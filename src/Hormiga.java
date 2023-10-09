public class Hormiga {
    private int x,y;
    public static char simboloHormiga = '*';
    private static int indice;
    private static final String[] direcciones = {"Abajo","Derecha","Arriba","Izquierda"};

    public Hormiga(){
        this.x = 0;
        this.y = 0;
    }

    public Hormiga(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCoordenada(int x, int y){
        setX(x);
        setY(y);
    }
    public String toString(){
        return "Ubicacion = "+"("+x+", "+y+")";
    }

    public static void setSimboloHormiga(char simboloHormiga) {
        Hormiga.simboloHormiga = simboloHormiga;
    }

    public void mostrarDireccion(){
        System.out.println("Dirección del siguiente paso: "+direcciones[indice]);
    }
    public void girar90(Tablero tablero){
        if(tablero.isCeldaEncendida(this)){
            if(indice >= direcciones.length - 1)
            {
                indice = 0;
                setIndice(indice);
            }
            else {
                indice++;
                setIndice(indice);
            }
        }
        else
        {
            if(indice <= 0){
                indice = 3;
                setIndice(indice);
            }
            else
            {
                indice--;
                setIndice(indice);
            }
        }
    }

    public static void setIndice(int indice1) {
        indice = indice1;
    }

    public int getIndice() {
        return indice;
    }

}
