package sch.pl.graduate.recommendation.user.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.common.model.User;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;
import sch.pl.graduate.recommendation.user.common.model.UserLoginHistory;
import sch.pl.graduate.recommendation.user.consigner.model.Consigner;

import java.util.List;

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

    List<User> getUsers(UserCriteria userCriteria);

    Integer getUsersTotalCount(UserCriteria userCriteria);

    Integer updateUser(User user);

    Integer deleteUser(User user);

    Integer addUserLoginHistory(UserLoginHistory userLoginHistory);
}
