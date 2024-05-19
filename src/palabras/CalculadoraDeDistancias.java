package palabras;


public class CalculadoraDeDistancias {

    // Método que calcula la distancia de edición entre dos palabras
    public int calcularDistanciaDeEdicion(String palabra1, String palabra2) {
        int longitud1 = palabra1.length();
        int longitud2 = palabra2.length();

        // Matriz para almacenar los valores de distancia de edición
        int[][] distancia = new int[longitud1 + 1][longitud2 + 1];

        // Inicializar la primera fila y columna de la matriz
        for (int i = 0; i <= longitud1; i++) {
            distancia[i][0] = i; // Coste de eliminar caracteres de palabra1
        }
        for (int j = 0; j <= longitud2; j++) {
            distancia[0][j] = j; // Coste de añadir caracteres a palabra1
        }

        // Calcular la distancia de edición
        for (int i = 1; i <= longitud1; i++) {
            for (int j = 1; j <= longitud2; j++) {
                int costoSubstitucion = distancia[i - 1][j - 1];
                if (palabra1.charAt(i - 1) != palabra2.charAt(j - 1)) {
                    costoSubstitucion += 1; // Si los caracteres no coinciden, coste de sustitución es 1
                }

                // Calcular el coste mínimo entre las tres operaciones posibles
                distancia[i][j] = Math.min(distancia[i - 1][j] + 1, // Eliminación
                                           Math.min(distancia[i][j - 1] + 1, // Inserción
                                                    costoSubstitucion)); // Sustitución
            }
        }

        // Retornar la distancia de edición que se encuentra en distancia[longitud1][longitud2]
        return distancia[longitud1][longitud2];
    }

    // Método main que toma las palabras como argumentos de la línea de comandos
    public static void main(String[] args) {
        // Verificar si se proporcionaron exactamente dos argumentos
        if (args.length != 2) {
            System.out.println("Por favor, proporciona exactamente dos palabras como argumentos.");
            return; // Salir del método si no se proporcionaron exactamente dos palabras
        }

        // Obtener las palabras de los argumentos
        String palabra1 = args[0];
        String palabra2 = args[1];

        // Crear una instancia de la calculadora de distancias y calcular la distancia
        CalculadoraDeDistancias calculadora = new CalculadoraDeDistancias();
        int distancia = calculadora.calcularDistanciaDeEdicion(palabra1, palabra2);

        // Mostrar el resultado
        System.out.println("La distancia de edición entre '" + palabra1 + "' y '" + palabra2 + "' es: " + distancia);
    }
}
