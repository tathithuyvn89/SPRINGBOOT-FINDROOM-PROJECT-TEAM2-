package com.codegym.vn.services.customerServiceImpl;

import com.codegym.vn.models.User;
import com.codegym.vn.services.CrudServiceGeneric;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends CrudServiceGeneric<User>, UserDetailsService {
    User findByUsername(String username);
}
