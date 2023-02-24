package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Character;

/**
 * Servlet implementation class AddCharacterServlet
 */
@WebServlet("/addCharacterServlet")
public class AddCharacterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCharacterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CharacterHelper ch = new CharacterHelper();
		String name = request.getParameter("name");
		String chClass = request.getParameter("class");
		String race = request.getParameter("race");
		int level = Integer.parseInt(request.getParameter("level"));
		Character newCharacter = new Character(name, chClass, race, level);
		ch.addCharacter(newCharacter);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
