package edu.whpu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.whpu.entity.Order;
import edu.whpu.mapper.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {
}
