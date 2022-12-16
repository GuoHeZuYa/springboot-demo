package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 声明一个College类
 * 下面三个都是lombok注解
 * 很有用也很常用
 * lombok还有很多有意思的注解
 * 自行了解
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class College{
    private Integer id;
    private String collegeName;
    private String shortName;
    private String code;
    private String state;
    private Integer userCount;
}
