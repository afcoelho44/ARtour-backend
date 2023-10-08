package com.br.artour.Mapper;

import com.br.artour.Entity.User;
import com.br.artour.Model.UserRequest;

public class UserRequestToEntity implements InternMapper<User, UserRequest>{
    @Override
    public User map(UserRequest request) {
        var record= new User();

        record.setName(request.getName());
        record.setAdmin(request.isAdmin());
        record.setPhone(request.getPhone());
        record.setEmail(request.getEmail());
        record.setPassword(request.getPassword());

        return record;
    }

    @Override
    public User mapUpdate(UserRequest request, User record) {
        record.setName(request.getName());
        record.setAdmin(request.isAdmin());
        record.setPhone(request.getPhone());
        record.setEmail(request.getEmail());
        record.setPassword(request.getPassword());

        return record;
    }
}
