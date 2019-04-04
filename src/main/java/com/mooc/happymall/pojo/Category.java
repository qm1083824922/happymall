package com.mooc.happymall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "类别信息",value = "类别信息")
public class Category {

    @ApiModelProperty(name = "类别Id")
    private Integer id;

    @ApiModelProperty(name = "父类别Id")
    private Integer parentId;

    @ApiModelProperty(name = "类别名称")
    private String name;

    @ApiModelProperty(name = "类别状态")
    private Boolean status;

    @ApiModelProperty(name = "排序状态")
    private Integer sortOrder;

    @ApiModelProperty(name = "更新时间")
    private Date createTime;

    @ApiModelProperty(name = "创建时间")
    private Date updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Category category = (Category) o;

        return !(id != null ? !id.equals(category.id) : category.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}