package com.sparrow.hadmin.dao;

import com.sparrow.hadmin.dao.support.IBaseDao;
import com.sparrow.hadmin.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArticleDao extends IBaseDao<Article, Integer> {
    List<Article> findBySortName(String sortName);

}
