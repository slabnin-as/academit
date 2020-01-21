package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Locale;

public class GuiForm {
    private JComboBox<Scale> inputScale;
    private JTextField inputTemperature;
    private JComboBox<Scale> outputScale;
    private JLabel resultField;
    private JButton convertButton;

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
            inputTemperature = new JTextField(5);
            inputTemperature.setFont(new Font(inputTemperature.getFont().getName(), Font.BOLD, 16));

            topPanel.add(lbInputScale);
            topPanel.add(inputScale);
            topPanel.add(inputTemperature);

            JPanel middlePanel = new JPanel();
            middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

            JLabel lbOutputScale = new JLabel("Выберите шкалу");
            lbOutputScale.setFont(new Font(lbOutputScale.getFont().getName(), Font.BOLD, 14));
            outputScale = new JComboBox<>(scales);
            outputScale.setFont(new Font(outputScale.getFont().getName(), Font.BOLD, 14));
            resultField = new JLabel();
            resultField.setFont(new Font(resultField.getFont().getName(), Font.BOLD, 18));

            middlePanel.add(lbOutputScale);
            middlePanel.add(outputScale);
            middlePanel.add(resultField);

            JPanel bottomPanel = new JPanel();
            bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

            convertButton = new JButton("Перевести");
            convertButton.setFont(new Font(convertButton.getFont().getName(), Font.BOLD, 14));
            convertButton.addActionListener(e -> setResult());

            bottomPanel.add(convertButton);

            contentPane.add(topPanel);
            contentPane.add(middlePanel);
            contentPane.add(bottomPanel);

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
        return outputScale;
    }

    private void showErrorMessage() {
        JOptionPane.showMessageDialog(null, "Введите число!", "Неверный ввод", JOptionPane.ERROR_MESSAGE);
    }

    private void setResult() {
        Scale inputScale = (Scale) getInputScale().getSelectedItem();
        Scale resultScale = (Scale) getOutputScale().getSelectedItem();

        try {
            double inputTemperature = Double.parseDouble(this.inputTemperature.getText());
            Converter converter = new Converter(inputScale, resultScale);
            double resultTemperature = converter.convert(inputTemperature);

            resultField.setText(DecimalFormat.getNumberInstance(Locale.ENGLISH).format(resultTemperature));
            resultField.setForeground(converter.useColor());
        } catch (NumberFormatException e) {
            showErrorMessage();
        }
    }
}

