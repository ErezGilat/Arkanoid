package geometry;

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the following class represent a Rectangle.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private Color color;

    /**
     * Constructor, Create a new rectangle with location and width/height.
     * @param upperLeft Point.
     * @param width double.
     * @param height double.
     * @param color Color.
     */
    public Rectangle(Point upperLeft, double width, double height, Color color) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    /**
     * @param line .
     * @return a (possibly empty) List of intersection points
     * with the specified line.
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> intersectionList = new ArrayList<>();
        Point upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        Point lowLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        Point lowRight = new Point(upperRight.getX(), lowLeft.getY());
        Line upper = new Line(upperLeft, upperRight);
        Line lower = new Line(lowLeft, lowRight);
        Line left = new Line(lowLeft, upperLeft);
        Line right = new Line(lowRight, upperRight);
        Point intersectionUpper = line.intersectionWith(upper);
        Point intersectionLower = line.intersectionWith(lower);
        Point intersectionLeft = line.intersectionWith(left);
        Point intersectionRight = line.intersectionWith(right);
        if (intersectionUpper != null) {
            intersectionList.add(intersectionUpper);
        }
        if (intersectionLower != null) {
            intersectionList.add(intersectionLower);
        }
        if (intersectionLeft != null) {
            intersectionList.add(intersectionLeft);
        }
        if (intersectionRight != null) {
            intersectionList.add(intersectionRight);
        }
        return intersectionList;
    }
    /**
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }
    /**
     * @return the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    /**
     * The function draw the rectangle on the given DrawSurface.
     * @param surface .
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.black);
        surface.fillRectangle(
                (int) this.upperLeft.getX() - 1, (
                        int) this.upperLeft.getY() - 1, (int) this.width + 2, (int) this.height + 2);
        surface.setColor(this.color);
        surface.fillRectangle(
                (int) this.upperLeft.getX(), (int) this.upperLeft.getY(), (int) this.width, (int) this.height);
    }
    /**
     * @return the rectangle's color.
     */
    public Color getColor() {
        return this.color;
    }
    /**
     * The function set the upper left point of the rectangle to be the parameter.
     * @param newLeft (Point).
     */
    public void setUpperLeft(Point newLeft) {
        this.upperLeft = newLeft;
    }
}
