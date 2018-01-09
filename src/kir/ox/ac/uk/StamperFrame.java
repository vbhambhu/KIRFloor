package kir.ox.ac.uk;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class StamperFrame extends JFrame {

    private final JButton circleButton, ovalButton, squareButton, rectButton;

    private final JPanel shapesPanel;

    private Shape shape;
    private final int w = 100;
    private final int h = 200;

    private Object lastButtonPressed;



    public StamperFrame() {

        setTitle("Shape Stamper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);


        final Container contentPane = getContentPane();

        //Setting up the buttons and positioning them.
        JPanel buttonPanel = new JPanel();

        circleButton = new JButton("Circle");
        ovalButton = new JButton("Oval");
        squareButton = new JButton("Square");
        rectButton = new JButton("Rectangle");

        buttonPanel.add(circleButton);
        buttonPanel.add(ovalButton);
        buttonPanel.add(squareButton);
        buttonPanel.add(rectButton);

        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        //end button init

        shapesPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics graphics) {
                Graphics2D g = (Graphics2D) graphics;
                super.paintComponent(g);
                if(shape != null) g.draw(shape);
            }

        };
        contentPane.add(shapesPanel, BorderLayout.CENTER);

        final ActionListener buttonPressed = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                lastButtonPressed = event.getSource();
            }
        };

        circleButton.addActionListener(buttonPressed);
        ovalButton.addActionListener(buttonPressed);
        squareButton.addActionListener(buttonPressed);
        rectButton.addActionListener(buttonPressed);

        contentPane.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int x = e.getX();
                int y = e.getY();

                if(lastButtonPressed == circleButton){
                    shape = new Ellipse2D.Double(x, y, w, w);
                    echo("Circle",x,y);
                } else if(lastButtonPressed == ovalButton){
                    shape = new Ellipse2D.Double(x, y, w, h);
                    echo("Oval",x,y);
                } else if (lastButtonPressed == squareButton){
                    shape = new Rectangle2D.Double(x, y, w, w);
                    echo("Square",x,y);
                } else if (lastButtonPressed == rectButton){
                    echo("Rectangle",x,y);
                    shape = new Rectangle2D.Double(x, y, w, h);
                }

                shapesPanel.repaint();
            }

            private void echo(String shape, int x, int y){
                System.out.println(shape + " added at: " + x + "," + y);
            }

        });


        //setBounds(bounds);
        setVisible(true);

    }

    public static void main(String[] args) {

    }
}