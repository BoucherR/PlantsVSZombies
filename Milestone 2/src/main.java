import Controller.Controller;
import View.*;

public class main {
    public static void main(String args[]) {
        View view = new View();
        Controller controller = new Controller(view);
        controller.actionListener();
    }
}
