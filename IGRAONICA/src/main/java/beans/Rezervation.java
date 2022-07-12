package beans;

import java.sql.Date;

public class Rezervation {

	private int idrez;
	private Date datum;
	private int vreme;
	private int idkorisnik;
	private int idigraonica;
	private int idpaket;
	private int racun;
	
	public Rezervation(){
		idrez=0;
		datum=null;
		vreme=0;
		idkorisnik=0;
		idigraonica=0;
		idpaket=0;
		racun=0;
	}
	
	public Rezervation(int idrez, Date datum, int vreme, int idkorisnik, int idigraonica, int idpaket, int racun) {
		super();
		this.idrez=idrez;
		this.datum=datum;
		this.vreme=vreme;
		this.idkorisnik=idkorisnik;
		this.idigraonica=idigraonica;
		this.idpaket=idpaket;
		this.racun=racun;
	}
	
	public int getIdrez() {
		return idrez;
	}
	public void setIdrez(int idrez) {
		this.idrez = idrez;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public int getVreme() {
		return vreme;
	}
	public void setVreme(int vreme) {
		this.vreme = vreme;
	}
	public int getIdkorisnik() {
		return idkorisnik;
	}
	public void setIdkorisnik(int idkorisnik) {
		this.idkorisnik = idkorisnik;
	}
	public int getIdigraonica() {
		return idigraonica;
	}
	public void setIdigraonica(int idigraonica) {
		this.idigraonica = idigraonica;
	}
	public int getIdpaket() {
		return idpaket;
	}
	public void setIdpaket(int idpaket) {
		this.idpaket = idpaket;
	}
	public int getRacun() {
		return racun;
	}
	public void setRacun(int racun) {
		this.racun = racun;
	}
	
	
}
