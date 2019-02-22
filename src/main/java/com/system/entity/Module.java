package com.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * <p>模块表对象</p>
 * @author liwei
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "module")
public class Module extends BaseEntity<Module> {


	@ApiModelProperty(value = "模块名称")
	private String name;

	@ApiModelProperty(value = "父模块")
	private Module parentModule;

	@ApiModelProperty(value = "模块类型 1主菜单 2左侧菜单 3按钮 。。。")
	private String type;

	@ApiModelProperty(value = "描述")
	private String remark;

	@ApiModelProperty(value = "路径")
	private String url;

	@ApiModelProperty(value = "是否被选中")
	private String checked;

	/**
	 * 为Ztree树 展现层级结构
	 * @return	Integer
	 */
	public Integer getpId() {
		if (parentModule != null) {
			return parentModule.getID();
		}
		return null;
	}
}
