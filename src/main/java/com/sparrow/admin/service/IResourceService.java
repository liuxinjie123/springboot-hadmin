package com.sparrow.admin.service;

import com.sparrow.admin.entity.Resource;
import com.sparrow.admin.service.support.IBaseService;
import com.sparrow.admin.vo.ZtreeView;

import java.util.List;

/**
 * <p>
 * 资源服务类
 * </p>
 *
 * @author 贤云
 * @since 2016-12-28
 */
public interface IResourceService extends IBaseService<Resource, Integer> {

	/**
	 * 获取角色的权限树
	 * @param roleId
	 * @return
	 */
	List<ZtreeView> tree(int roleId);

	/**
	 * 修改或者新增资源
	 * @param resource
	 */
	void saveOrUpdate(Resource resource);

}
