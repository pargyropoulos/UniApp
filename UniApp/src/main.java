
import view.mainView;
import controller.mainController;

/**
 *
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class main {

    public static void main(String[] args) {
        mainController mainCtrl=new mainController(new mainView());
        mainCtrl.getView().setVisible(true);
    }
    
}
