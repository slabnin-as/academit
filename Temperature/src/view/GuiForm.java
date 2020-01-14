package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class GuiForm {
    private JComboBox<Scale> inputScale;
    private JTextField inputTemp;
    private JComboBox<Scale> outScale;
    private JLabel lbResult;
    private JButton rbConvert;

    public GuiForm(Scale[] scales) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Конвертер температур");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel contentPane = new JPanel();
            contentPane.setLayout(new GridLayout(3, 1, 5, 5));

            JPanel topPanel = new JPanel();
            topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

            JLabel lbInputScale = new JLabel("Выберите шкалу");
            lbInputScale.setFont(new Font(lbInputScale.getFont().getName(), Font.BOLD, 14));
            inputScale = new JComboBox<>(scales);
            inputScale.setFont(new Font(inputScale.getFont().getName(), Font.BOLD, 14));
            inputTemp = new JTextField(5);
            inputTemp.setFont(new Font(inputTemp.getFont().getName(), Font.BOLD, 16));

            topPanel.add(lbInputScale);
            topPanel.add(inputScale);
            topPanel.add(inputTemp);

            JPanel midPanel = new JPanel();
            midPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

            JLabel lbOutputScale = new JLabel("Выберите шкалу");
            lbOutputScale.setFont(new Font(lbOutputScale.getFont().getName(), Font.BOLD, 14));
            outScale = new JComboBox<>(scales);
            outScale.setFont(new Font(outScale.getFont().getName(), Font.BOLD, 14));
            lbResult = new JLabel();
            lbResult.setFont(new Font(lbResult.getFont().getName(), Font.BOLD, 18));

            midPanel.add(lbOutputScale);
            midPanel.add(outScale);
            midPanel.add(lbResult);

            JPanel botPanel = new JPanel();
            botPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

            rbConvert = new JButton("Перевести");
            rbConvert.setFont(new Font(rbConvert.getFont().getName(), Font.BOLD, 14));

            botPanel.add(rbConvert);

            contentPane.add(topPanel);
            contentPane.add(midPanel);
            contentPane.add(botPanel);

            frame.setContentPane(contentPane);
            frame.pack();
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private JComboBox<Scale> getInputScale() {
        return inputScale;
    }

    private JComboBox<Scale> getOutputScale() {
        return outScale;
    }

    public JButton getConvertButton() {
        return rbConvert;
    }

    private void showErrorMessage() {
        JOptionPane.showMessageDialog(null, "Введите число!", "Неверный ввод", JOptionPane.ERROR_MESSAGE);
    }

    private boolean checkUserInput() {
        Scanner scanner = new Scanner(inputTemp.getText());
        scanner.useLocale(Locale.ENGLISH);
        if (!scanner.hasNextDouble()) {
            showErrorMessage();
            return false;
        }

        return true;
    }

    public void setResult() {
        Scale inputScale = (Scale) getInputScale().getSelectedItem();
        Scale resultScale = (Scale) getOutputScale().getSelectedItem();

        if (checkUserInput()) {
            double inputTemperature = Double.parseDouble(inputTemp.getText());
            Converter converter = new Converter(inputScale, resultScale, inputTemperature);
            double resultTemperature = converter.convert();

            lbResult.setText(DecimalFormat.getNumberInstance(Locale.ENGLISH).format(resultTemperature));
            lbResult.setForeground(converter.setColor());
        }
    }
}

