package sch.pl.graduate.recommendation.role.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;
import sch.pl.graduate.recommendation.role.model.Role;

import java.util.List;

/**
 * Created by taesu on 2017-10-14.
 */
@Repository
@Mapper
public interface RoleMapper {
    Role getRole(Role role);

    Role getRoleByRoleKey(Long roleKey);

    Role getRoleByRoleName(String roleName);

    List<GrantedAuthority> getUserRolesByUserId(String userId);
}
