package refactown.cleancode.c03functions.employee;

public class SalariedEmployee extends Employee{

	public SalariedEmployee(String name) {
		super(name, Type.SALARIED);
	}

	// Abstrai o calculo do pagamento do outros lugares da aplicação, centralizando-o no proprio objeto referente à Assalariado
	@Override
	public double calculatePay() {
		return 3.0;
	}

}
