package com.pikacho.mapper;

import com.pikacho.entity.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * 根据输入的学生信息进行条件检索
     * 1. 当只输入用户名时， 使用用户名进行模糊检索；
     * 2. 当只输入邮箱时， 使用性别进行完全匹配
     * 3. 当用户名和性别都存在时， 用这两个条件进行查询匹配的用
     * @param student
     * @return
     */
    List<Student> selectByStudentSelective(Student student);

    /**
     * 更新非空属性
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * 非空字段才进行插入
     */
    int insertSelective(Student record);

    /**
     * - 当 studen_id 有值时， 使用 studen_id 进行查询；
     * - 当 studen_id 没有值时， 使用 name 进行查询；
     * - 否则返回空
     */
    Student selectByIdOrName(Student record);

    /**
     * 根据输入的学生信息进行条件检索
     * 1. 当只输入用户名时， 使用用户名进行模糊检索；
     * 2. 当只输入邮箱时， 使用性别进行完全匹配
     * 3. 当用户名和性别都存在时， 用这两个条件进行查询匹配的用
     */
    List<Student> selectByStudentSelectiveWhereTag(Student student);

    /**
     * 获取 id 集合中的用户信息
     * @param ids
     * @return
     */
    List<Student> selectByStudentIdList(List<Integer> ids);

    /**
     * 批量插入学生
     */
    int insertList(List<Student> students);


}
