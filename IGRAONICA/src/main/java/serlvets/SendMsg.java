package serlvets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMsg
 */
@WebServlet("/SendMsg")
public class SendMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMsg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		
		try {
			Class.forName("com.jdbc.mysql.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			
		} catch (SQLException e){
			String errormsg=e.getMessage();
			if(con!=null) {
				try {
					con.close();
				}catch (SQLException ex){
					errormsg+=ex.getMessage();
				}
				
			}
			request.setAttribute("errormsg", errormsg);
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}
		catch (ClassNotFoundException e) {
			request.setAttribute("poruka", "Nije ucitan drajver!: " + e);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		request.setAttribute("poruka", "Uspesno ste poslali poruku!");
		request.getRequestDispatcher("SendMsg.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
