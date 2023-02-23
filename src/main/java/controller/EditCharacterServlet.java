package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Character;

/**
 * Servlet implementation class EditCharacterServlet
 */
@WebServlet("/editCharacterServlet")
public class EditCharacterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCharacterServlet() {
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
		CharacterHelper ch = new CharacterHelper();
		String name = request.getParameter("name");
		String cClass = request.getParameter("class");
		String race = request.getParameter("race");
		int level = Integer.parseInt(request.getParameter("level"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Character edit = ch.findCharacterID(tempId);
		edit.setCharacterName(name);
		edit.setCharacterClass(cClass);
		edit.setCharacterRace(race);
		edit.setCharacterLevel(level);
		ch.editCharacter(edit);
		getServletContext().getRequestDispatcher("/viewAllCharactersServlet").forward(request, response);
	}

}
