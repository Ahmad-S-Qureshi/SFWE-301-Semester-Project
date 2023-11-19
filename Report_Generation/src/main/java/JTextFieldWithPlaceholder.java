package main.java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class JTextFieldWithPlaceholder extends JTextField {

    private String placeholder;
    private boolean placeholderActive;

    public JTextFieldWithPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        this.placeholderActive = true;

        // Set the initial placeholder
        setPlaceholder();

        // Add a focus listener to handle placeholder behavior
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (placeholderActive) {
                    setForeground(Color.BLACK);
                    setText("");
                    placeholderActive = false;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setPlaceholder();
                }
            }
        });
    }

    private void setPlaceholder() {
        setForeground(Color.GRAY);
        setText(placeholder);
        placeholderActive = true;
    }
}
