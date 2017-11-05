package com.sparrow.admin.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.sparrow.admin.entity.support.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * 文章分类表
 * </p>
 */
@Entity
@Table(name = "tb_article_sort")
@Data
@NoArgsConstructor
public class ArticleSort extends BaseEntity{
	private static final long serialVersionUID = -1894163644285296223L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 分类名称
	 */
	private String title;

	/**
	 * 分类描述
	 */
	private String description;

	/**
	 * 状态,0：正常；1：删除
	 */
	private Integer status;

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

}
