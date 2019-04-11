package com.core.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * 实体类继承这个类
 * @author wendong
 *
 * 2019年2月22日
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Serializable {
	private Integer ID;// 主键
	private String createBy;// 创建人
	private String updateBy;// 更新人
	private Date createTime;// 创建时间
	private Date updateTime;// 更新时间

}
