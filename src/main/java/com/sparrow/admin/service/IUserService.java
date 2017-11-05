package com.sparrow.admin.service;

import com.sparrow.admin.service.support.IBaseService;
import com.sparrow.admin.entity.User;

/**
 * <p>
 * 用户服务类
 * </p>
 *
 * @author 贤云
 * @since 2016-12-28
 */
public interface IUserService extends IBaseService<User, Integer> {

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User findByUserName(String username);

	/**
	 * 增加或者修改用户
	 * @param user
	 */
	void saveOrUpdate(User user);

	/**
	 * 给用户分配角色
	 * @param id 用户ID
	 * @param roleIds 角色Ids
	 */
	void grant(Integer id, String[] roleIds);

}
