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

import beans.Igraonica;

/**
 * Servlet implementation class AIzmenaIgraonice
 */
@WebServlet("/AdminIzmenaIgraonice")
public class AdminIzmenaIgraonice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminIzmenaIgraonice() {
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
		ResultSet rs, rs1=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st=con.createStatement();
			String upit="select * from igraonica where idigraonica='"+id+"';";
			rs=st.executeQuery(upit);
			while(rs.next()) {
				Igraonica igraonica=new Igraonica(id, rs.getString("naziv"), rs.getString("adresa"), rs.getString("telefon"), rs.getString("slika"));
				request.setAttribute("igraonica", igraonica);
				request.getRequestDispatcher("IzmenaIgraonice.jsp").forward(request, response);
			}
		} catch (Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noviid=Integer.parseInt(request.getParameter("IDIgraonice"));
		
		String naziv=request.getParameter("NazivIgraonice");
		String adresa=request.getParameter("AdresaIgraonice");
		String telefon=request.getParameter("TelefonIgraonice");
		
		Connection con=null;
		Statement st=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			String upit="update igraonica set idigraonica='"+noviid+"', naziv='"+naziv+"', adresa='"+adresa+"', telefon='"+telefon+"' where idigraonica='"+noviid+"';"; 
			st=con.createStatement();
			st.executeUpdate(upit);
			st.close();
			con.close();
			
		}catch (SQLException e){
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

		request.setAttribute("poruka", "Uspesno azuriranje igraonice!");
		request.getRequestDispatcher("AdminWelcome.jsp").forward(request, response);
	}

}
