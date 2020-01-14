package app;

import controller.Controller;
import model.*;
import view.GuiForm;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scale[] scales = {new CelsiusScale(), new KelvinScale(), new FahrenheitScale()};
        GuiForm guiForm = new GuiForm(scales);
        Controller controller = new Controller(guiForm);
        controller.initController();
    }
}