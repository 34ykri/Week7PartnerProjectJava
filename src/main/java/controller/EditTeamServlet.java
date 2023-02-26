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

import model.Creator;
import model.Team;
import model.Character;
/**
 * Servlet implementation class EditTeamServlet
 */
@WebServlet("/editTeamServlet")
public class EditTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TeamHelper th = new TeamHelper();
		CharacterHelper ch = new CharacterHelper();
		CreatorHelper crh = new CreatorHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Team teamToEdit = th.searchTeamByID(tempId);
		String listName = request.getParameter("listName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String creatorName = request.getParameter("name");
		Creator newCreator = crh.findCreator(creatorName);
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} 
		catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		try {
			String[] selectedCharacters = request.getParameterValues("allCharacters");
			List<Character> selectedCharactersInTeam = new ArrayList<Character>();
			for(int i = 0; i < selectedCharacters.length; i++) {
				Character c = ch.findCharacterID(Integer.parseInt(selectedCharacters[i]));
				selectedCharactersInTeam.add(c);
			}
			teamToEdit.setCharactersList(selectedCharactersInTeam);
		} 
		catch(NullPointerException ex) {
			List<Character> selectedCharactersInTeam = new ArrayList<Character>();
			teamToEdit.setCharactersList(selectedCharactersInTeam);
		}
		teamToEdit.setListName(listName);
		teamToEdit.setDateCreated(ld);
		teamToEdit.setCreator(newCreator);
		th.editTeam(teamToEdit);
		getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
		
	}

}
