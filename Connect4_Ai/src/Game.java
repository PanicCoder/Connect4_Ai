public class Game{
	public static void main(String[] args){
		new Spiel();
		ZEICHENFENSTER.gibFenster().warte(1000);
		System.out.println("ende");
		System.exit(0);
	}
}