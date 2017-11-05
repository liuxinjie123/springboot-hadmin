package com.sparrow.admin.dao;

import com.sparrow.admin.dao.support.IBaseDao;
import com.sparrow.admin.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArticleDao extends IBaseDao<Article, Integer> {
    List<Article> findBySortName(String sortName);

}
