/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;
import javax.swing.*;
import java.awt.*;
import javax.swing.InputVerifier;

public class IntegerInputVerifier extends InputVerifier {
    @Override
    public boolean verify(JComponent input) {
        JTextField textField = (JTextField) input;
        String text = textField.getText().trim();
        
        // Permite campos vacíos o números enteros
        if (text.isEmpty()) {
            return true;
        }
        return text.matches("-?\\d+"); // Enteros con/sin signo
    }

    @Override
    public boolean shouldYieldFocus(JComponent input) {
        JTextField textField = (JTextField) input;
        String text = textField.getText().trim();
        
        // Solo muestra error si el campo no está vacío y es inválido
        if (!text.isEmpty() && !verify(input)) {
            JOptionPane.showMessageDialog(
                input,
                "Solo puede ingresar números enteros (Ej: 5, -10)",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        return true;
    }
}