package app;

import model.*;
import view.GuiForm;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scale[] scales = {new CelsiusScale(), new KelvinScale(), new FahrenheitScale()};
        GuiForm guiForm = new GuiForm(scales);
    }
}