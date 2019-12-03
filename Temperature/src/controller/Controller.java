package controller;

import model.TemperatureConversion;
import view.GuiForm;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Controller {
    private TemperatureConversion conversion;
    private GuiForm guiForm;

    public Controller(TemperatureConversion conversion, GuiForm guiForm) {
        this.conversion = conversion;
        this.guiForm = guiForm;
    }

    public void initController() {
        guiForm.getRbConvert().addActionListener(e -> convert());
    }

    private boolean checkUserInput() {
        Scanner scanner = new Scanner(guiForm.getInputTemp().getText());
        scanner.useLocale(Locale.ENGLISH);
        if (!scanner.hasNextDouble()) {
            JOptionPane.showMessageDialog(null, "Введите число!", "Неверный ввод", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void convert() {
        String userScale = (String) guiForm.getCb1Scales().getSelectedItem();
        String resultScale = (String) guiForm.getCb2Scales().getSelectedItem();
        double inputTemperature;
        double resultTemperature = 0;

        if (checkUserInput()) {
            inputTemperature = Double.parseDouble(guiForm.getInputTemp().getText());

            assert userScale != null;
            if (userScale.equals("Цельсий")) {
                assert resultScale != null;
                switch (resultScale) {
                    case "Фаренгейт":
                        resultTemperature = conversion.celsiusToFahrenheit(inputTemperature);
                        break;
                    case "Кельвин":
                        resultTemperature = conversion.celsiusToKelvin(inputTemperature);
                        break;
                    default:
                        resultTemperature = inputTemperature;
                        break;
                }
            }
            if (userScale.equals("Фаренгейт")) {
                assert resultScale != null;
                switch (resultScale) {
                    case "Цельсий":
                        resultTemperature = conversion.fahrenheitToCelsius(inputTemperature);
                        break;
                    case "Кельвин":
                        resultTemperature = conversion.fahrenheitToKelvin(inputTemperature);
                        break;
                    default:
                        resultTemperature = inputTemperature;
                        break;
                }
            }
            if (userScale.equals("Кельвин")) {
                assert resultScale != null;
                switch (resultScale) {
                    case "Фаренгейт":
                        resultTemperature = conversion.kelvinToFahrenheit(inputTemperature);
                        break;
                    case "Цельсий":
                        resultTemperature = conversion.kelvinToCelsius(inputTemperature);
                        break;
                    default:
                        resultTemperature = inputTemperature;
                        break;
                }
            }

            guiForm.getLbResult().setText(DecimalFormat.getNumberInstance(Locale.ENGLISH).format(resultTemperature));
        }
    }
}
