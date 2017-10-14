package sch.pl.graduate.recommendation.role.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by taesu on 2017-10-14.
 */
@Repository
@Mapper
public interface RoleMapper {
    List<GrantedAuthority> getUserRolesByUserId(String userId);
}
