package com.sparrow.admin.dao;

import com.sparrow.admin.dao.support.IBaseDao;
import com.sparrow.admin.entity.User;

import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends IBaseDao<User, Integer> {

	User findByUserName(String username);

}
