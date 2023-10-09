import javax.swing.*;
import java.awt.*;
public class PanelHormiga extends JPanel{
        private final int dotSize;

        public PanelHormiga(int dotSize) {
            int pixels = dotSize * Tablero.length;
            this.dotSize = dotSize;
            setPreferredSize(new Dimension(pixels, pixels));
            setBackground(Color.WHITE);
        }

        protected void paintComponent(Graphics g, Hormiga ubicacion,  Tablero tablero, PanelGrafico panelGrafico) {
            super.paintComponent(g);
            // we draw the cells
            for (int x = 0; x < tablero.length; x++) {
                for (int y = 0; y < tablero.width; y++) {
                    if (panelGrafico.getCellColor(ubicacion) == PanelGrafico.Color.BLACK) {
                        g.setColor(Color.BLACK);
                        g.fillRect(dotSize * x, dotSize * y, dotSize, dotSize);
                    }
                }
            }
        }
    }
