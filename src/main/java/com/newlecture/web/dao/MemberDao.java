package com.newlecture.web.dao;

import com.newlecture.web.entity.Member;

public interface MemberDao {

	Member getByUid(String uid);

}
