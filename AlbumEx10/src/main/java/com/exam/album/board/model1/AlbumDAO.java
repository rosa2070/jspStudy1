package com.exam.album.board.model1;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AlbumDAO {
	private DataSource dataSource;
	private String uploadPath = "C:/java/jsp-workspace/AlbumEx10/src/main/webapp/upload";
	
	public AlbumDAO() {
		// TODO Auto-generated constructor stub
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			this.dataSource = (DataSource)envCtx.lookup("jdbc/mariadb2");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		}
	}
	
	public void albumWrite() {
		
	}
	
	public int albumWriteOk(AlbumTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int flag = 1;
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "insert into album_cmt_board1 values (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0, ?, now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getSubject());
			pstmt.setString(2, to.getWriter());
			pstmt.setString(3, to.getMail());
			pstmt.setString(4, to.getPassword());
			pstmt.setString(5, to.getContent());
			pstmt.setString(6, to.getImagename());
			pstmt.setLong(7, to.getImagesize());
			pstmt.setString(8, to.getLatitude());
			pstmt.setString(9, to.getLongitude());
			pstmt.setString(10, to.getWip());
			
			int result = pstmt.executeUpdate();
			if (result == 1) {
				flag = 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( pstmt != null ) try { pstmt.close(); } catch(SQLException e) {}
			if( conn != null ) try { conn.close(); } catch(SQLException e) {}
		}
		return flag;
		
	}
	
	public AlbumListTO albumList(AlbumListTO listTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<AlbumTO> lists = new ArrayList<AlbumTO>();
		
		int cpage = listTO.getCpage();
		int recordPerPage = listTO.getRecordPerPage();
		int blockPerPage = listTO.getBlockPerPage();
		
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "select seq, subject, writer, cmtcnt, imagename, date_format(wdate, '%Y.%m.%d') wdate, hit, datediff(now(), wdate) wgap from album_cmt_board1 order by seq desc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			rs.last();
			listTO.setTotalRecord(rs.getRow());
			rs.beforeFirst();
			
			listTO.setTotalPage(((listTO.getTotalRecord() - 1) / recordPerPage) + 1);
			
			int skip = (cpage - 1) * recordPerPage;
			if ( skip != 0) rs.absolute(skip);
			
			ArrayList<AlbumTO> albumLists = new ArrayList<AlbumTO>();
			for (int i=0; i<recordPerPage && rs.next(); i++) {
				AlbumTO to = new AlbumTO();
				to.setSeq(rs.getString("seq"));
				to.setSubject(rs.getString("subject"));
				to.setWriter(rs.getString("writer"));
				to.setCmtcnt(rs.getInt("cmtcnt"));
				to.setImagename(rs.getString("imagename"));
				to.setWdate(rs.getString("wdate"));
				to.setHit(rs.getString("hit"));
				to.setWgap(rs.getInt("wgap"));
				
				albumLists.add(to);
			}
			
			listTO.setAlbumLists(albumLists); 
			
			listTO.setStartBlock(((cpage - 1) / blockPerPage) * blockPerPage + 1);
			listTO.setEndBlock(((cpage - 1) / blockPerPage) * blockPerPage + blockPerPage); 
			if (listTO.getEndBlock() >= listTO.getTotalPage()) {
				listTO.setEndBlock(listTO.getTotalPage());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (SQLException e) {}
			if (pstmt != null) try { pstmt.close(); } catch (SQLException e) {}
			if (conn != null) try { conn.close(); } catch (SQLException e) {}
			
		}
		
		return listTO;      
	}
	
	public AlbumTO albumView(AlbumTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "update album_cmt_board1 set hit=hit+1 where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getSeq());
			
			pstmt.executeUpdate();
			
			sql = "select subject, writer, mail, wip, wdate, hit, content, imagename, imagesize, latitude, longitude from album_cmt_board1 where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getSeq());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				to.setSubject(rs.getString("subject"));
				to.setWriter(rs.getString("writer"));
				to.setMail(rs.getString("mail"));
				to.setWip(rs.getString("wip"));
				to.setWdate(rs.getString("wdate"));
				to.setHit(rs.getString("hit"));
				to.setContent(rs.getString("content").replaceAll("\n", "<br />"));
				to.setImagename(rs.getString("imagename"));
				to.setImagesize(rs.getLong("imagesize"));
				to.setLatitude(rs.getString("latitude"));
				to.setLongitude(rs.getString("longitude"));
			}
		} catch (SQLException e) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if (rs != null) try {rs.close();} catch(SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch(SQLException e) {}
			if (conn != null) try {conn.close(); } catch(SQLException e) {}
		}
		return to;
	}
	
	public AlbumTO albumModify(AlbumTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "select subject, writer, mail, content, imagename, latitude, longitude from album_cmt_board1 where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getSeq());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				to.setSubject(rs.getString("subject"));
				to.setWriter(rs.getString("writer"));
				to.setMail(rs.getString("mail"));
				to.setContent(rs.getString("content"));
				to.setImagename(rs.getString("imagename"));
				to.setLatitude(rs.getString("latitude"));
				to.setLongitude(rs.getString("longitude"));
			}
		} catch (SQLException e) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		return to;
		
	}
	
	public int albumModifyOk(AlbumTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int flag = 2;
		
		conn = this.dataSource.getConnection();
		
		String sql = "select imagename from album_cmt_board1 where seq=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, to.getSeq());
		
		rs = pstmt.executeQuery();
		String oldImagename = null;
		if (rs.next()) {
			oldImagename = rs.getString("imagename");
		}
		
		
	}
	
	public AlbumTO albumDelete(AlbumTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "select subject, writer from album_cmt_board1 where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getSeq());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				to.setSubject(rs.getString("subject"));
				to.setWriter(rs.getString("writer"));
			}
		} catch (SQLException e) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {}
			if (conn != null) try {conn.close();} catch (SQLException e) {}
		}
		return to;
	}
	
	public int albumDeleteOk(AlbumTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int flag = 2;
		
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "select imagename from album_cmt_board1 where seq=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getSeq());
			
			rs = pstmt.executeQuery();
			String imagename = null;
			if (rs.next()) {
				imagename = rs.getString("imagename");
			}
			
			sql = "delete from album_cmt_board1 where seq=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, to.getSeq());
			pstmt.setString(2, to.getPassword());
			
			int result = pstmt.executeUpdate();
			if (result == 0) {
				flag = 1;
			} else if (result == 1) {
				flag = 0;
				
				if( imagename != null ) {
					File file = new File( uploadPath + "/" + imagename);
					file.delete();
					
					sql = "delete from album_cmt_comment1 where pseq=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, to.getSeq());
					
					pstmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if (rs!= null) try { rs.close(); } catch (SQLException e) {}
			if (pstmt!= null) try { pstmt.close(); } catch (SQLException e) {}
			if (conn!= null) try { conn.close(); } catch (SQLException e) {}
		}
		
		return flag;
		
	}
	
	
	

}
