/*
 * An class that represents a hex on a hexmap
 * Does not necessarily have to be rendered as a Polygon object
 */

package Hexagonal;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Iterator;
import java.lang.UnsupportedOperationException;

/**
 *
 * @author Joe Johnston
 */
public class Hex implements Iterator {
    
    public int H;
    public int R;
    public int S;
    public int flatSize = 50;    // A
    public int pointedSize; // B %15 larger than A
    public int x;
    public int y;
    public Point[] vertices;
    private int currIdx = 0;
    
    private static double SIN30 = 0.5;
    private static double COS30 = 0.866;

    public Hex (int size) {
        // Given the initial position and the length of A, 
        // the rest of these numbers can be derived
        flatSize = size;
        vertices = new Point[6];
    }
    
    public void calculateVertices () {
        R = flatSize / 2;
        S = (int) Math.round(R / COS30);  // COS30
        H = (int) Math.round(0.5 * S);
        pointedSize = (int) Math.round(S + 2 * H);
        
        // Vertex 0: NW
        vertices[0] = new Point(x + H, y);
        
        // Vertex 1: NE
        vertices[1] = new Point(x + pointedSize - H, y);
        
        // Vertex 2: E
        vertices[2] = new Point(x + pointedSize, y + R);
        
        // Vertex 3: SE
        vertices[3] = new Point(x + pointedSize - H, y + flatSize);
        
        //Vertex 4: SW
        vertices[4] = new Point(x + H, y + flatSize);
        
        // Vertex 5: W
        vertices[5] = new Point(x, y + R);

    }
    
    public Point getVert0 () {
        // NW 
        return vertices[0];
    }
    public Point getVert1 () {
        // NE
        return vertices[1];
    }
    public Point getVert2 () {
        // E
        return vertices[2];
    }
    public Point getVert3 () {
        // SE
        return vertices[3];
    }
    public Point getVert4 () {
        // SW 
        return vertices[4];
    }
    public Point getVert5 () {
        // W 
        return vertices[5];
    }
    
    public boolean hasNext () {
       return currIdx < vertices.length;
    } 
    
    public Point next () {
        return vertices[currIdx++];
    }
    
    public void remove () {
        throw new UnsupportedOperationException();
    }
    
    public void reset() {
        currIdx=0;
    }
}
