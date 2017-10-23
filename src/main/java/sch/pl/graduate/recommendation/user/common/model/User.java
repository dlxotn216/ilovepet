/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.user.common.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sch.pl.graduate.recommendation.common.model.AbstractModel;
import sch.pl.graduate.recommendation.file.model.AppFile;
import sch.pl.graduate.recommendation.file.model.AppFile;
import sch.pl.graduate.recommendation.role.model.Role;

import java.util.List;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Data
public class User extends AbstractModel implements UserDetails {
    private Long userKey;
    private String userId;
    private String userName;
    private String password;
    private String birth;
    private Integer age;
    private GenderType gender;
    private String email;
    private String phone;
    private Long roleKey;
    private String roleName;
    private Long profileFileKey;
    private Role role;
    private AppFile profileFile;
    private Long cityTypeKey;
    private CityType cityType;

    private Long updatedProfileFileKey;

    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private List<GrantedAuthority> authorities;

    //Lombok에서 getUsername과 겹침
    public String getUserName(){
        return userName;
    }

    @Override
    public String getUsername() {
        return userId;
    }


}
