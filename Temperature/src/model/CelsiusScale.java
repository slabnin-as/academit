package model;

public class CelsiusScale implements Scale {
    @Override
    public double convertToCelsius(double inputTemperature) {
        return inputTemperature;
    }

    @Override
    public double convertFromCelsius(double celsiusTemperature) {
        return celsiusTemperature;
    }

    @Override
    public String toString() {
        return "Цельсий";
    }
}
