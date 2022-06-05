package application;

public class tablo_uyeler {


	
	private int ID;
	private String isim;
	private String soyisim;
	private String kullanici_adi;
	private String parola;
	private String posta;
	public tablo_uyeler() {
		
	}
	public tablo_uyeler(int ID, String isim,String soyisim,String kullanici_adi,String parola,String posta)  {
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public String getSoyisim() {
		return soyisim;
	}
	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}
	public String getKullanici_adi() {
		return kullanici_adi;
	}
	public void setKullanici_adi(String kullanici_adi) {
		this.kullanici_adi = kullanici_adi;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public String getPosta() {
		return posta;
	}
	public void setPosta(String posta) {
		this.posta = posta;
	}
	
}

