/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import javax.swing.*;
import java.awt.*;
import javax.swing.InputVerifier;

public class DoubleInputVerifier extends InputVerifier {
    @Override
    public boolean verify(JComponent input) {
        JTextField textField = (JTextField) input;
        String text = textField.getText().trim();
        
        // Permite campos vacíos o números decimales
        if (text.isEmpty()) {
            return true;
        }
        return text.matches("-?\\d+(\\.\\d+)?") ||  // Ej: 123.45
               text.matches("-?\\.\\d+");           // Ej: .45
    }

    @Override
    public boolean shouldYieldFocus(JComponent input) {
        JTextField textField = (JTextField) input;
        String text = textField.getText().trim();
        
        // Solo muestra error si el campo no está vacío y es inválido
        if (!text.isEmpty() && !verify(input)) {
            JOptionPane.showMessageDialog(
                input,
                "Solo puede ingresar números decimales (Ej: 3.14, -0.5)",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        return true;
    }
}