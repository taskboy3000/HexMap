/*
 * Class that holds the spatial relationship of each hex in a complete map
 * Positional space resprented as a 2D array
 */
package Hexagonal;

import java.awt.Dimension;
import java.util.Iterator;
import java.lang.UnsupportedOperationException;

/**
 *
 * @author Joe Johnston
 */
public class HexMap implements Iterator {

    private Hex[][] hexes;
    private int hexSize;
    private int rows = 10;
    private int cols = 10;
    private int currIdxX = 0;
    private int currIdxY = 0;
    
    public HexMap(int r, int c, int s) {
        hexSize = s;
        rows = r;
        cols = c;
        hexes = new Hex[r][c];

        Integer R = null;
        for (int y = 0; y < r; y++) {
            for (int x = 0; x < c; x++) {
                Hex h = new Hex(hexSize);
                if (x > 0) {
                    h.x = hexes[y][x - 1].getVert1().x;
                } else {
                    h.x = x * hexSize;
                }
                h.y = y * hexSize;
                h.calculateVertices();
                
                // odd columns get an additional offset
                if (x % 2 == 0) {
                    if (R == null) {
                        R = h.R;
                    }
                    h.y += R;
                } 
                h.calculateVertices();

                hexes[y][x] = h;
            }
        }
    }

    public Hex getHex(int x, int y) {
        return hexes[y][x];
    }

    // Iterator interface
    public boolean hasNext() {
        return currIdxX < cols && currIdxY < rows;
    }

    public Hex next() {
        Hex H = hexes[currIdxY][currIdxX];
        if (currIdxX + 1 < cols) {
            currIdxX++;
        } else {
            currIdxY++; // hasNext() should prevent this from exploding
            currIdxX=0;
        }
        return H;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void reset() {
        currIdxX = currIdxY = 0;
    }
}
