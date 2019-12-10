package controller;

import model.*;

import java.awt.*;

class ConvertController {
    private double celsiusTemperature;
    private double inputTemperature;
    private Scale inputScale;
    private Scale outScale;

    ConvertController(Scale inputScale, Scale outScale, double inputTemperature) {
        this.inputScale = inputScale;
        this.outScale = outScale;
        this.inputTemperature = inputTemperature;
    }

    double convert() {
        inputScale.setTemperature(inputTemperature);
        celsiusTemperature = inputScale.convertToCelsius();
        return outScale.convertFromCelsius(celsiusTemperature);
    }

    Color setColor() {
        if (celsiusTemperature > 0) {
            return Color.RED;
        } else {
            return Color.BLUE;
        }
    }
}