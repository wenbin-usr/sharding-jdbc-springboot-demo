package edu.whpu;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.whpu.entity.Order;
import edu.whpu.entity.Student;
import edu.whpu.mapper.OrderMapper;
import edu.whpu.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author bin_wen
 * @date 2025/3/20 12:36
 */
@SpringBootTest
public class DemoApplicationTest {
    @Autowired
    private StudentService studentService;

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void test() {
        Student student = new Student();
        student.setAge(45);
        student.setStuNo("10015");
        student.setName("康黎明");
        studentService.save(student);
    }

    @Test
    public void test1() {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getName, "张三");
        Student student = studentService.getOne(wrapper);
        System.out.println(student);
    }

    @Test
    public void test2() {
        for (long i = 1; i < 3; i++) {

            Order order = new Order();
            order.setOrderNo("order" + i);   // 按order_no分表，hash取模，哈希值为偶数插入t_order0表，为奇数插入t_order1表
            order.setUserId(100000L);  // 按user_id分库，为偶数插入ds0数据库，为奇数插入ds1数据库
            order.setAmount(new BigDecimal(100));
            orderMapper.insert(order);
            System.out.println("------------");
        }

        for (long i = 1; i < 3; i++) {

            Order order = new Order();
            order.setOrderNo("order" + i);
            order.setUserId(100001L);
            order.setAmount(new BigDecimal(100));
            orderMapper.insert(order);
            System.out.println("------------");
        }
    }

    @Test
    public void testShardingSelectAll(){

        List<Order> orders = orderMapper.selectList(null);
        orders.forEach(System.out::println);
    }

    @Test
    public void testShardingSelectByUserId(){

        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("user_id", 100000L);
        List<Order> orders = orderMapper.selectList(orderQueryWrapper);
        orders.forEach(System.out::println);
    }

}
