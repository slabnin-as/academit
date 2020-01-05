package model;

public class FahrenheitScale implements Scale {
    @Override
    public double convertToCelsius(double inputTemperature) {
        return (inputTemperature - 32) * (5 / 9.0);
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
