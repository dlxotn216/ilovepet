package sch.pl.graduate.recommendation.user.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sch.pl.graduate.recommendation.user.common.model.User;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;

/**
 * Created by taesu on 2017-10-14.
 */
@Repository
@Mapper
public interface UserMapper {
    Integer addUser(User user);

    User getUser(User user);

    User getUserByUserKey(Long userKey);

    User getUserByUserId(String userId);

    User getUsers(UserCriteria userCriteria);

    Long getUsersTotalCount(UserCriteria userCriteria);

    Integer updateUser(User user);

    Integer deleteUser(User user);
}
