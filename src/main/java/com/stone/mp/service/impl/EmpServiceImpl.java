package com.stone.mp.service.impl;

import com.stone.mp.beans.Emp;
import com.stone.mp.mapper.EmpMapper;
import com.stone.mp.service.EmpService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stone
 * @since 2018-12-24
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

}
