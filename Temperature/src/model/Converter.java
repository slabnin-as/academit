package model;

import java.awt.*;


public class Converter {
    private double celsiusTemperature;
    private Scale inputScale;
    private Scale outScale;

    public Converter(Scale inputScale, Scale outScale) {
        this.inputScale = inputScale;
        this.outScale = outScale;
    }

    public double convert(double inputTemperature) {
        celsiusTemperature = inputScale.convertToCelsius(inputTemperature);
        return outScale.convertFromCelsius(celsiusTemperature);
    }

    public Color useColor() {
        if (celsiusTemperature > 0) {
            return Color.RED;
        } else {
            return Color.BLUE;
        }
    }
}
