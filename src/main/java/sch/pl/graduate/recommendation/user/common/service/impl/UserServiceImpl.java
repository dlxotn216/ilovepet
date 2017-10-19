package sch.pl.graduate.recommendation.user.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import sch.pl.graduate.recommendation.common.exception.SystemException;
import sch.pl.graduate.recommendation.common.service.AbstractService;
import sch.pl.graduate.recommendation.file.model.AppFile;
import sch.pl.graduate.recommendation.file.service.FileService;
import sch.pl.graduate.recommendation.role.model.Role;
import sch.pl.graduate.recommendation.role.service.RoleService;
import sch.pl.graduate.recommendation.user.caretaker.model.Caretaker;
import sch.pl.graduate.recommendation.user.caretaker.service.CaretakerService;
import sch.pl.graduate.recommendation.user.common.mapper.UserMapper;
import sch.pl.graduate.recommendation.user.common.model.User;
import sch.pl.graduate.recommendation.user.common.model.UserCriteria;
import sch.pl.graduate.recommendation.user.common.service.UserService;
import sch.pl.graduate.recommendation.user.consigner.model.Consigner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taesu on 2017-10-14.
 */
@Service
public class UserServiceImpl extends AbstractService implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private FileService fileService;

    @Autowired

    private CaretakerService caretakerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Long addUser(User user) {
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);

        String roleName = user.getRoleName();
        Role role = roleService.getRoleByRoleName(roleName);
        if (role == null) {
            throw new SystemException("Role이 존재하지 않습니다");
        }

        user.setRoleKey(role.getRoleKey());
        userMapper.addUser(user);
        return user.getUserKey();
    }

    @Override
    public User getUserByUserKey(Long userKey) {
        return userMapper.getUserByUserKey(userKey);
    }

    @Override
    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    @Override
    public User getUserByUserId(String userId) {
        return userMapper.getUserByUserId(userId);
    }

    @Override
    public List<? extends User> getUsers(UserCriteria userCriteria) {
        if (hasRole("ROLE_CARETAKER")) {
            return getUsersForCaretaker(userCriteria);
        } else if (hasRole("ROLE_CONSIGNER")) {
            return getUsersForConsigner(userCriteria);
        } else if (hasRole("ROLE_ADMIN")) {
            return userMapper.getUsers(userCriteria);
        } else {
            throw new SystemException();
        }
    }

    @Override
    public Integer getUsersTotalCount(UserCriteria userCriteria) {
        if (hasRole("ROLE_CARETAKER")) {
            return getUsersForCaretakerTotalCount(userCriteria);
        } else if (hasRole("ROLE_CONSIGNER")) {
            return getUsersForConsignerTotalCount(userCriteria);
        } else if (hasRole("ROLE_ADMIN")) {
            return userMapper.getUsersTotalCount(userCriteria);
        } else {
            throw new SystemException();
        }
    }

    @Override
    public List<Consigner> getUsersForCaretaker(UserCriteria userCriteria) {
        return userMapper.getUsersForCaretaker(userCriteria);
    }

    @Override
    public Integer getUsersForCaretakerTotalCount(UserCriteria userCriteria) {
        return userMapper.getUsersForCaretakerTotalCount(userCriteria);
    }

    @Override
    public List<Caretaker> getUsersForConsigner(UserCriteria userCriteria) {
        return userMapper.getUsersForConsigner(userCriteria);
    }

    @Override
    public Integer getUsersForConsignerTotalCount(UserCriteria userCriteria) {
        return userMapper.getUsersForConsignerTotalCount(userCriteria);
    }

    @Override
    public Integer deleteUser(User user) {
        return userMapper.deleteUser(user);
    }

    @Transactional
    @Override
    public Integer updateUser(User user) {
        String password = user.getPassword();
        if (!StringUtils.isEmpty(password)) {
            String encodedPassword = passwordEncoder.encode(password);
            user.setPassword(encodedPassword);
        }

        Long updatedFileKey = user.getUpdatedProfileFileKey();
        if (updatedFileKey != null) {
            deleteUserProfileFile(user);
            user.setProfileFileKey(updatedFileKey);
        }

        return userMapper.updateUser(user);
    }

    private void deleteUserProfileFile(User user) {
        Long originFileKey = user.getProfileFileKey();
        if (originFileKey != null) {
            List<AppFile> appFiles = new ArrayList<>();
            AppFile profileFile = new AppFile();
            profileFile.setFileKey(originFileKey);
            appFiles.add(profileFile);

            fileService.deleteFiles(appFiles);
        }
    }

    @Override
    public User loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userMapper.getUserByUserId(userId);
        if (user == null) {
            throw new UsernameNotFoundException(userId + "는 존재하지 않는 계정입니다");
        }

        user.setUserName(user.getUserId());
        user.setAuthorities(getUserAuthorities(userId));
        return user;
    }

    @Override
    public User getUserFromCurrentSession() {
        User currentUser = getCurrentUser();

        return getUserByUserKey(currentUser.getUserKey());
    }

    @Override
    public Caretaker getCaretakerFromCurrentSession() {
        User currentUser = getCurrentUser();

        return caretakerService.getCaretakerByUserKey(currentUser.getUserKey());
    }


    private List<GrantedAuthority> getUserAuthorities(String userId) {
        return roleService.getUserRolesByUserId(userId);
    }
}
