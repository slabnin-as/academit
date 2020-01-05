package app;

import controller.Controller;
import view.GuiForm;

public class TemperatureConverter {
    public static void main(String[] args) {
        GuiForm guiForm = new GuiForm();
        Controller controller = new Controller(guiForm);
        controller.initController();
    }
}