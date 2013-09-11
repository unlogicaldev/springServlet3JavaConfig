package com.servlet3.sample.common.mongo;


import org.junit.Test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.servlet3.sample.BaseTest;

public class MongoTemplateTest extends BaseTest {

	@Test
	public void test() {
		/*
		 * 테스트를 위한 인덱스 생성용 테스트
		 */
		DBCollection c = MongoTemplate.getDBCollection("AuthLog");
		DBObject keys = new BasicDBObject();
		keys.put("key", 1);
		keys.put("regDate", -1);
		c.ensureIndex(keys, "AuthLog_idx_01");
		fail("Not yet implemented");
	}

}
