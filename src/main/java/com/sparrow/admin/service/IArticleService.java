package com.sparrow.admin.service;

import com.sparrow.admin.entity.Article;
import com.sparrow.admin.service.support.IBaseService;
import com.sparrow.admin.vo.Tags;

import java.util.List;

/**
 * <p>
 * 用户服务类
 * </p>
 *
 * @author 贤云
 * @since 2016-12-28
 */
public interface IArticleService extends IBaseService<Article, Integer> {

	/**
	 * 增加或者修改文章
	 * @param article
	 */
	void saveOrUpdate(Article article);

    void delete(Integer id);
	java.util.List<Article> findBySortName(String sortName);
	List<Tags> findTags(String  tag);
	List<Article> findAllByLabel(String label);
}
