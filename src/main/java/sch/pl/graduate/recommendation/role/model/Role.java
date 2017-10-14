/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.role.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import sch.pl.graduate.recommendation.common.model.AbstractModel;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Data
public class Role extends AbstractModel implements GrantedAuthority{
    private Long roleKey;
    private String roleName;

    @Override
    public String getAuthority() {
        return roleName;
    }
}
