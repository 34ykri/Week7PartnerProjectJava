import java.util.List;
import java.util.Scanner;

import controller.CharacterHelper;
import model.Character;

public class CharacterTester {
	static Scanner in = new Scanner(System.in);
	static CharacterHelper ch = new CharacterHelper();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean runProgram = true;
		while(runProgram) {
			System.out.println("Character Creator Tester");
			System.out.println("1: Create Character");
			System.out.println("2: Edit Character");
			System.out.println("3: Delete Character");
			System.out.println("4: View Characters");
			System.out.println("4: Exit App");

			System.out.print("Select: ");
			int select = in.nextInt();
			in.nextLine();
			
			switch (select){
			case 1:
				addCharacter();
				break;
			case 2:
				editCharacter();
				break;
			case 3:
				deleteCharacter();
				break;
			case 4:
				viewCharacters();
				break;
			case 5:
				System.out.println("Thanks for using the app");
				runProgram = false;
				break;
			default:
				System.out.println("Try again");
				break;
				
			}
		}
	}

	private static void viewCharacters() {
		// TODO Auto-generated method stub
		List<Character> allCharacters = ch.showAllCharacters();
		System.out.println("");
		for(Character ch : allCharacters) {
			System.out.print(ch.toString());
		}
		System.out.println("");

	}

	private static void deleteCharacter() {
		// TODO Auto-generated method stub
		System.out.println("\nDELETE CHARACTER");
		System.out.print("Enter Character Name: ");
		String name = in.nextLine();
		System.out.print("Enter Class Name: ");
		String chClass = in.nextLine();
		Character delete = new Character(name, chClass);
		ch.deleteCharacter(delete);
	}

	private static void editCharacter() {
		// TODO Auto-generated method stub
		System.out.println("\nEDIT CHARACTER");
		System.out.print("Enter Character Name: ");
		String name = in.nextLine();
		System.out.print("Enter Class Name: ");
		String chClass = in.nextLine();
		Character find = new Character(name, chClass);
		Character found = ch.findCharacter(find);
		if(found != null){
			boolean runEdit = true;
			
			while(runEdit) {
				System.out.println("");
				System.out.println("Found Character: " + found.toString());
				System.out.println("1: Edit Character Name ");
				System.out.println("2: Edit Class Name ");
				System.out.println("3: Edit Race ");
				System.out.println("4: Edit Level ");
				System.out.println("5: Save ");
				System.out.print("Make Selection: ");
				int makeSelection = in.nextInt();
				in.nextLine();
				if(makeSelection == 1) {
					System.out.print("Enter Character Name: ");
					String editName = in.nextLine();
					found.setCharacterName(editName);
				}
				else if(makeSelection == 2) {
					System.out.print("Enter Class Name: ");
					String charClass = in.nextLine();
					found.setCharacterClass(charClass);
				}
				else if(makeSelection == 3) {
					System.out.print("Enter Race: ");
					String race = in.nextLine();
					found.setCharacterRace(race);
				}
				else if(makeSelection == 4) {
					System.out.print("Enter Level: ");
					int level = in.nextInt();
					found.setCharacterLevel(level);
				}
				else {
					runEdit = false;
					ch.editCharacter(found);
				}
				System.out.println("");
			}
		}
	}

	private static void addCharacter() {
		// TODO Auto-generated method stub
		System.out.println("\nADD CHARACTER");
		System.out.print("Enter Character Name: ");
		String name = in.nextLine();
		System.out.print("Enter Class Name: ");
		String chClass = in.nextLine();
		System.out.print("Enter Race: ");
		String race = in.nextLine();
		System.out.print("Enter Level: ");
		int level = in.nextInt();
		Character add = new Character(name, chClass, race, level);
		ch.addCharacter(add);
		System.out.println("");
		
	}

}
