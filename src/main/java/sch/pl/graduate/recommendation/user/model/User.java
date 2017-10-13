/**
 * @author Lee Tae Su
 * @project recommendation
 * @version 1.0
 * @since 2017-10-13
 */
package sch.pl.graduate.recommendation.user.model;

import lombok.Data;
import sch.pl.graduate.recommendation.common.model.AbstractModel;
import sch.pl.graduate.recommendation.file.model.File;
import sch.pl.graduate.recommendation.role.model.Role;

/**
 * Created by Lee Tae Su on 2017-10-13.
 */
@Data
public class User extends AbstractModel {
    private Long userKey;
    private String userId;
    private String password;
    private Integer age;
    private Boolean gender;
    private String email;
    private String phone;
    private Role role;
    private File profileFile;
}
