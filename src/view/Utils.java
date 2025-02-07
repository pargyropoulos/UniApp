package view;

import constants.ColorConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;


/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class Utils {

    /**
     * Customize backcolor of a JButton on mouse hover
     * @param button
     * @param defaultColor
     * @param hoverColor
     */
    public static void customizeButton(JButton button, Color defaultColor, Color hoverColor) {
        button.setBackground(defaultColor);
        button.setForeground(Color.WHITE); // Keep text white for visibility
        button.setBorder(null);

        //Add hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(defaultColor);
            }
        });
    }
    /**
     * Centers
     * @param parent: Parent component
     * @param child : Child component
     * @return Point
     */
    public static Point getParentCenterLocation(Component  parent,Component  child){
        int parentX =parent.getX();
        int parentY = parent.getY();
        int parentWidth = parent.getWidth();
        int parentHeight = parent.getHeight();
        int childWidth = child.getWidth();
        int childHeight = child.getHeight();
        int centerX = parentX + (parentWidth - childWidth) / 2;
        int centerY = parentY + (parentHeight - childHeight) / 2;
        return new Point(centerX,centerY);
    }

    public static void customizeButtonsInsidePanel(JPanel panel){
        for (var component : panel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                customizeButton(button, ColorConstants.buttonBackgroundColor, ColorConstants.buttonHoverColor);
//                    System.out.println(button.getWidth());                
//                if (button.size().width<50){
//                    button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));        
//                }else {
//                    button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 24, 1, 24));        
//
//                }
            }
        }        
    }
    
    static class CustomComboBoxRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (isSelected) {
                c.setBackground(constants.ColorConstants.gridLineSelectionBackgroundColor); // Set your custom highlight color here
                c.setForeground(Color.white);  // Set the foreground color if needed
            } else {
                c.setBackground(Color.WHITE);
                c.setForeground(Color.BLACK);
            }
            return c;
        }
        
        @Override
        public Dimension getPreferredSize() {
            Dimension size = super.getPreferredSize();
            size.height = 20; // Set the desired line height (in pixels)
            return size;
        }        
    }   

}
