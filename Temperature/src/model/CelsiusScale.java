package model;

public class CelsiusScale extends Scale{
    private double temperature;

    public void setTemperature(double inputTemperature){
        temperature = inputTemperature;
    }

    @Override
    double convertToCelsius() {
        return temperature;
    }

    @Override
    double convertToFahrenheit() {
        return temperature * (9 / 5.0) + 32;
    }

    @Override
    double convertToKelvin() {
        return temperature + 273.15;
    }

    @Override
    public String toString(){
        return "Цельсий";
    }
}
