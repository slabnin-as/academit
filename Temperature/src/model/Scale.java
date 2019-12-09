package model;

public abstract class Scale {
    double temperature;

    abstract double convertToCelsius();
    abstract double convertToFahrenheit();
    abstract double convertToKelvin();
}
