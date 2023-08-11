package com.jspm;
import javax.swing.*;
import java.awt.*;

public class WordCounterGUI1 extends JFrame {
    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public WordCounterGUI1() {
        setTitle("Word Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        countButton = new JButton("Count Words");
        countButton.addActionListener(e -> {
            String inputText = textArea.getText();
            int wordCount = countWords(inputText);
            resultLabel.setText("Total words: " + wordCount);
        });

        resultLabel = new JLabel("Total words: ");
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(countButton);
        bottomPanel.add(resultLabel);
        add(bottomPanel, BorderLayout.SOUTH);

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private int countWords(String input) {
        String[] words = input.split("\\W+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WordCounterGUI::new);
    }
}
