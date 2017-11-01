package com.sparrow.hadmin.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.sparrow.hadmin.entity.support.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * 资源表
 * </p>
 */
@Entity
@Table(name = "tb_resource")
@Data
@NoArgsConstructor
public class Resource extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 * 资源名称
	 */
	private String name;
	/**
	 * 资源唯一标识
	 */
	private String sourceKey;
	/**
	 * 资源类型,0:目录;1:菜单;2:按钮
	 */
	private Integer type;
	/**
	 * 资源url
	 */
	private String sourceUrl;
	/**
	 * 层级
	 */
	private Integer level;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * 是否隐藏
	 * 0显示 1隐藏
	 */
	private Integer isHide;
	/**
	 * 描述
	 */
	private String description;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private Resource parent;

}
