package org.mrityunjoy24.services;

import org.mrityunjoy24.models.User;
import org.mrityunjoy24.repositories.IRepository;
import org.mrityunjoy24.repositories.UserRepository;

public class UserService implements IUserService{
    private IRepository userRepository;
    public UserService(IRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User addMember(int id, String name, int superCoins) throws Exception {
        User user = new User(id,name,superCoins);

        User uniqueUser = (User) userRepository.getById(id);

        if (uniqueUser!=null){
            throw new Exception("User already created with given id: "+ id);
        }

        userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(int id){
        return (User) userRepository.getById(id);
    }
}
