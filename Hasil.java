package GUI_JDBC;

public class Hasil {
	String nama;
	String nim;
	String kobu;
	String tglp;
	String tglk;
	
	@Override
	
	public String toString() {
		return "Hasil [nama=" + nama + ", nim=" + nim + ", kobu=" + kobu + ", tglp=" + tglp
				+ ", tglk=" + tglk  + "]";
	}
	public Hasil(String nama, String nim, String kobu, String tglp, String tglk) {
		super();
		this.nama = nama;
		this.nim = nim;
		this.kobu = kobu;
		this.tglp = tglp;
		this.tglk = tglk;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getNim() {
		return nim;
	}
	public void setNim(String nim) {
		this.nim = nim;
	}
	public String getKobu() {
		return kobu;
	}
	public void setKobu(String kobu) {
		this.kobu = kobu;
	}
	public String getTglp() {
		return tglp;
	}
	public void setTglp(String tglp) {
		this.tglp = tglp;
	}
	public String getTglk() {
		return tglk;
	}
	public void setTglk(String tglk) {
		this.tglk = tglk;
	}
	
	
	

}
