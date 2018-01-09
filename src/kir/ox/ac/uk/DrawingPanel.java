package kir.ox.ac.uk;

import kir.ox.ac.uk.models.DrawingShape;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {

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


       // System.out.println(getSize());

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

//
//        try{
//            BufferedImage image = ImageIO.read(getClass().getResource("/resources/arrow_right.png"));
//            g2.drawImage(image, 10, 10, null);
//        } catch (Exception e){
//
//        }
//
//
//
//
//
//
        g2.setPaint(Color.BLUE);
        //Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        //g2.setStroke(dashed);
        g2.drawRect(50 + 200,80 + 100,10,10);

//        g2.fillOval(45,45,10,10);
//        g2.fillOval(45,110 + 45,10,10);
//        g2.fillOval(210+ 45,45,10,10);
//        g2.fillOval(210+ 45,110 + 45,10,10);



    }

    public void doRepaint(PropertyPanel propertyPanel) {
        this.propertyPanel = propertyPanel;
        addEvents();
        repaint();
    }


    public void doSelect(){
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



    public void mouseReleased(MouseEvent event)
    {
        int x = event.getXOnScreen();
        int y = event.getYOnScreen();

//        if(isPressed)
//        {
//            RectangleComponent rc = new RectangleComponent(x, y);
//            frame.add(rc);
//            frame.revalidate();
//            frame.repaint();
//        }
    }



    public void addEvents(){

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent event)
            {
                System.out.println("Mouse released. x = " + event.getX() + " y = " + event.getY());
                
            }

            @Override
            public void mouseEntered(MouseEvent event) {
                System.out.println("Mouse entered. x = "
                        + event.getX() + " y = " + event.getY());
            }

            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("monsueeeeee");
            }

            @Override
            public void mousePressed(MouseEvent me) {
                super.mousePressed(me);
                for (DrawingShape s: drawingShape){


                    Rectangle right_bottom_corner = new Rectangle(s.getX() + s.getWidth(), s.getY() + s.getHeight(),10,10);



                    Rectangle rectangle = new Rectangle(s.getX(), s.getY(),s.getWidth(),s.getHeight());

                    if (right_bottom_corner.contains(me.getPoint())) {//check if mouse is clicked within shape
                        System.out.println("Clicked a rectangle");
                        System.out.println(s.getId());
                        //propertyPanel.addPropertyTool(s);



                    }


                }
            }
        });
    }


}
