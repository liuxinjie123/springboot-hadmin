package com.sparrow.admin.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.sparrow.admin.entity.support.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.Date;

/**
 * 文章表
 */
@Entity
@Table(name = "tb_article")
@Data
@NoArgsConstructor
public class Article extends BaseEntity {
	private static final long serialVersionUID = -1894163644285296223L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ManyToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "tb_article_sort_relation", joinColumns = { @JoinColumn(name = "article_id") }, inverseJoinColumns = { @JoinColumn(name = "sort_id") })
	private  ArticleSort articleSort;
	/**
	 * 文章标题
	 */
	private String title;
	/**
	 * 文章作者
	 */
	private String author;
	/**
	 * 文章缩略图
	 */
	private String pic;
	/**
	 * 标签云
	 */
	private String label;
	/**
	 * 文章描述
	 */
	private String description;
	/**
	 * 文章备注
	 */
	private String remark;
	/**
	 * 角色状态,0：正常；1：删除
	 */
	private Integer status;

	private String sortName;
	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 更新时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	public String getSortName() {
		if(null!=articleSort&&!StringUtils.isEmpty(articleSort.getTitle())){
			return articleSort.getTitle();
		}
		return "";
	}

}
