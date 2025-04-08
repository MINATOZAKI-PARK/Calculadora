import javax.swing.*;
import java.awt.*;


public class InterfazCalculadora {
    private JTextField pantalla;

    public InterfazCalculadora() {
        // Crear la ventana principal de la calculadora
        JFrame ventana = new JFrame("Calculadora");
        ventana.setSize(300, 400); // Establecer tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar el cierre
        ventana.setLayout(new BorderLayout()); // Establecer el layout principal

        // Crear el campo de texto donde se mostrará la expresión y el resultado
        pantalla = new JTextField();
        pantalla.setEditable(false); // Hacer que no sea editable por el usuario
        pantalla.setFont(new Font("Arial", Font.BOLD, 24)); // Ajustar la fuente del texto
        ventana.add(pantalla, BorderLayout.NORTH); // Añadir el campo de texto en la parte superior

        // Crear el panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4, 5, 5)); // Configurar un grid de 4x4 con espacios

        // Definir los textos de los botones de la calculadora
        String[] botones = {
                "7", "8", "9", "/", // Fila 1
                "4", "5", "6", "*", // Fila 2
                "1", "2", "3", "-", // Fila 3
                "C", "0", "=", "+"  // Fila 4
        };

        // Crear cada botón y añadirle sus funcionalidades
        for (String texto : botones) {
            JButton boton = new JButton(texto); // Crear un botón con el texto especificado
            boton.setFont(new Font("Arial", Font.BOLD, 18)); // Ajustar la fuente del botón
            panelBotones.add(boton); // Añadir el botón al panel de botones

            // Configurar el listener para manejar las acciones del botón
            boton.addActionListener(e -> {
                String comando = e.getActionCommand(); // Obtener el texto del botón presionado

                switch (comando) {
                    case "C":
                        pantalla.setText(""); // Limpiar la pantalla si se presiona "C"
                        break;
                    case "=":
                        String expresion = pantalla.getText(); // Obtener la expresión actual
                        String resultado = CalculadoraLogica.evaluarOperacion(expresion); // Evaluar la operación
                        pantalla.setText(resultado); // Mostrar el resultado en la pantalla
                        break;
                    default:
                        pantalla.setText(pantalla.getText() + comando); // Añadir el texto del botón a la pantalla
                        break;
                }
            });
        }

        ventana.add(panelBotones, BorderLayout.CENTER); // Añadir el panel de botones al centro
        ventana.setVisible(true); // Hacer visible la ventana de la calculadora
    }
}
