package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import calculadora.Calculadora;

public class Client_1 {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			Calculadora calc = (Calculadora) registry.lookup("CalculadoraService");

			while (true) {
				System.out.print("\nOperação (soma, subtrai, multiplica, divide) ou 'sair': ");
				String op = scanner.nextLine().toLowerCase();

				if (op.equals("sair")) {
					System.out.println("Encerrando cliente...");
					break;
				}

				System.out.print("Digite o primeiro número: ");
				double a = scanner.nextDouble();
				System.out.print("Digite o segundo número: ");
				double b = scanner.nextDouble();
				scanner.nextLine();

				try {
					double resultado = switch (op) {
					case "soma" -> calc.somar(a, b);
					case "subtrai" -> calc.subtrair(a, b);
					case "multiplica" -> calc.multiplicar(a, b);
					case "divide" -> calc.dividir(a, b);
					default -> {
						System.out.println("Operação inválida.");
						yield Double.NaN;
					}
					};
					if (!Double.isNaN(resultado)) {
						System.out.println("Resultado: " + resultado);
					}
				} catch (ArithmeticException e) {
					System.out.println("Erro: " + e.getMessage());
				}
			}

		} catch (Exception e) {
			System.err.println("Erro no cliente: " + e.getMessage());
			e.printStackTrace();
		}
	}
}