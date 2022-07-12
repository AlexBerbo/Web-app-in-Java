package serlvets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminObrisiMenadzera
 */
@WebServlet("/AdminObrisiMenadzera")
public class AdminObrisiMenadzera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminObrisiMenadzera() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st=con.createStatement();
			st.executeUpdate("delete from manager where idmanager='"+id+"';");
			st.close();
			con.close();
		} catch (Exception e) {
			request.setAttribute("poruka", "Greska u radu sa bazom!");
			request.getRequestDispatcher("AdminWelcome.jsp").forward(request, response);
		}
		request.setAttribute("poruka", "Uspesno ste obrisali menadzera!");
		request.getRequestDispatcher("AdminWelcome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
