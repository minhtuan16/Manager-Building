package com.example.demo.service;

import com.example.demo.entity.Role;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}