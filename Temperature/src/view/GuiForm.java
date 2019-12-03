package view;

import javax.swing.*;
import java.awt.*;

public class GuiForm {
    private JFrame frame;
    private JPanel contentPane;
    private JPanel topPanel;
    private JLabel lb1SelectScale;
    private JComboBox<String> cb1Scales;
    private JTextField inputTemp;
    private JPanel midPanel;
    private JLabel lb2SelectScale;
    private JComboBox<String> cb2Scales;
    private JLabel lbResult;
    private JPanel botPanel;
    private JButton rbConvert;

    private final String CELSIUS = "Цельсий";
    private final String FAHRENHEIT = "Фаренгейт";
    private final String KELVIN = "Кельвин";

    public GuiForm() {
        frame = new JFrame("Конвертер температур");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(3, 1, 5, 5));

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

        lb1SelectScale = new JLabel("Выберите шкалу");
        lb1SelectScale.setFont(new Font(lb1SelectScale.getFont().getName(), Font.BOLD, 14));
        cb1Scales = new JComboBox<>(new String[]{CELSIUS, FAHRENHEIT, KELVIN});
        cb1Scales.setFont(new Font(cb1Scales.getFont().getName(), Font.BOLD, 14));
        inputTemp = new JTextField(5);
        inputTemp.setFont(new Font(inputTemp.getFont().getName(), Font.BOLD, 16));

        topPanel.add(lb1SelectScale);
        topPanel.add(cb1Scales);
        topPanel.add(inputTemp);

        midPanel = new JPanel();
        midPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

        lb2SelectScale = new JLabel("Выберите шкалу");
        lb2SelectScale.setFont(new Font(lb2SelectScale.getFont().getName(), Font.BOLD, 14));
        cb2Scales = new JComboBox<>(new String[]{CELSIUS, FAHRENHEIT, KELVIN});
        cb2Scales.setFont(new Font(cb2Scales.getFont().getName(), Font.BOLD, 14));
        lbResult = new JLabel();
        lbResult.setFont(new Font(lbResult.getFont().getName(), Font.BOLD, 18));

        midPanel.add(lb2SelectScale);
        midPanel.add(cb2Scales);
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

    public JComboBox<String> getCb1Scales() {
        return cb1Scales;
    }

    public JTextField getInputTemp() {
        return inputTemp;
    }

    public JComboBox<String> getCb2Scales() {
        return cb2Scales;
    }

    public JLabel getLbResult() {
        return lbResult;
    }

    public JButton getRbConvert() {
        return rbConvert;
    }
}
