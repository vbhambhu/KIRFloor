package kir.ox.ac.uk;

import kir.ox.ac.uk.models.DrawingShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel{

    private List<DrawingShape> drawingShape;

    private List<Rectangle> squares = new ArrayList<Rectangle>();

    private PropertyPanel propertyPanel;


    public DrawingPanel(List<DrawingShape> drawingShape){

        this.drawingShape = drawingShape;
        setBackground(Color.WHITE);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;


        System.out.println(getSize());



        g2.setPaint(Color.decode("#F2F2F2"));

        int DRAWING_SIZE = 2000;
        int SUBDIVISIONS = 150;
        int SUBDIVISION_SIZE = DRAWING_SIZE / SUBDIVISIONS;

        for (int i = 1; i < SUBDIVISIONS; i++) {
            int x = i * SUBDIVISION_SIZE;
            g2.drawLine(x, 0, x, getSize().height);
        }
        for (int i = 1; i < SUBDIVISIONS; i++) {
            int y = i * SUBDIVISION_SIZE;
            g2.drawLine(0, y, getSize().width, y);
        }

        System.out.println("painting");

        g2.setPaint(Color.BLACK);
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(10));

//        for (Rectangle rect : squares) {
//            g2.draw(rect);
//        }


        for (DrawingShape ds: drawingShape){
            g2.drawRect(ds.getX(), ds.getY(),ds.getWidth(),ds.getHeight());

        }



    }

    public void doRepaint(PropertyPanel propertyPanel) {
        this.propertyPanel = propertyPanel;
        addEvents();
        repaint();
    }


//    public void addRectangle() {
//
//        Rectangle rectx = new Rectangle(10, 10, 100, 100);
//        squares.add(rectx);
//        repaint();
//    }
//
//    public void addFloor() {
//
//        Rectangle rectangle = new Rectangle(10, 10, 100, 100);
//        squares.add(rectangle);
//        addEvents();
//        repaint();
//    }


    public void addEvents(){

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                for (DrawingShape s: drawingShape){

                    Rectangle rectangle = new Rectangle(s.getX(), s.getY(),s.getWidth(),s.getHeight());

                    if (rectangle.contains(me.getPoint())) {//check if mouse is clicked within shape
                        System.out.println("Clicked a rectangle");

                        propertyPanel.addPropertyTool(s);



                    }


                }
            }
        });
    }


}
