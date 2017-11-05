package com.sparrow.admin.service;

import com.sparrow.admin.entity.Role;
import com.sparrow.admin.service.support.IBaseService;

/**
 * <p>
 * 角色服务类
 * </p>
 *
 * @author 贤云
 * @since 2016-12-28
 */
public interface IRoleService extends IBaseService<Role,Integer> {

	/**
	 * 添加或者修改角色
	 * @param role
	 */
	void saveOrUpdate(Role role);

	/**
	 * 给角色分配资源
	 * @param id 角色ID
	 * @param resourceIds 资源ids
	 */
	void grant(Integer id, String[] resourceIds);

}
