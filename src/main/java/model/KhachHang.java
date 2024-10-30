package model;

import java.sql.Date;

public class KhachHang {

	private String maKhacHang;
	private String tenDangNhap;
	private String matKhau; 
	private String hoVaTen;
	private String gioiTinh;
	private String diaChi; 
	private String diaChiNhanHang;
	private String diaChiMuaHang;
	private Date ngaySinh;
	private String soDienThoai;
	private String email;
	private boolean dangKyNhanBangTin;
	private String maXacThuc; 
	private Date thoigianhieuluccuamaxacthuc;
	private boolean trangthaixacthuc;
	private String duongdananh;
	
	public KhachHang() {
	}
	public KhachHang(String maKhacHang, String tenDangNhap, String matKhau, String hoVaTen, String gioiTinh,
			String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email,
			boolean dangKyNhanBangTin, String maXacThuc, Date thoigianhieuluccuamaxacthuc, boolean trangthaixacthuc) {
		super();
		this.maKhacHang = maKhacHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKyNhanBangTin = dangKyNhanBangTin;
		this.maXacThuc = maXacThuc;
		this.thoigianhieuluccuamaxacthuc = thoigianhieuluccuamaxacthuc;
		this.trangthaixacthuc = trangthaixacthuc;
	}





	public KhachHang(String maKhacHang, String tenDangNhap, String matKhau, String hoVaTen, String gioiTinh,
			String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email,
			boolean dangKyNhanBangTin, String maXacThuc, Date thoigianhieuluccuamaxacthuc, boolean trangthaixacthuc,
			String duongdananh) {
		super();
		this.maKhacHang = maKhacHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKyNhanBangTin = dangKyNhanBangTin;
		this.maXacThuc = maXacThuc;
		this.thoigianhieuluccuamaxacthuc = thoigianhieuluccuamaxacthuc;
		this.trangthaixacthuc = trangthaixacthuc;
		this.duongdananh = duongdananh;
	}
	
	
	public String getMaXacThuc() {
		return maXacThuc;
	}
	public void setMaXacThuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}
	public String getDuongdananh() {
		return duongdananh;
	}
	public void setDuongdananh(String duongdananh) {
		this.duongdananh = duongdananh;
	}
	public String getMaxacthuc() {
		return maXacThuc;
	}


	public void setMaxacthuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}


	public Date getThoigianhieuluccuamaxacthuc() {
		return thoigianhieuluccuamaxacthuc;
	}


	public void setThoigianhieuluccuamaxacthuc(Date thoigianhieuluccuamaxacthuc) {
		this.thoigianhieuluccuamaxacthuc = thoigianhieuluccuamaxacthuc;
	}


	public boolean isTrangthaixacthuc() {
		return trangthaixacthuc;
	}


	public void setTrangthaixacthuc(boolean trangthaixacthuc) {
		this.trangthaixacthuc = trangthaixacthuc;
	}


	public KhachHang(String maKhacHang, String tenDangNhap, String matKhau, String hoVaTen, String gioiTinh,
			String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date ngaySinh, String soDienThoai, String email,
			boolean dangKyNhanBangTin) {
		super();
		this.maKhacHang = maKhacHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKyNhanBangTin = dangKyNhanBangTin;
	}

	public String getMaKhacHang() {
		return maKhacHang;
	}

	public void setMaKhacHang(String maKhacHang) {
		this.maKhacHang = maKhacHang;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public String getDiaChiMuaHang() {
		return diaChiMuaHang;
	}

	public void setDiaChiMuaHang(String diaChiMuaHang) {
		this.diaChiMuaHang = diaChiMuaHang;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDangKyNhanBangTin() {
		return dangKyNhanBangTin;
	}

	public void setDangKyNhanBangTin(boolean dangKyNhanBangTin) {
		this.dangKyNhanBangTin = dangKyNhanBangTin;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhacHang=" + maKhacHang + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", hoVaTen=" + hoVaTen + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", diaChiNhanHang="
				+ diaChiNhanHang + ", diaChiMuaHang=" + diaChiMuaHang + ", ngaySinh=" + ngaySinh + ", soDienThoai="
				+ soDienThoai + ", email=" + email + ", dangKyNhanBangTin=" + dangKyNhanBangTin + "]";
	}
	
	
}
