package sch.pl.graduate.recommendation.role.service;

import org.springframework.security.core.GrantedAuthority;
import sch.pl.graduate.recommendation.role.model.Role;

import java.util.List;

/**
 * Created by taesu on 2017-10-14.
 */
public interface RoleService {

    Role getRole(Role role);

    Role getRoleByRoleKey(Long roleKey);

    Role getRoleByRoleName(String roleName);

    List<GrantedAuthority> getUserRolesByUserId(String userId);
}
