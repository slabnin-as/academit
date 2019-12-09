package model;

public class KelvinScale extends Scale {
    private double temperature;

    public void setTemperature(double inputTemperature){
        temperature = inputTemperature;
    }
    @Override
    public double convertToCelsius() {
        return temperature - 273.15;
    }

    @Override
    public double convertFromCelsius(double celsiusTemperature){
        return celsiusTemperature + 273.15;
    }

    @Override
    public String toString(){
        return "Кельвин";
    }
}
