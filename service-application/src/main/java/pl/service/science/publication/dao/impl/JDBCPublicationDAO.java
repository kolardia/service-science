package pl.service.science.publication.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.service.science.publication.dao.PublicationDAO;
import pl.service.science.publication.domain.Publication;

@Repository
public class JDBCPublicationDAO{
	
	@Autowired
	private DataSource dataSource;
	
	public void insertPublication(Publication publication){
		
		String sql = "INSERT INTO publications" +
				"(publication_id, publication_title, publication_content) VALUES (?, ?, ?)";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, publication.getId());
			ps.setString(2, publication.getTitle());
			ps.setString(3, publication.getContents());

			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}

	}
}
