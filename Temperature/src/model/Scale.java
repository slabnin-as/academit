package model;

public interface Scale {
    double convertToCelsius(double inputTemperature);

    double convertFromCelsius(double celsiusTemperature);
}
