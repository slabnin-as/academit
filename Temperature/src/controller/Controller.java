package controller;

import model.Scale;
import view.GuiForm;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Controller {
    private GuiForm guiForm;

    public Controller(GuiForm guiForm) {
        this.guiForm = guiForm;
    }

    public void initController() {
        guiForm.getRbConvert().addActionListener(e -> setResult());
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

    private void setResult() {
        Scale inputScale = (Scale) guiForm.getInputScale().getSelectedItem();
        Scale resultScale = (Scale) guiForm.getOutScale().getSelectedItem();
        double inputTemperature;
        double resultTemperature;

        ConvertController converter;

        if (checkUserInput()) {
            inputTemperature = Double.parseDouble(guiForm.getInputTemp().getText());
            converter = new ConvertController(inputScale, resultScale, inputTemperature);
            resultTemperature = converter.convert();

            guiForm.getLbResult().setText(DecimalFormat.getNumberInstance(Locale.ENGLISH).format(resultTemperature));
            guiForm.getLbResult().setForeground(converter.setColor());
        }
    }
}
