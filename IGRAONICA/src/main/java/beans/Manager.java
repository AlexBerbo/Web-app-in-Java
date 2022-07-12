package beans;

public class Manager {

	private int idmanager;
	private String ime; 
	private String prezime;
	private String username;
	private String password;
	private int idigraonica;
	
	public Manager() {
		idmanager=0;
		ime="";
		prezime="";
		username="";
		password="";
		idigraonica=0;
	}
	
	public Manager(int idmanager, String ime, String prezime, String username, String password, int idigraonica) {
		super();
		this.idmanager=idmanager;
		this.ime=ime;
		this.prezime=prezime;
		this.username=username;
		this.password=password;
		this.idigraonica=idigraonica;
	}
	
	public int getIdmanager() {
		return idmanager;
	}
	public void setIdmanager(int idmanager) {
		this.idmanager = idmanager;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdigraonica() {
		return idigraonica;
	}
	public void setIdigraonica(int idigraonica) {
		this.idigraonica = idigraonica;
	}
	
	
	
}
