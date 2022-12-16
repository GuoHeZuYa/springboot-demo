package com.example.demo.dao;

import com.example.demo.pojo.College;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * dao层，或者mapper层
 * 用来和数据库交互
 * @Mapper注解，声明CollegeMapper为Mapper类型的bean
 * 与类似的还有@Repository
 * 一个是mybatis的注解，一个是spring框架的注解
 * 差别不大，自行了解
 */
@Mapper
public interface CollegeMapper {

    /**
     * 可以通过@Select @Update @Delete @Insert的方式来写sql
     * 也可以通过在对应的xml文件中写,在resources/mapper这个文件夹下面
     * 另外，select * 并不是一个好习惯
     * SELECT id, collegename, shortname, code, state, usercount FROM b_college 会更好
     * @return
     */
    @Select("select * from b_college where state = 'ok' and id between 200 and 300;")
    List<College> getColleges();

    /**
     * 用xml文件写的sql
     * @param id
     * @return
     */
    College getById(Integer id);
}
