package serlvets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Manager;

/**
 * Servlet implementation class ManagerLogin
 */
@WebServlet("/ManagerLogin")
public class ManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLogin() {
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
		HttpSession session=request.getSession();
		String poruka, ime, prezime;
		int idigraonica;
		String username=request.getParameter("username1");
		String password=request.getParameter("password1");
		Manager manager=new Manager();
		manager.setUsername(username);
		manager.setPassword(password);
		session.setAttribute("manager", manager);
		session.setAttribute("username1", username);
		
		if(username.isEmpty() || password.isEmpty()) {
			poruka="Niste popunili sva polja!";
			request.setAttribute("poruka", poruka);
			request.getRequestDispatcher("ManagerLogin.jsp").forward(request, response);	
		}
		else if(username.equals("admin") && password.equals("admin")) {
			request.setAttribute("poruka", "Admin login Succesful");
			request.getRequestDispatcher("AdminWelcome.jsp").forward(request, response);
		}
		else {
			
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st=con.createStatement();
			String upit="select * from manager where username='"+username+"' and password='"+password+"';";
			rs=st.executeQuery(upit);
			if(rs.next()) {
				ime=rs.getString("ime");
				prezime=rs.getString("prezime");
				idigraonica=rs.getInt("idigraonica");
				manager.setIme(ime);
				manager.setPrezime(prezime);
				manager.setIdigraonica(idigraonica);
				st.close();
				con.close();
			}
			else {
				poruka="Neispravno korisnicko ime ili password!";
				request.setAttribute("poruka", poruka);
				manager.setPassword("");
				st.close();
				con.close();
				request.getRequestDispatcher("ManagerLogin.jsp").forward(request, response);
			}
		}
		catch (SQLException e){
			session.invalidate();
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
		
		request.setAttribute("poruka", "Login Succesful");
		request.getRequestDispatcher("ManagerWelcome.jsp").forward(request, response);
		}
	}

}
