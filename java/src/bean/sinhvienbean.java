package bean;

public class sinhvienbean {
	private String masv;
	private String hoten;
	private String diachi;
	private String img;
	private String mamon;
	private String email;
	public sinhvienbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public sinhvienbean(String masv, String hoten, String diachi, String img, String mamon, String email) {
		super();
		this.masv = masv;
		this.hoten = hoten;
		this.diachi = diachi;
		this.img = img;
		this.mamon = mamon;
		this.email = email;
	}

	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getMamon() {
		return mamon;
	}
	public void setMamon(String mamon) {
		this.mamon = mamon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}