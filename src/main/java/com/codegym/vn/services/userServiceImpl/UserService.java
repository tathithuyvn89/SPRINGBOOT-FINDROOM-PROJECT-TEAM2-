package com.codegym.vn.services.userServiceImpl;

import com.codegym.vn.models.user.User;
import com.codegym.vn.services.CrudServiceGeneric;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends CrudServiceGeneric<User>, UserDetailsService {
}
