package model;

public class TemperatureConversion {
    public double celsiusToFahrenheit(double celsiusTemperature) {
        return celsiusTemperature * (9 / 5.0) + 32;
    }

    public double celsiusToKelvin(double celsiusTemperature) {
        return celsiusTemperature + 273.15;
    }

    public double kelvinToCelsius(double kelvinTemperature) {
        return kelvinTemperature - 273.15;
    }

    public double kelvinToFahrenheit(double kelvinTemperature) {
        return (kelvinTemperature - 273.15) * (9 / 5.0) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheitTemperature) {
        return (fahrenheitTemperature - 32) * (5 / 9.0);
    }

    public double fahrenheitToKelvin(double fahrenheitTemperature) {
        return (fahrenheitTemperature - 32) * (5 / 9.0) + 273.15;
    }
}
