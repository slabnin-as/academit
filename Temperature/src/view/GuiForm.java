package view;

import model.CelsiusScale;
import model.FahrenheitScale;
import model.KelvinScale;
import model.Scale;

import javax.swing.*;
import java.awt.*;

public class GuiForm {
    private JComboBox<Scale> inputScale;
    private JTextField inputTemp;
    private JComboBox<Scale> outScale;
    private JLabel lbResult;
    private JButton rbConvert;
    private Scale[] scales;

    public GuiForm() {
        Scale[] scales = {new CelsiusScale(), new KelvinScale(), new FahrenheitScale()};

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
    }

    public JComboBox<Scale> getInputScale() {
        return inputScale;
    }

    public JTextField getInputTemp() {
        return inputTemp;
    }

    public JComboBox<Scale> getOutScale() {
        return outScale;
    }

    public JLabel getLbResult() {
        return lbResult;
    }

    public JButton getRbConvert() {
        return rbConvert;
    }

    public void showErrorMessage() {
        JOptionPane.showMessageDialog(null, "Введите число!", "Неверный ввод", JOptionPane.ERROR_MESSAGE);
    }
}

