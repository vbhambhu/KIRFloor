package kir.ox.ac.uk;

import kir.ox.ac.uk.models.DrawingShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Designer extends JFrame {

    static JFrame f = new Designer();

    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

    private List<DrawingShape> shapes = new ArrayList<DrawingShape>();

    DrawingPanel drawingPanel = new DrawingPanel(shapes);
    PropertyPanel propertyPanel = new PropertyPanel(drawingPanel, shapes);


    public Designer(){

        Rectangle bounds = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getMaximumWindowBounds();

        splitPane.setTopComponent(propertyPanel);
        splitPane.setBottomComponent(drawingPanel);
        splitPane.setDividerLocation(0.3);

        add(splitPane, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(bounds);
        setVisible(true);

    }

    public static void main(String[] args) {
        System.out.println("App started...");
    }
}
