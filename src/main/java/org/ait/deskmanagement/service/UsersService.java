package org.ait.deskmanagement.service;

import java.util.List;
import org.ait.deskmanagement.entity.Users;
import org.ait.deskmanagement.repository.UsersRepository;
import org.springframework.stereotype.Component;

@Component
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService (final UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getUsers () {
        return usersRepository.findAll();
    }

    public Users saveUser (final Users users) {
//        users.setId(new Random().nextInt());
        return usersRepository.save(users);
    }

}
