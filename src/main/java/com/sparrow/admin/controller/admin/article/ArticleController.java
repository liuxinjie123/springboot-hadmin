package com.sparrow.admin.controller.admin.article;

import com.sparrow.admin.common.JsonResult;
import com.sparrow.admin.controller.BaseController;
import com.sparrow.admin.entity.Article;
import com.sparrow.admin.service.IArticleService;
import com.sparrow.admin.service.IArticleSortService;
import com.sparrow.admin.service.IUserService;
import com.sparrow.admin.service.specification.SimpleSpecificationBuilder;
import com.sparrow.admin.service.specification.SpecificationOperator.Operator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文章管理
 **/
@Controller
@RequestMapping("/admin/article")
public class ArticleController extends BaseController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IArticleService articleService;
	@Autowired
	private IArticleSortService articleSortService;
	/**
	 * 初始化访问页面
	 */
	@RequestMapping(value = { "/", "/index" })
	public String index() {
		return "admin/article/index";
	}

	/**
	 * 获取json数据集
	 */
	@RequestMapping(value = { "/list" })
	@ResponseBody
	public Page<Article> list() {
		SimpleSpecificationBuilder<Article> builder = new SimpleSpecificationBuilder<Article>();
		String searchText = request.getParameter("searchText");
		if(StringUtils.isNotBlank(searchText)){
			builder.add("title", Operator.likeAll.name(), searchText);
		}
		PageRequest pageRequest=getPageRequest();
		Sort sort=pageRequest.getSort();
		if(null==sort){
			sort = new Sort(Sort.Direction.DESC, "createTime");
			pageRequest=getPageRequest(sort);
		}
		Page<Article> page = articleService.findAll(builder.generateSpecification(), pageRequest);
		return page;
	}

	/**
	 * 新增页面初始化
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap map) {
		//获取所有分类信息
		map.addAttribute("articleSorts",articleSortService.findAll());
		return "admin/article/form";
	}

	/**
	 * 编辑页面初始化
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, ModelMap map) {
		Article article = articleService.find(id);
		map.put("article", article);
		//获取所有分类信息
		map.addAttribute("articleSorts",articleSortService.findAll());
		return "admin/article/form";
	}

	/**
	 * 新增或者编辑文章保存
	 */
	@RequestMapping(value= {"/edit"} ,method = RequestMethod.POST)
	@ResponseBody
	public JsonResult edit(Article article){
		try {
			articleService.saveOrUpdate(article);
		} catch (Exception e) {
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}

	/**
	 * @deprecated  根据文章id删除文章信息
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(@PathVariable("id") Integer id) {
		try {
			articleService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.failure(e.getMessage());
		}
		return JsonResult.success();
	}


	/**
	 * 文章详情页面
	 */
	@GetMapping("/detail/{id}")
	public String detailNews(Model model, @PathVariable("id") Integer id) {
		Article article=articleService.find(id);
		String str = article.getDescription();
		//使用正则表达式检索出所有的<h2>...</h2>内容
		if (!org.springframework.util.StringUtils.isEmpty(str)){
			Matcher m = Pattern.compile("<h2.*?>([\\s\\S]*?)</h2>").matcher(str);
			while (m.find()) {
				//删掉<h2></h2>中间的html标签k
				String parstr=deleteAllHTMLTag(m.group(1));
				//替换内容里面所有的h2标签，动态增加id
				article.setDescription(article.getDescription().replace("<h2>"+m.group(1),"<h2 id='"+parstr+"'>"+m.group(1)));
			}
		}
		model.addAttribute("bo",article);
		return "html/blog/detail";
	}

	/**
	 * 删除所有的HTML标签
	 * @param source 需要进行除HTML的文本
	 */
	public static String deleteAllHTMLTag(String source) {
		if(source == null) {
			return "";
		}
		String s = source;
		/** 删除普通标签  */
		s = s.replaceAll("<(S*?)[^>]*>.*?|<.*? />", "");
		/** 删除转义字符 */
		s = s.replaceAll("&.{2,6}?;", "");
		return s;
	}
}
