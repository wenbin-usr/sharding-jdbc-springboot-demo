package edu.whpu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.whpu.entity.Student;
import edu.whpu.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
 * @author bin_wen
 * @date 2025/3/20 12:33
 */
@Service
public class StudentService extends ServiceImpl<StudentMapper, Student> {
}
