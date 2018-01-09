package kir.ox.ac.uk;

import kir.ox.ac.uk.models.DrawingShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class PropertyPanel extends JPanel {

    static PropertyPanel panel = new PropertyPanel();

    private DrawingPanel drawingPanel;
    private List<DrawingShape> drawingShape;

    JButton dsa = new JButton("dasada");

    public PropertyPanel(){}

    public PropertyPanel(DrawingPanel drawingPanel, List<DrawingShape> drawingShape){

        this.drawingPanel = drawingPanel;
        this.drawingShape = drawingShape;

        JButton addShapesBtn = new JButton("Add");

        String[] shapeStrings = {"Floor", "Room", "Wall", "Table", "Chair"};
        JComboBox shapeList = new JComboBox(shapeStrings);

        addShapesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(shapeList.getSelectedItem().equals("Floor")){

                    DrawingShape drawingShape1 = new DrawingShape();
                    drawingShape1.setId(1);
                    drawingShape1.setType("rect");
                    drawingShape1.setX(50);
                    drawingShape1.setY(80);
                    drawingShape1.setWidth(200);
                    drawingShape1.setHeight(100);
                    drawingShape.add(drawingShape1);
                    drawingPanel.doRepaint(panel);
                }
            }
        });

        add(shapeList);
        add(addShapesBtn);

    }



    public void addPropertyTool(DrawingShape dShape){


       // JButton dsa = new JButton("dasada");

        panel.add(dsa);

       // panel.revalidate();

       // panel.dsa.setVisible(true);


        System.out.println("dasdada");


    }

}
