package model;

public class KelvinScale extends Scale {
    private double temperature;

    public void setTemperature(double inputTemperature){
        temperature = inputTemperature;
    }
    @Override
    double convertToCelsius() {
        return temperature - 273.15;
    }

    @Override
    double convertToFahrenheit() {
        return (temperature - 273.15) * (9 / 5.0) + 32;
    }

    @Override
    double convertToKelvin() {
        return temperature;
    }

    @Override
    public String toString(){
        return "Кельвин";
    }
}
