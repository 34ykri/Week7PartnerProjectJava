package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Team;

/**
 * Servlet implementation class TeamNavigationServlet
 */
@WebServlet("/teamNavigationServlet")
public class TeamNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TeamHelper th = new TeamHelper();
		String act = request.getParameter("doThisToItem");

		if(act == null) {
			getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
		}
		else if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Team deleteTeam = th.searchTeamByID(tempId);
				th.deleteTeam(deleteTeam);
			} catch(NumberFormatException e) {
				System.out.println("Nothing was selected");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
			}
		}
		else if(act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Team editTeam = th.searchTeamByID(tempId);
				request.setAttribute("editTeam", editTeam);
				request.setAttribute("month", editTeam.getDateCreated().getMonthValue());
				request.setAttribute("day", editTeam.getDateCreated().getDayOfMonth());
				request.setAttribute("year", editTeam.getDateCreated().getYear());

				CharacterHelper ch = new CharacterHelper();
				request.setAttribute("allCharacters", ch.showAllCharacters());
				if(ch.showAllCharacters().isEmpty()) {
					request.setAttribute("allCharacters", "");
				}
				getServletContext().getRequestDispatcher("/edit-team.jsp").forward(request, response);
			} 
			catch(NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
			}
		}
		else if(act.equals("add")) {
			getServletContext().getRequestDispatcher("/add-team.jsp").forward(request, response);
		}	
		
	}

}
