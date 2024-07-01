package paging1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource dataSource;
	
	public BoardDAO() {
		// TODO Auto-generated constructor stub
		// 데이터베이스 연결
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
			this.dataSource = (DataSource)envCtx.lookup( "jdbc/mariadb2" );
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		}
	}
	
	public void boardWrite() {}
	
	public int boardWriteOk(BoardTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int flag = 1;
		try {
			conn = this.dataSource.getConnection();
		
			String sql = "insert into board1 values ( 0, ?, ?, ?, password( ? ), ?, 0, ?, now() )";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSubject());
			pstmt.setString( 2, to.getWriter() );
			pstmt.setString( 3, to.getMail() );
			pstmt.setString( 4, to.getPassword() );
			pstmt.setString( 5, to.getContent() );
			pstmt.setString( 6, to.getWip() );
		
			if( pstmt.executeUpdate() == 1 ) {
				flag = 0;
			}
		} catch( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		
		return flag;
	}
	
	//
	public BoardListTO boardList(BoardListTO listTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int cpage = listTO.getCpage();
		int recordPerPage = listTO.getRecordPerPage();
		int blockPerPage = listTO.getBlockPerPage();
		
		
		try {
			conn = this.dataSource.getConnection();
		
			String sql = "select seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff( now(), wdate ) wgap from board1 order by seq desc";
			pstmt = conn.prepareStatement( sql );
		
			rs = pstmt.executeQuery();
			
			rs.last();
			listTO.setTotalRecord(rs.getRow());
			rs.beforeFirst();
			
			listTO.setTotalPage(((listTO.getTotalRecord() - 1) / recordPerPage) + 1);
			
			int skip = (cpage - 1) * recordPerPage;
			if (skip != 0) rs.absolute(skip);
			
			ArrayList<BoardTO> boardLists = new ArrayList<BoardTO>();
			for(int i=0; i<recordPerPage && rs.next(); i++) {
				BoardTO to = new BoardTO();
				to.setSeq( rs.getString( "seq" ) );
				to.setSubject( rs.getString( "subject" ) );
				to.setWriter( rs.getString( "writer" ) );
				to.setWdate( rs.getString( "wdate" ) );
				to.setHit( rs.getString( "hit" ) );
				to.setWgap( rs.getInt( "wgap" ) );
				
				boardLists.add( to );
			}
			
			listTO.setBoardLists(boardLists);
			
			// block 처리
			listTO.setStartBlock(cpage - (cpage - 1) % blockPerPage);
			listTO.setEndBlock(cpage - (cpage - 1) % blockPerPage + blockPerPage - 1);
			if (listTO.getEndBlock() >= listTO.getTotalPage()) {
				listTO.setEndBlock(listTO.getTotalPage());
			}
			
		} catch( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}		
		return listTO;
	}
	
	public BoardTO boardView(BoardTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = this.dataSource.getConnection();
		
			String sql = "update board1 set hit=hit+1 where seq=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );
			
			pstmt.executeUpdate();
			
			sql = "select subject, writer, mail, wip, wdate, hit, content from board1 where seq=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );
		
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				to.setSubject( rs.getString( "subject" ) );
				to.setWriter( rs.getString( "writer" ) );
				to.setMail( rs.getString( "mail" ) );
				to.setWip( rs.getString( "wip" ) );
				to.setWdate( rs.getString( "wdate" ) );
				to.setHit( rs.getString( "hit" ) );
				to.setContent( rs.getString( "content" ).replaceAll( "\n", "<br />" ) );
			}
		} catch( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		
		return to;
	}
	
	public BoardTO boardModify(BoardTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
		
			String sql = "select subject, writer, mail, content from board1 where seq=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );
		
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				to.setSubject( rs.getString( "subject" ) );
				to.setWriter( rs.getString( "writer" ) );
				to.setMail( rs.getString("mail") );
				to.setContent( rs.getString( "content" ) );			
			}
		} catch( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		
		return to;
	}
	
	public void boardModifyOk() {
		
	}
	
	public BoardTO boardDelete(BoardTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
              
			String sql = "select subject, writer, mail from board1 where seq = ?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );
              
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				to.setSubject( rs.getString( "subject" ) );
				to.setWriter( rs.getString( "writer" ) );
			}
		} catch( SQLException e ) {
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		
		return to;
	}
	
	public void boardDeleteOk() {
		
	}
}
