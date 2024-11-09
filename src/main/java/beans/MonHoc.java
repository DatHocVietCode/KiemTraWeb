package beans;

public class MonHoc {
	private String maMonHoc;
	private String tenMonHoc;
	private int soTinChi;
	private Khoa khoaPhuTrach;
	public MonHoc() {
		// TODO Auto-generated constructor stub
	}
	public MonHoc(String maMonHoc, String tenMonHoc, int soTinchi, Khoa khoaPhuTrach) {
		setMaMonHoc(maMonHoc);
		setTenMonHoc(tenMonHoc);
		setSoTinChi(soTinchi);
		setKhoaPhuTrach(khoaPhuTrach);
	}
	public int getSoTinChi() {
		return soTinChi;
	}
	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	public String getMaMonHoc() {
		return maMonHoc;
	}
	public void setMaMonHoc(String maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	public Khoa getKhoaPhuTrach() {
		return khoaPhuTrach;
	}
	public void setKhoaPhuTrach(Khoa khoaPhuTrach) {
		this.khoaPhuTrach = khoaPhuTrach;
	}
}
