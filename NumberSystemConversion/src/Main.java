import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JTextField inputField, outputField;
    private JButton decToBinButton, decToOctButton, decToHexButton;
    private JButton binToDecButton, binToOctButton, binToHexButton;
    private JButton octToDecButton, octToBinButton, octToHexButton;
    private JButton hexToDecButton, hexToBinButton, hexToOctButton;

    public Main() {
        // Set up the frame
        setTitle("Number System Converter");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Input and Output Panel
        JPanel ioPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        ioPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ioPanel.add(new JLabel("Enter Number:", JLabel.RIGHT));
        inputField = new JTextField(20);
        inputField.setFont(new Font("Arial", Font.PLAIN, 20));
        ioPanel.add(inputField);

        ioPanel.add(new JLabel("Converted Output:", JLabel.RIGHT));
        outputField = new JTextField(20);
        outputField.setEditable(false);
        outputField.setFont(new Font("Arial", Font.PLAIN, 20));
        ioPanel.add(outputField);

        add(ioPanel, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Initialize buttons
        decToBinButton = new JButton("Decimal to Binary");
        decToOctButton = new JButton("Decimal to Octal");
        decToHexButton = new JButton("Decimal to Hexadecimal");
        binToDecButton = new JButton("Binary to Decimal");
        binToOctButton = new JButton("Binary to Octal");
        binToHexButton = new JButton("Binary to Hexadecimal");
        octToDecButton = new JButton("Octal to Decimal");
        octToBinButton = new JButton("Octal to Binary");
        octToHexButton = new JButton("Octal to Hexadecimal");
        hexToDecButton = new JButton("Hexadecimal to Decimal");
        hexToBinButton = new JButton("Hexadecimal to Binary");
        hexToOctButton = new JButton("Hexadecimal to Octal");

        // Add buttons to the panel in the planned layout
        buttonPanel.add(decToBinButton);
        buttonPanel.add(decToOctButton);
        buttonPanel.add(decToHexButton);
        buttonPanel.add(binToDecButton);
        buttonPanel.add(binToOctButton);
        buttonPanel.add(binToHexButton);
        buttonPanel.add(octToDecButton);
        buttonPanel.add(octToBinButton);
        buttonPanel.add(octToHexButton);
        buttonPanel.add(hexToDecButton);
        buttonPanel.add(hexToBinButton);
        buttonPanel.add(hexToOctButton);

        // Set font and add action listeners
        JButton[] buttons = {
                decToBinButton, decToOctButton, decToHexButton,
                binToDecButton, binToOctButton, binToHexButton,
                octToDecButton, octToBinButton, octToHexButton,
                hexToDecButton, hexToBinButton, hexToOctButton
        };

        for (JButton button : buttons) {
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.addActionListener(this);
        }

        add(buttonPanel, BorderLayout.CENTER);

        // Set the frame to be visible
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText().trim();
        String output = "";

        try {
            if (e.getSource() == decToBinButton) {
                validateDecimal(input);
                int decNum = Integer.parseInt(input);
                output = Integer.toBinaryString(decNum);
            } else if (e.getSource() == decToOctButton) {
                validateDecimal(input);
                int decNum = Integer.parseInt(input);
                output = Integer.toOctalString(decNum);
            } else if (e.getSource() == decToHexButton) {
                validateDecimal(input);
                int decNum = Integer.parseInt(input);
                output = Integer.toHexString(decNum).toUpperCase();
            } else if (e.getSource() == binToDecButton) {
                validateBinary(input);
                int binNum = Integer.parseInt(input, 2);
                output = String.valueOf(binNum);
            } else if (e.getSource() == binToOctButton) {
                validateBinary(input);
                int binNum = Integer.parseInt(input, 2);
                output = Integer.toOctalString(binNum);
            } else if (e.getSource() == binToHexButton) {
                validateBinary(input);
                int binNum = Integer.parseInt(input, 2);
                output = Integer.toHexString(binNum).toUpperCase();
            } else if (e.getSource() == octToDecButton) {
                validateOctal(input);
                int octNum = Integer.parseInt(input, 8);
                output = String.valueOf(octNum);
            } else if (e.getSource() == octToBinButton) {
                validateOctal(input);
                int octNum = Integer.parseInt(input, 8);
                output = Integer.toBinaryString(octNum);
            } else if (e.getSource() == octToHexButton) {
                validateOctal(input);
                int octNum = Integer.parseInt(input, 8);
                output = Integer.toHexString(octNum).toUpperCase();
            } else if (e.getSource() == hexToDecButton) {
                validateHexadecimal(input);
                int hexNum = Integer.parseInt(input, 16);
                output = String.valueOf(hexNum);
            } else if (e.getSource() == hexToBinButton) {
                validateHexadecimal(input);
                int hexNum = Integer.parseInt(input, 16);
                output = Integer.toBinaryString(hexNum);
            } else if (e.getSource() == hexToOctButton) {
                validateHexadecimal(input);
                int hexNum = Integer.parseInt(input, 16);
                output = Integer.toOctalString(hexNum);
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            output = "";
        }

        outputField.setText(output);
    }

    // Validation Methods
    private void validateDecimal(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid decimal number. Only digits 0-9 are allowed.");
        }
    }

    private void validateBinary(String input) {
        if (!input.matches("[01]+")) {
            throw new IllegalArgumentException("Invalid binary number. Only digits 0 and 1 are allowed.");
        }
    }

    private void validateOctal(String input) {
        if (!input.matches("[0-7]+")) {
            throw new IllegalArgumentException("Invalid octal number. Only digits 0-7 are allowed.");
        }
    }

    private void validateHexadecimal(String input) {
        if (!input.matches("[0-9a-fA-F]+")) {
            throw new IllegalArgumentException("Invalid hexadecimal number. Only digits 0-9 and letters A-F are allowed.");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
