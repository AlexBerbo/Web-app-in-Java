package serlvets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Igraonica;
import beans.Paket;

/**
 * Servlet implementation class DetaljnijeRezervisi
 */
@WebServlet("/DetaljnijeRezervisi")
public class DetaljnijeRezervisi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetaljnijeRezervisi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		ArrayList<Paket>pakets=new ArrayList<Paket>();
		
		Connection con=null;
		Statement st, st1=null;
		ResultSet rs, rs1=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st=con.createStatement();
			String upit="select *  from igraonica where idigraonica='"+id+"';";
			rs=st.executeQuery(upit);
			while(rs.next()) {
				Igraonica igraonica=new Igraonica(id, rs.getString("naziv"), rs.getString("adresa"), rs.getString("telefon"), rs.getString("slika"));
				request.setAttribute("Igraonica", igraonica);
				st1=con.createStatement();
				String upit1="select * from paket where idigraonica='"+id+"';";
				rs1=st1.executeQuery(upit1);
				while(rs1.next()) {
					pakets.add(new Paket(rs1.getInt("idpaket"), rs1.getString("naziv"), rs1.getString("opis"), rs1.getInt("cena"), rs1.getInt("bodovi"), rs1.getInt("idigraonica")));
					request.setAttribute("ListaPaketa", pakets);
				}
				request.getRequestDispatcher("DetaljnijeRezervisi.jsp").forward(request, response);
			}
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
