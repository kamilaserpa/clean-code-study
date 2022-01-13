package refactown.cleancode.c03functions;

public class CommandQuery {

	public static boolean sett(String attribute, String value) {
		return true;
	}

	public static boolean attributeExists(String attribute) {
		return true;
	}
	
	public static void setAttribute(String attribute, String value) {
		
	}

	public static void main(String[] args) {
		if (sett("username", "bill")) {} // Consulta e comando (deve ser evitado)

	    if (attributeExists("username")){ // Apenas Consulta
	        setAttribute("username", "bill"); // Apenas Comando (melhor)
	    }
	}
}
