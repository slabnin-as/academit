package model;

import java.awt.*;


public class Converter {
    private double celsiusTemperature;
    private double inputTemperature;
    private Scale inputScale;
    private Scale outScale;

    public Converter(Scale inputScale, Scale outScale, double inputTemperature) {
        this.inputScale = inputScale;
        this.outScale = outScale;
        this.inputTemperature = inputTemperature;
    }

    public double convert() {
        celsiusTemperature = inputScale.convertToCelsius(inputTemperature);
        return outScale.convertFromCelsius(celsiusTemperature);
    }

    public Color setColor() {
        if (celsiusTemperature > 0) {
            return Color.RED;
        } else {
            return Color.BLUE;
        }
    }
}
