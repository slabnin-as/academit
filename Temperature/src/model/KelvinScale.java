package model;

public class KelvinScale implements Scale {
    @Override
    public double convertToCelsius(double inputTemperature) {
        return inputTemperature - 273.15;
    }

    @Override
    public double convertFromCelsius(double celsiusTemperature) {
        return celsiusTemperature + 273.15;
    }

    @Override
    public String toString() {
        return "Кельвин";
    }
}
