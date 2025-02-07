import view.MainView;
import controller.MainController;

/**
 *
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class Main {
    
    public static void main(String[] args) {
        
        MainController ctrl=new MainController(new MainView());
        ctrl.run();
    }
    
}
