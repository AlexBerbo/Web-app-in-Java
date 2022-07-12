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
import javax.servlet.http.HttpSession;

import beans.Igraonica;

/**
 * Servlet implementation class PodaciIgraonice
 */
@WebServlet("/PodaciIgraonice")
public class PodaciIgraonice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PodaciIgraonice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username1");
		
		Connection con=null;
		Statement st=null;
		ResultSet rs, rs1=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st=con.createStatement();
			String upit="select * from manager where username='"+username+"';";
			rs=st.executeQuery(upit);
			while(rs.next()) {
				int id=rs.getInt(6);
				String upit1="select * from igraonica where idigraonica='"+id+"';";
				rs1=st.executeQuery(upit1);
				while(rs1.next()) {
					Igraonica igraonica=new Igraonica(id, rs1.getString("naziv"), rs1.getString("adresa"), rs1.getString("telefon"), rs1.getString("slika"));
					request.setAttribute("igraonica", igraonica);
					request.getRequestDispatcher("PodaciIgraonice.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			request.setAttribute("poruka", "Greska");
			request.getRequestDispatcher("ManagerWelcome.jsp");
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
		
		try {
			Connection con=null;
			Statement st=null;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			String upit="update igraonica set idigraonica='"+noviid+"', naziv='"+naziv+"', adresa='"+adresa+"', telefon='"+telefon+"' where idigraonica='"+noviid+"';";
			st=con.createStatement();
			st.executeUpdate(upit);
			st.close();
			con.close();
		}catch(Exception e){
			request.setAttribute("poruka", "Greska");
			request.getRequestDispatcher("InfoIgraonice");
		}
		request.setAttribute("poruka", "Uspesno ste azurirali igraonicu!");
		request.getRequestDispatcher("ManagerWelcome.jsp").forward(request, response);
	}

}
