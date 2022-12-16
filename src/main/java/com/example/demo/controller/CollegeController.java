package com.example.demo.controller;


import com.example.demo.pojo.College;
import com.example.demo.service.CollegeService;
import com.example.demo.utils.ResponseCode;
import com.example.demo.utils.ResponseHelper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @ClassName: CollegeController
 * @Description:
 * @Author: 过河卒
 * @Version: 1.0
 */

/**
 * Controller层，和前端交互
 * @restController = @Controller + @ResponseBody
 * 具体作用可以搜索了解
 * 配合根路径下的generated-requests.http看
 */
@RestController
@RequestMapping ("/api/v1")
public class CollegeController {
    /**
     * @Resource注解和@Autowired功能基本一致
     * 都是用来进行依赖注入的
     * 在使用上有细微差别，根据个人偏好使用
     */
    @Resource
    CollegeService collegeService;

    /**
     * 此处定义了一个接口
     * 子路由为/test
     * 返回一个String,可以试试如果只有@Controller会发生什么
     * @return
     */
    @GetMapping("/test")
    public String test(){
        return "test";
    }

    /**
     * 子路由为/colleges
     * 返回的是一个用ResponseHelper封装的List，list里面的元素是College
     * 因为@RestController的关系
     * 返回的内容将以json形式展示
     * @return
     */
    @GetMapping("/colleges")
    public ResponseHelper<List<College>> getColleges(){
        List<College> ret = collegeService.getColleges();
        if(!Objects.isNull(ret)){
            return new ResponseHelper<>(collegeService.getColleges());
        }else {
            //使用响应的错误码
            return ResponseHelper.error(ResponseCode.ERROR);
        }

    }


}
