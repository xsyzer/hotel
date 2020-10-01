package com.example.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
class BootApplicationTests {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Test
	public void bestOrder(){
		String sql = "select price from test order by star desc ";
		List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);


		System.out.println(maps);
	}

}
