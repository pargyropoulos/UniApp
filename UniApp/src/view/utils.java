package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class utils {

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

        // Add hover effect
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
    

}
