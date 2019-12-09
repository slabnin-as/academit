import controller.Controller;
import view.GuiForm;

import javax.swing.*;

public class Temperature {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GuiForm guiForm = new GuiForm();
            Controller controller = new Controller(guiForm);
            controller.initController();
        });
    }
}