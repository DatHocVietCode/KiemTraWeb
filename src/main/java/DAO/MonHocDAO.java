package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Khoa;
import beans.MonHoc;
import dbutil.dbutils;

public class MonHocDAO {
	public static boolean CheckInput(MonHoc mh) {
		return CheckTen(mh.getTenMonHoc()) & CheckSoTinChi(mh.getSoTinChi()) & CheckKhoaQuanLy(mh.getKhoaPhuTrach()) && CheckMaMH(mh.getMaMonHoc());
	}

	private static boolean CheckMaMH(String maMonHoc) {
		if (maMonHoc.equals(null) || maMonHoc.length() == 0) {
			return false;
		}
		String cmd = "select * from MonHoc where MonHoc.MaMH = ?";
		Object[] paraObjects = {maMonHoc};
		ResultSet rs = (ResultSet)dbutils.ExecutePrepareStatment(cmd, paraObjects, true);
		try {
			if (rs.next()) {		
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error occured during executing CheckMaMH");
			e.printStackTrace();
		}
		return true;
	}

	private static boolean CheckKhoaQuanLy(Khoa khoaPhuTrach) {
		String cmd = "select 1 from Khoa where Khoa.MaKhoa = ?";
		Object[] paObjects = { khoaPhuTrach.getMaKhoa() };
		ResultSet rs = (ResultSet)dbutils.ExecutePrepareStatment(cmd, paObjects, true);
		try {
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error occured during execute checking MaKhoa");
			e.printStackTrace();
		}
		finally {
			/* dbutils.CloseResultset(rs); */
		}
		return false;
	}

	private static boolean CheckSoTinChi(int soTinChi) {
		if (soTinChi <=0 || soTinChi > 5) {
			return false;
		}
		return true;
	}

	private static boolean CheckTen(String tenMonHoc) {
		if (tenMonHoc.equals(null) || tenMonHoc.length() == 0) {
			return false;
		}
		return true;
	}
	
	public static void ThemMonHoc(MonHoc mh) {
		String query = "insert into MonHoc (MaMH,TenMH, SoTinChi, KhoaQuanLy) values (?, ?, ?, ?)";
		Object[] paObjects = { mh.getMaMonHoc(), mh.getTenMonHoc(), mh.getSoTinChi(), mh.getKhoaPhuTrach().getMaKhoa()};
		dbutils.ExecutePrepareStatment(query, paObjects, false);
	}
	
	public static void XoaMonHoc(String maMH)
	{
		String query = "delete from MonHoc where MonHoc.MaMH = ?";
		Object[] pObjects = {maMH};
		dbutils.ExecutePrepareStatment(query, pObjects, false);
	}
	
	public static void SuaMonHoc(MonHoc mh) {
		Object[] paObjects = { mh.getTenMonHoc(), mh.getSoTinChi(), mh.getKhoaPhuTrach().getMaKhoa(),  mh.getMaMonHoc()};
		String query = "UPDATE MonHoc SET TenMH = ?, SoTinChi = ?, KhoaQuanLy = ? WHERE MaMH = ?";
		dbutils.ExecutePrepareStatment(query, paObjects, false);
	}
}
