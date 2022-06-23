package com.codegym.md4casequizz.service.role;

import com.codegym.md4casequizz.model.Role;
import com.codegym.md4casequizz.model.RoleName;


import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);

}
