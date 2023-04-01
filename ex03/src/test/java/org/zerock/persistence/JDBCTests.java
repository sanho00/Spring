package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	
	static {   //정적, 데이터영역에 스택으로 올려서 메모리에 상주해있어야 할 때 쓴다.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		try(Connection con =
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
						"book_ex", "1234")) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
