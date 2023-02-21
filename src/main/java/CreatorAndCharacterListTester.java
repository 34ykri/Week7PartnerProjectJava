

import model.Creator;

import java.time.LocalDate;
import java.util.List;

import controller.CharacterListHelper;
import controller.CreatorHelper;
import model.Character;
import model.CharacterList;
public class CreatorAndCharacterListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Creator cloud = new Creator("Cloud");
		CreatorHelper ch = new CreatorHelper();
		ch.addCreator(cloud);
		//Create new list with list name, date, and creator
		CharacterListHelper clh = new CharacterListHelper();
		CharacterList cloudCharacters = new CharacterList("Cloud's List", LocalDate.now(), cloud);
		clh.addNewCharacterList(cloudCharacters);
		List<CharacterList> allCharLists = clh.getCharacterLists();
		for(CharacterList c : allCharLists) {
			System.out.println(c.toString());
		}
		
		
	}

}
