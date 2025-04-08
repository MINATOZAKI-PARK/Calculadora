public class CalculadoraLogica {
    public static String evaluarOperacion(String expr) {
        // Elimina todos los espacios de la expresión de entrada
        expr = expr.replaceAll(" ", "");
        char operador = 0;
        int pos = -1;

        // Recorre la expresión para encontrar el operador y su posición
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operador = c; // Guarda el operador encontrado
                pos = i; // Guarda la posición del operador
                break;
            }
        }

        // Si no se encuentra un operador, retorna la expresión tal cual
        if (pos == -1) return expr;

        try {
            // Divide la expresión en dos números según la posición del operador
            double num1 = Double.parseDouble(expr.substring(0, pos));
            double num2 = Double.parseDouble(expr.substring(pos + 1));
            double resultado;

            // Realiza la operación según el operador encontrado
            switch (operador) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) return "Error"; // Evita la división por cero
                    resultado = num1 / num2;
                    break;
                default:
                    return "Error"; // Retorna error si el operador no es válido
            }

            // Retorna el resultado sin decimales si es un número entero
            if (resultado == (int) resultado) {
                return String.valueOf((int) resultado);
            } else {
                return String.valueOf(resultado); // Retorna el resultado con decimales
            }
        } catch (NumberFormatException e) {
            return "Error"; // Retorna error si no se puede convertir los números
        }
    }
}
