/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.home.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.home.service.HomeService;
import sch.pl.graduate.recommendation.user.admin.mapper.AdminMapper;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Service
public class HomeServiceImpl implements HomeService{
    private static final Logger log = LoggerFactory.getLogger(HomeServiceImpl.class);
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Integer test() {
        log.info(adminMapper.test()+" is test result ");
        return adminMapper.test();
    }
}
