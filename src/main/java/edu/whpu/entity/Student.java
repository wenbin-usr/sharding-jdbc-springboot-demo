package edu.whpu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bin_wen
 * @date 2025/3/20 12:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("student")
public class Student {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("stuno")
    private String stuNo;

    private String name;

    private Integer age;
}
