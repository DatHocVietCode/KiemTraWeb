package beans;

public class Khoa {
	private int maKhoa;
	private String tenKhoa;
	public String getTenKhoa() {
		return tenKhoa;
	}
	public Khoa() {
		
	}
	public Khoa(int maKhoa, String tenKhoa) {
		setMaKhoa(maKhoa);
		setTenKhoa(tenKhoa);
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	public int getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(int maKhoa) {
		this.maKhoa = maKhoa;
	}
}
