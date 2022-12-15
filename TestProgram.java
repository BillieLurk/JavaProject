// Denna klass ingår INTE i uppgiften. Den kan användas om du vill testköra koden med dina egna tester. 
// Klicka på "raketen" för att kompilera och köra detta program.
package JavaProject;

public class TestProgram {

	public static void main(String[] args) {
		System.out.println("**********************************************************");
		System.out.println("* Obs! detta är bara en testkörning av dina egna tester. *");
		System.out.println("* För att få poäng på frågan måste du köra utvärderingen.*");
		System.out.println("* (Ikonen med en kryssruta och en siffra.)               *");
		System.out.println("**********************************************************");
		System.out.println();
		
		SpaceInvader invader = new SpaceInvader(1, 2);

		invader.move();

		System.out.println(invader.getX());
		System.out.println(invader.getY());

	}

}