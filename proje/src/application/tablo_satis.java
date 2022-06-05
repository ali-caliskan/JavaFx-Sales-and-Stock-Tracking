package application;

public class tablo_satis {
	private int ID;
	private String urun_adi;
	private String kategori;
	private String beden;
	private String renk;
	private int fiyat;
	private int adet;
	private String aciklama;
	public tablo_satis() {
		
	}
	public tablo_satis(int ID, String urun_adi,String kategori,String beden,String renk,int fiyat , int adet,String aciklama)  {
		this.ID=ID;
		this.urun_adi=urun_adi;
		this.kategori=kategori;
		this.beden=beden;
		this.renk=renk;
		this.fiyat=fiyat;
		this.adet=adet;
		this.aciklama=aciklama;
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUrun_adi() {
		return urun_adi;
	}
	public void setUrun_adi(String urun_adi) {
		this.urun_adi = urun_adi;
	}
	public String getKategori() {
		return kategori;
	}
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
	public String getBeden() {
		return beden;
	}
	public void setBeden(String beden) {
		this.beden = beden;
	}
	public String getRenk() {
		return renk;
	}
	public void setRenk(String renk) {
		this.renk = renk;
	}
	public int getFiyat() {
		return fiyat;
	}
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}
	public int getAdet() {
		return adet;
	}
	public void setAdet(int adet) {
		this.adet = adet;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	
}
