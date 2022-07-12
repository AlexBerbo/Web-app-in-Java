package serlvets;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import beans.Igraonica;
import beans.Paket;
import beans.Rezervation;

/**
 * Servlet implementation class InfoIgraonice
 */
@WebServlet("/InfoIgraonice")
public class InfoIgraonice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoIgraonice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username1");
		//PrintWriter out=response.getWriter();
		ArrayList<Igraonica>igraonicas=new ArrayList<Igraonica>();
		ArrayList<Rezervation>rezervations=new ArrayList<Rezervation>();
		ArrayList<Paket>pakets=new ArrayList<Paket>();
		
		Connection con=null;
		Statement st, st1, st2, st3=null;
		ResultSet rs, rs1, rs2, rs3=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st=con.createStatement();
			String upit="select * from manager where username='"+username+"';";
			rs=st.executeQuery(upit);
			while(rs.next()) {
				int id=rs.getInt(6);
				//out.print(id);
				st1=con.createStatement();
				String upit1="select * from igraonica where idigraonica='"+id+"';";
				rs1=st1.executeQuery(upit1);
				while(rs1.next()) {
					igraonicas.add(new Igraonica(rs1.getInt("idigraonica"), rs1.getString("naziv"), rs1.getString("adresa"), rs1.getString("telefon"), rs1.getString("slika")));
					request.setAttribute("ListaIgraonica", igraonicas);
					
					int idigraonice=rs1.getInt(1);
					st2=con.createStatement();
					String upit2="select * from paket where idigraonica='"+idigraonice+"';";
					rs2=st2.executeQuery(upit2);
					while(rs2.next()) {
						pakets.add(new Paket(rs2.getInt("idpaket"), rs2.getString("naziv"), rs2.getString("opis"), rs2.getInt("cena"), rs2.getInt("bodovi"), rs2.getInt("idigraonica")));
						request.setAttribute("ListaPaketa", pakets);
						
						if(pakets.isEmpty()) {
							request.setAttribute("poruka", "Nema paketa!");
							request.getRequestDispatcher("ManagerWelcome.jsp").forward(request, response);
						}
						
						st3=con.createStatement();
						String upit3="select * from rezervation where idigraonica='"+id+"';";
						rs3=st3.executeQuery(upit3);
						while(rs3.next()) {
							rezervations.add(new Rezervation(rs3.getInt("idrez"), rs3.getDate("datum"), rs3.getInt("vreme"), rs3.getInt("idkorisnik"), rs3.getInt("idigraonica"), 
									rs3.getInt("idpaket"), rs3.getInt("racun")));
							request.setAttribute("ListaRezervacija", rezervations);
							
							if(rezervations.isEmpty()) {
								request.getRequestDispatcher("ListaPaketa.jsp").forward(request, response);
							}
							request.getRequestDispatcher("InfoIgraonica.jsp").forward(request, response);
						}
					}
				}
			}
		} catch (SQLException e){
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username1");
		//PrintWriter out=response.getWriter();
		ArrayList<Igraonica>igraonicas=new ArrayList<Igraonica>();
		ArrayList<Rezervation>rezervations=new ArrayList<Rezervation>();
		ArrayList<Paket>pakets=new ArrayList<Paket>();
		
		Connection con=null;
		Statement st, st1, st2, st3=null;
		ResultSet rs, rs1, rs2, rs3=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/igraonica", "root", "");
			st=con.createStatement();
			String upit="select * from manager where username='"+username+"';";
			rs=st.executeQuery(upit);
			while(rs.next()) {
				int id=rs.getInt(6);
				//out.print(id);
				st1=con.createStatement();
				String upit1="select * from igraonica where idigraonica='"+id+"';";
				rs1=st1.executeQuery(upit1);
				while(rs1.next()) {
					igraonicas.add(new Igraonica(rs1.getInt("idigraonica"), rs1.getString("naziv"), rs1.getString("adresa"), rs1.getString("telefon"), rs1.getString("slika")));
					request.setAttribute("ListaIgraonica", igraonicas);
					
					int idigraonice=rs1.getInt(1);
					st2=con.createStatement();
					String upit2="select * from paket where idigraonica='"+idigraonice+"';";
					rs2=st2.executeQuery(upit2);
					while(rs2.next()) {
						pakets.add(new Paket(rs2.getInt("idpaket"), rs2.getString("naziv"), rs2.getString("opis"), rs2.getInt("cena"), rs2.getInt("bodovi"), rs2.getInt("idigraonica")));
						request.setAttribute("ListaPaketa", pakets);
						
						if(pakets.isEmpty()) {
							request.setAttribute("poruka", "Nema paketa!");
							request.getRequestDispatcher("ManagerWelcome.jsp").forward(request, response);
						}
						
						st3=con.createStatement();
						String upit3="select * from rezervation where idigraonica='"+id+"';";
						rs3=st3.executeQuery(upit3);
						while(rs3.next()) {
							rezervations.add(new Rezervation(rs3.getInt("idrez"), rs3.getDate("datum"), rs3.getInt("vreme"), rs3.getInt("idkorisnik"), rs3.getInt("idigraonica"), 
									rs3.getInt("idpaket"), rs3.getInt("racun")));
							request.setAttribute("ListaRezervacija", rezervations);
							
							if(rezervations.isEmpty()) {
								request.getRequestDispatcher("ListaPaketa.jsp").forward(request, response);
							}
							request.getRequestDispatcher("InfoIgraonica.jsp").forward(request, response);
						}
					}
				}
			}
		} catch (SQLException e){
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
	}

}
