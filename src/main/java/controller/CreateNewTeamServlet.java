package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Character;
import model.Creator;
import model.Team;
/**
 * Servlet implementation class CreateNewTeamServlet
 */
@WebServlet("/createNewTeamServlet")
public class CreateNewTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CharacterHelper ch = new CharacterHelper();
		String listName = request.getParameter("listName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String creatorName = request.getParameter("creator");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		String[] selectedCharacters = request.getParameterValues("allCharactersToAdd");
		List<Character> selectedCharactersInTeam = new ArrayList<Character>();
		if(selectedCharacters != null && selectedCharacters.length > 0) {
			for(int i = 0; i < selectedCharacters.length; i++) {
				System.out.println(selectedCharacters[i]);
				Character c = ch.findCharacterID(Integer.parseInt(selectedCharacters[i]));
				selectedCharactersInTeam.add(c);
			}
		}
		Creator creator = new Creator(creatorName);
		Team team = new Team(listName, ld, creator);
		team.setCharactersList(selectedCharactersInTeam);
		TeamHelper th = new TeamHelper();
		th.addNewTeam(team);
		
		getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
