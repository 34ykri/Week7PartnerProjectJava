

import model.Creator;

import java.time.LocalDate;
import java.util.List;

import controller.TeamHelper;
import controller.CreatorHelper;
import model.Character;
import model.Team;
public class CreatorAndCharacterListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Creator cloud = new Creator("Cloud");
		CreatorHelper ch = new CreatorHelper();
		ch.addCreator(cloud);
		//Create new list with list name, date, and creator
		TeamHelper clh = new TeamHelper();
		Team cloudCharacters = new Team("Cloud's List", LocalDate.now(), cloud);
		clh.addNewTeam(cloudCharacters);
		List<Team> allCharLists = clh.getTeams();
		for(Team c : allCharLists) {
			System.out.println(c.toString());
		}
		
		
	}

}
