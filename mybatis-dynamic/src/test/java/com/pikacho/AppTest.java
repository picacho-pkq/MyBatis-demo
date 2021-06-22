package com.pikacho;


import com.pikacho.entity.Student;
import com.pikacho.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static SqlSessionFactory sqlSessionFactory;
    static{
        //1.mybatis 主配置文件
        String config = "mybatis-config.xml";
        //2.读取配置文件
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3.创建 SqlSessionFactory 对象,目的是获取 SqlSession
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    @Test
    public void selectByStudent() {
        SqlSession sqlSession = null;
        sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student search = new Student();
        search.setName("明");
        System.out.println("只有名字时的查询");
        List<Student> studentsByName = studentMapper.selectByStudentSelective(search);
        for (int i = 0; i < studentsByName.size(); i++) {
            System.out.println(studentsByName.get(i));
        }

        search.setName(null);
        search.setSex(1);
        System.out.println("只有性别时的查询");
        List<Student> studentsBySex = studentMapper.selectByStudentSelective(search);
        for (int i = 0; i < studentsBySex.size(); i++) {
            System.out.println(studentsBySex.get(i));
        }

        System.out.println("姓名和性别同时存在的查询");
        search.setName("明");
        List<Student> studentsByNameAndSex = studentMapper.selectByStudentSelective(search);
        for (int i = 0; i < studentsByNameAndSex.size(); i++) {
            System.out.println(studentsByNameAndSex.get(i));
        }


        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateByStudentSelective() {
        SqlSession sqlSession = null;
        sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student = new Student();
        student.setStudent_id(1);
        student.setName("明明");
        student.setPhone("13838438888");
        System.out.println(studentMapper.updateByPrimaryKeySelective(student));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertByStudentSelective() {
        SqlSession sqlSession = null;
        sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student = new Student();
        student.setName("小飞机");
        student.setPhone("13838438899");
        student.setEmail("xiaofeiji@qq.com");
        student.setLocked(0);

        System.out.println(studentMapper.insertSelective(student));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByIdOrName() {
        SqlSession sqlSession = null;
        sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student = new Student();
        student.setName("小飞机");
        student.setStudent_id(1);

        Student studentById = studentMapper.selectByIdOrName(student);
        System.out.println("有 ID 则根据 ID 获取");
        System.out.println(studentById);

        student.setStudent_id(null);
        Student studentByName = studentMapper.selectByIdOrName(student);
        System.out.println("没有 ID 则根据 name 获取");
        System.out.println(studentByName);

        student.setName(null);
        Student studentNull = studentMapper.selectByIdOrName(student);
        System.out.println("没有 ID 和 name, 返回 null");
        Assert.assertNull(studentNull);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByStudentWhereTag() {
        SqlSession sqlSession = null;
        sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student search = new Student();
        search.setName("明");

        System.out.println("只有名字时的查询");
        List<Student> studentsByName = studentMapper.selectByStudentSelectiveWhereTag(search);
        for (int i = 0; i < studentsByName.size(); i++) {
            System.out.println(studentsByName.get(i));
        }

        search.setSex(1);
        System.out.println("姓名和性别同时存在的查询");
        List<Student> studentsBySex = studentMapper.selectByStudentSelectiveWhereTag(search);
        for (int i = 0; i < studentsBySex.size(); i++) {
            System.out.println(studentsBySex.get(i));
        }

        System.out.println("姓名和性别都不存在时查询");
        search.setName(null);
        search.setSex(null);
        List<Student> studentsByNameAndSex = studentMapper.selectByStudentSelectiveWhereTag(search);
        for (int i = 0; i < studentsByNameAndSex.size(); i++) {
            System.out.println(studentsByNameAndSex.get(i));
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByStudentIdList() {
        SqlSession sqlSession = null;
        sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        List<Integer> ids = new LinkedList<>();
        ids.add(1);
        ids.add(3);

        List<Student> students = studentMapper.selectByStudentIdList(ids);
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertList() {
        SqlSession sqlSession = null;
        sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> students = new LinkedList<>();
        Student stu1 = new Student();
        stu1.setName("批量01");
        stu1.setPhone("13888888881");
        stu1.setLocked(0);
        stu1.setEmail("13888888881@138.com");
        stu1.setSex(1);
        students.add(stu1);

        Student stu2 = new Student();
        stu2.setName("批量02");
        stu2.setPhone("13888888882");
        stu2.setLocked(0);
        stu2.setEmail("13888888882@138.com");
        stu2.setSex(0);
        students.add(stu2);

        System.out.println(studentMapper.insertList(students));
        sqlSession.commit();
        sqlSession.close();
    }

}
