package com.aryajohary.collegedirectory.dto;

import com.aryajohary.collegedirectory.schemas.User;

public class MapperUtil {

    public static <D extends BaseProfileDTO, E extends User> void mapBaseProfileFields(D dto, E entity) {
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
    }

}
