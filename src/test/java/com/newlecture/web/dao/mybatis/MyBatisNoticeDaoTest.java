package com.newlecture.web.dao.mybatis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

//데이터베이스 테스트용으로 대체하지 않겠다
@AutoConfigureTestDatabase(replace = Replace.NONE)
@SpringBootTest
class MyBatisNoticeDaoTest {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Test
	void test() {
		int[] ids = {23,40,45};
		List<Notice> list = noticeDao.getListIn(ids);
		
		//fail("Not yet implemented");
	}

}
