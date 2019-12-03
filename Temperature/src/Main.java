import controller.Controller;
import model.TemperatureConversion;
import view.GuiForm;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TemperatureConversion conversion = new TemperatureConversion();

        SwingUtilities.invokeLater(() -> {
            GuiForm guiForm = new GuiForm();
            Controller controller = new Controller(conversion, guiForm);
            controller.initController();
        });
    }
}