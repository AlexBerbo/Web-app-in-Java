package serlvets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminObrisiIgraonice
 */
@WebServlet("/AdminObrisiIgraonice")
public class AdminObrisiIgraonice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminObrisiIgraonice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Connection con=null;
		Statement st, st2=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st=con.createStatement();
			st.executeUpdate("delete from igraonica where idigraonica='"+id+"';");
			st2=con.createStatement();
			st2.executeUpdate("delete from manager where idigraonica='"+id+"';");
			st.close();
			st2.close();
			con.close();
		} catch (Exception e) {
			request.setAttribute("poruka", "Greska u bazi");
			request.getRequestDispatcher("AdminWelcome.jsp").forward(request, response);
		}
		request.setAttribute("poruka", "Uspesno ste obrisali igraonicu i menadzera koji je zaposlen za tu igraonicu!");
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
