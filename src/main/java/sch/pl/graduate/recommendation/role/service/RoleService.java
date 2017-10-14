package sch.pl.graduate.recommendation.role.service;

import org.springframework.security.core.GrantedAuthority;
import sch.pl.graduate.recommendation.role.model.Role;

import java.util.List;

/**
 * Created by taesu on 2017-10-14.
 */
public interface RoleService {
    List<GrantedAuthority> getUserRolesByUserId(String userId);
}
