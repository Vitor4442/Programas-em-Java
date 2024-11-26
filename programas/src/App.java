public class App {
    public static void main(String[] args) throws Exception {
        String expressao = "a - b * c + d";
        String saida = converterParaPosFixa(expressao);
        System.out.println("Resultado da conversão: " + saida);
        calcularSequencia(saida); 
		
    }
    private static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static String converterParaPosFixa(String expressao) {
        PilhaC pilha = new PilhaC();
        FilaC fila = new FilaC();
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            if (Character.isLetterOrDigit(caractere)) {
                fila.push(caractere);
            } else if (caractere == '+' || caractere == '-' || caractere == '*' || caractere == '/') {
                while (!pilha.isEmpty()) {
                    char operadorTemporario = pilha.pop();
                    if (precedencia(operadorTemporario) >= precedencia(caractere)) {
                        fila.push(operadorTemporario);
                    } else {
                        pilha.push(operadorTemporario);
                        break;
                    }
                }
                pilha.push(caractere);
            } else if (caractere == '(') {
                pilha.push(caractere);
            } else if (caractere == ')') {
                while (!pilha.isEmpty()) {
                    char operadorTemporario = pilha.pop();
                    if (operadorTemporario == '(') {
                        break;
                    } else {
                        fila.push(operadorTemporario);
                    }
                }
            }
        }

        while (!pilha.isEmpty()) {
            fila.push(pilha.pop());
        }

        while (!fila.isEmpty()) {
            resultado.append(fila.pop());
        }

        return resultado.toString();
    }

    public static void calcularSequencia(String posFixa) {
        PilhaC pilha = new PilhaC();
        int contador = 0;
    
        for (int i = 0; i < posFixa.length(); i++) {
            char caractere = posFixa.charAt(i);
    
            if (Character.isLetter(caractere)) {
                pilha.push(caractere);
            } else {
                String operand2 = String.valueOf(pilha.pop());
                String operand1 = String.valueOf(pilha.pop());
                contador++;
                String tempResult = "t" + contador;
    
                System.out.println(tempResult + " = " + operand1 + " " + caractere + " " + operand2);
                
                pilha.push(tempResult.charAt(1));
            }
        }
    
        String resultadoFinal = "t" + contador;
        System.out.println("Resultado final: x = " + resultadoFinal);
    }
}

