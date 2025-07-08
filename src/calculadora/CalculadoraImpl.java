package calculadora;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7247705560237098373L;

	public CalculadoraImpl() throws RemoteException {
        super();
    }

    @Override
    public double somar(double a, double b) {
        System.out.println("[Servidor] Somando " + a + " + " + b);
        return a + b;
    }

    @Override
    public double subtrair(double a, double b) {
        System.out.println("[Servidor] Subtraindo " + a + " - " + b);
        return a - b;
    }

    @Override
    public double multiplicar(double a, double b) {
        System.out.println("[Servidor] Multiplicando " + a + " * " + b);
        return a * b;
    }

    @Override
    public double dividir(double a, double b) {
        System.out.println("[Servidor] Dividindo " + a + " / " + b);
        if (b == 0) throw new ArithmeticException("Divisão por zero");
        return a / b;
    }
}