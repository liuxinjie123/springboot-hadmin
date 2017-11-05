package com.sparrow.admin.service;

import com.sparrow.admin.entity.ArticleSort;
import com.sparrow.admin.service.support.IBaseService;

/**
 * <p>
 * 用户服务类
 * </p>
 *
 * @author 贤云
 * @since 2016-12-28
 */
public interface IArticleSortService extends IBaseService<ArticleSort, Integer> {

	/**
	 * 增加或者修改文章分类
	 * @param article
	 */
	void saveOrUpdate(ArticleSort article);

    void delete(Integer id);

}
