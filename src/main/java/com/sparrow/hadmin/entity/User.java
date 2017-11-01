package com.sparrow.hadmin.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.sparrow.hadmin.entity.support.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 * 用户账户表
 * </p>
 */
@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
public class User extends BaseEntity {
	private static final long serialVersionUID = 1L;
	/**
	 * 用户id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;
	/**
	 * 账户名
	 */
	private String userName;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 用户密码
	 */
	private String password;
	/**
	 * 性别 0 女 1 男
	 */
	private Integer sex;
	/**
	 * 出生日期
	 */
	@JSONField(format = "yyyy-MM-dd")
	private Date birthday;
	/**
	 * 电话
	 */
	private String telephone;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 住址
	 */
	private String address;
	/**
	 * 逻辑删除状态 0 未删除 1 删除
	 */
	private Integer deleteStatus;
	/**
	 * 是否锁定
	 * 0 未锁定 1 锁定
	 */
	private Integer locked;
	/**
	 * 用户描述
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

	@ManyToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinTable(name = "tb_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private java.util.Set<Role> roles;

}
