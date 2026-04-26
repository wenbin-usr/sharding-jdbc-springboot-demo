package edu.whpu;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.whpu.entity.Student;
import edu.whpu.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author bin_wen
 * @date 2025/3/20 12:36
 */
@SpringBootTest
public class DemoApplicationTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void test() {
        Student student = new Student();
        student.setAge(21);
        student.setName("张程程");
        studentService.save(student);
    }

    @Test
    public void test1() {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getName, "张三");
        Student student = studentService.getOne(wrapper);
        System.out.println(student);
    }
}
