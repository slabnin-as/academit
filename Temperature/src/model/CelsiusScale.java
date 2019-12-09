package model;

public class CelsiusScale extends Scale {
    private double temperature;

    public void setTemperature(double inputTemperature) {
        temperature = inputTemperature;
    }

    @Override
    public double convertToCelsius() {
        return temperature;
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
