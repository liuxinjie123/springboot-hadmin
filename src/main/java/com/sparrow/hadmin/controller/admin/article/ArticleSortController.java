package com.sparrow.hadmin.controller.admin.article;

import com.sparrow.hadmin.common.JsonResult;
import com.sparrow.hadmin.controller.BaseController;
import com.sparrow.hadmin.entity.ArticleSort;
import com.sparrow.hadmin.service.IArticleSortService;
import com.sparrow.hadmin.service.specification.SimpleSpecificationBuilder;
import com.sparrow.hadmin.service.specification.SpecificationOperator.Operator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 文章分类管理
 **/
@Controller
@RequestMapping("/admin/article/sort")
public class ArticleSortController extends BaseController {
    @Autowired
    private IArticleSortService articleSortService;

    /**
     * 初始化访问页面
     */
    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "admin/article/sort/index";
    }

    /**
     * 获取json数据集
     */
    @RequestMapping(value = {"/list"})
    @ResponseBody
    public Page<ArticleSort> list() {
        Page<ArticleSort> page = null;
        try {
            SimpleSpecificationBuilder<ArticleSort> builder = new SimpleSpecificationBuilder<ArticleSort>();
            String searchText = request.getParameter("searchText");
            if (StringUtils.isNotBlank(searchText)) {
                builder.add("nickName", Operator.likeAll.name(), searchText);
            }
            page = articleSortService.findAll(builder.generateSpecification(), getPageRequest());

        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

        return page;
    }

    /**
     * 新增页面初始化
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap map) {
        return "admin/article/sort/form";
    }

    /**
     * 编辑页面初始化
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, ModelMap map) {
        ArticleSort article = articleSortService.find(id);
        map.put("articleSort", article);
        return "admin/article/sort/form";
    }

    /**
     * 新增或者编辑文章保存
     */
    @RequestMapping(value = {"/edit"}, method = RequestMethod.POST)
    @ResponseBody
    public JsonResult edit(ArticleSort article, ModelMap map) {
        try {
            articleSortService.saveOrUpdate(article);
        } catch (Exception e) {
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    /**
     * 根据文章id删除文章信息
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Integer id, ModelMap map) {
        try {
            articleSortService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

}
