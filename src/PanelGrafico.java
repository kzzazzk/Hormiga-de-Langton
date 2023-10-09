import javax.swing.*;
import java.awt.*;

public class PanelGrafico extends JPanel {

    Rectangle square = new Rectangle(5, 5);

    public static enum Color {
        WHITE, BLACK;

        public Color inverse() {
            return WHITE.equals(this) ? BLACK : WHITE;
        }
    }

    private Color[][] cells;
    public int size;

    public PanelGrafico(int size) {
        this.size = size;
        cells = new Color[size][size];

        // we init the cells with white color
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                cells[x][y] = Color.WHITE;
            }
        }
    }

    public Color getCellColor(Hormiga hormiga) {
        return cells[hormiga.getX()][hormiga.getY()];
    }

    public void setCellColor(Hormiga hormiga, Color c) {
        cells[hormiga.getX()][hormiga.getY()] = c;
    }

}