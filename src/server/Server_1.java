package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import calculadora.Calculadora;
import calculadora.CalculadoraImpl;

public class Server_1 {
	public static void main(String[] args) {
		try {
			Calculadora calc = new CalculadoraImpl();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("CalculadoraService", calc);
			System.out.println("Servidor RMI pronto na porta 1099...");
		} catch (Exception e) {
			System.err.println("Erro no servidor: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
