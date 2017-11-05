package com.sparrow.admin.dao;

import com.sparrow.admin.dao.support.IBaseDao;
import com.sparrow.admin.entity.Role;

import org.springframework.stereotype.Repository;

@Repository
public interface IRoleDao extends IBaseDao<Role, Integer> {

}
