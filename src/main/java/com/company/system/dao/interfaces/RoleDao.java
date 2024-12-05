package com.company.system.dao.interfaces;

import com.company.system.model.Role;

public interface RoleDao extends Dao<Role>{
    Role findByName(String name);

}
