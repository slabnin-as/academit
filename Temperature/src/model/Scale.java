package model;

public abstract class Scale {
    public abstract void setTemperature(double inputTemperature);

    public abstract double convertToCelsius();

    public abstract double convertFromCelsius(double celsiusTemperature);
}
