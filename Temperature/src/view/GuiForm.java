package view;

import model.CelsiusScale;
import model.FahrenheitScale;
import model.KelvinScale;
import model.Scale;

import javax.swing.*;
import java.awt.*;

public class GuiForm {
    private JFrame frame;
    private JPanel contentPane;
    private JPanel topPanel;
    private JLabel lb1SelectScale;
    private JComboBox<Scale> inputScale;
    private JTextField inputTemp;
    private JPanel midPanel;
    private JLabel lb2SelectScale;
    private JComboBox<Scale> outScale;
    private JLabel lbResult;
    private JPanel botPanel;
    private JButton rbConvert;
    private Scale[] scales = {new CelsiusScale(),new KelvinScale(), new FahrenheitScale()};

    public GuiForm() {
        frame = new JFrame("Конвертер температур");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(3, 1, 5, 5));

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

        lb1SelectScale = new JLabel("Выберите шкалу");
        lb1SelectScale.setFont(new Font(lb1SelectScale.getFont().getName(), Font.BOLD, 14));
        inputScale = new JComboBox<>(scales);
        inputScale.setFont(new Font(inputScale.getFont().getName(), Font.BOLD, 14));
        inputTemp = new JTextField(5);
        inputTemp.setFont(new Font(inputTemp.getFont().getName(), Font.BOLD, 16));

        topPanel.add(lb1SelectScale);
        topPanel.add(inputScale);
        topPanel.add(inputTemp);

        midPanel = new JPanel();
        midPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

        lb2SelectScale = new JLabel("Выберите шкалу");
        lb2SelectScale.setFont(new Font(lb2SelectScale.getFont().getName(), Font.BOLD, 14));
        outScale = new JComboBox<>(scales);
        outScale.setFont(new Font(outScale.getFont().getName(), Font.BOLD, 14));
        lbResult = new JLabel();
        lbResult.setFont(new Font(lbResult.getFont().getName(), Font.BOLD, 18));

        midPanel.add(lb2SelectScale);
        midPanel.add(outScale);
        midPanel.add(lbResult);

        botPanel = new JPanel();
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
}
