/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-16
 */
package sch.pl.graduate.recommendation.common.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sch.pl.graduate.recommendation.common.exception.SystemException;
import sch.pl.graduate.recommendation.user.common.model.User;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Lee Tae Su on 2017-10-16.
 */
@Service
public class AbstractService {
    protected Set<String> getCurrentUserRoles() {
        SecurityContext context = SecurityContextHolder.getContext();
        if(context == null)
            return Collections.emptySet();

        Authentication authentication = context.getAuthentication();
        if(authentication == null)
            return Collections.emptySet();

        return authentication.getAuthorities().stream()
                .map(r -> r.getAuthority()).collect(Collectors.toSet());
    }

    protected boolean hasRole(String role) {
        SecurityContext context = SecurityContextHolder.getContext();
        if(context == null)
            return false;

        Authentication authentication = context.getAuthentication();
        if(authentication == null)
            return false;

        for(GrantedAuthority auth : authentication.getAuthorities()) {
            if(role.equals(auth.getAuthority()))
                return true;
        }

        return false;
    }

    protected User getCurrentUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        if(context == null)
            throw new SystemException();

        Authentication authentication = context.getAuthentication();
        if(authentication == null)
            throw new SystemException();

        return (User) authentication.getPrincipal();

    }
}
