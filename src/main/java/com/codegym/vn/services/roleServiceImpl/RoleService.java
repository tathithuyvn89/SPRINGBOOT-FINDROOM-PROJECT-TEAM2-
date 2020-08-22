package com.codegym.vn.services.roleServiceImpl;

import com.codegym.vn.models.Role;
import com.codegym.vn.services.CrudServiceGeneric;

public interface RoleService extends CrudServiceGeneric<Role> {
    Role findByName(String name);
}
