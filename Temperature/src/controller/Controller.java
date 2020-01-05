package controller;

import model.Scale;
import view.GuiForm;

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
            guiForm.showErrorMessage();
            return false;
        }

        return true;
    }

    private void setResult() {
        Scale inputScale = (Scale) guiForm.getInputScale().getSelectedItem();
        Scale resultScale = (Scale) guiForm.getOutScale().getSelectedItem();

        ConvertController converter;

        if (checkUserInput()) {
            double inputTemperature = Double.parseDouble(guiForm.getInputTemp().getText());
            converter = new ConvertController(inputScale, resultScale, inputTemperature);
            double resultTemperature = converter.convert();

            guiForm.getLbResult().setText(DecimalFormat.getNumberInstance(Locale.ENGLISH).format(resultTemperature));
            guiForm.getLbResult().setForeground(converter.setColor());
        }
    }
}
