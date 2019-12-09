package model;

public class FahrenheitScale extends Scale {
    private double temperature;

    public void setTemperature(double inputTemperature) {
        temperature = inputTemperature;
    }

    @Override
    public double convertToCelsius() {
        return (temperature - 32) * (5 / 9.0);
    }

    @Override
    public double convertFromCelsius(double celsiusTemperature) {
        return celsiusTemperature * (9 / 5.0) + 32;
    }

    @Override
    public String toString() {
        return "Фаренгейт";
    }
}
