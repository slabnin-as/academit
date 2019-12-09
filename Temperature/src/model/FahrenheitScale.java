package model;

public class FahrenheitScale extends Scale {
    private double temperature;

    public void setTemperature(double inputTemperature){
        temperature = inputTemperature;
    }
    @Override
    double convertToCelsius() {
        return (temperature - 32) * (5 / 9.0);
    }

    @Override
    double convertToFahrenheit() {
        return temperature;
    }

    @Override
    double convertToKelvin() {
        return (temperature - 32) * (5 / 9.0) + 273.15;
    }

    @Override
    public String toString(){
        return "Фаренгейт";
    }
}
