import view.MainView;
import controller.MainController;



public class Main { 
    public static void main(String[] args) {     
        MainController ctrl=new MainController(new MainView());
        ctrl.run();
    }
}
