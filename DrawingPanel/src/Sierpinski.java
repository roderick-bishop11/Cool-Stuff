import java.awt.*;
import java.util.*;
public class Sierpinski {
 public static final int SIZE = 512; // height/width of DrawingPanel
 public static void main(String[] args) {
 // prompt for level
 Scanner console = new Scanner(System.in);
 System.out.print("What level do you want? ");
 int level = console.nextInt();
 // initialize drawing panel
 DrawingPanel p = new DrawingPanel(SIZE, SIZE);
 p.setBackground(Color.CYAN);
 Graphics g = p.getGraphics();
 // compute triangle endpoints and begin recursion
 int triangleHeight = (int) Math.round(SIZE * Math.sqrt(3.0) / 2.0);
 Point p1 = new Point(0, triangleHeight);
 Point p2 = new Point(SIZE / 2, 0);
 Point p3 = new Point(SIZE, triangleHeight);
 drawFigure(level, g, p1, p2, p3);
 }
 // Draws a Sierpinski fractal to the given level inside the triangle
 // whose vertices are (p1, p2, p3).
 public static void drawFigure(int level, Graphics g,
 Point p1, Point p2, Point p3) { 
 if (level == 1) {
 // base case: simple triangle
 Polygon p = new Polygon();
 p.addPoint(p1.x, p1.y);
 p.addPoint(p2.x, p2.y);
 p.addPoint(p3.x, p3.y);
 g.fillPolygon(p);
 } else {
drawFigure(level-1,g,p1,midpoint(p1,p3),midpoint(p1,p2)); 														
drawFigure(level-1,g,p2,midpoint(p1,p2),midpoint(p2,p3));
drawFigure(level-1,g,p3,midpoint(p1,p3),midpoint(p2,p3));
 }
 }
 // returns the midpoint of p1 and p2
 public static Point midpoint(Point p1, Point p2) {
 return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
 }
}
