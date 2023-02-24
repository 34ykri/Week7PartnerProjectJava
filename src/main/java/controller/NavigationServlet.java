package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Character;
/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String act = request.getParameter("doThisToItem");
		String path = "/viewAllCharactersServlet";
		if(act.equals("add")) {
			path = "/index.html";
		} 
		else if(act.equals("delete")) 
		{
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Character delete = ch.findCharacterID(tempId);
				ch.deleteCharacter(delete);
			} 
			catch(NumberFormatException e) {
				System.out.println("Character not selected");
			}
		} 
		else if(act.equals("edit")) 
		{
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Character edit = ch.findCharacterID(tempId);
				request.setAttribute("itemToEdit", edit);
				path = "/edit-character.jsp";
			} 
			catch(NumberFormatException e) {
				System.out.println("Character not selected");
			}
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
