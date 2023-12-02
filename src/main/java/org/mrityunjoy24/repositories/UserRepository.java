package org.mrityunjoy24.repositories;

import org.mrityunjoy24.models.Registration;
import org.mrityunjoy24.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository implements IRepository<User>{
    private Map<Integer, User> usersMap = new HashMap<>();

    @Override
    public void save(User user) {
        usersMap.put(user.getId(), user);
    }

    @Override
    public User getById(int id) {
        return usersMap.get(id);
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        //iterate over the map and get all the registrations
        for(Map.Entry<Integer, User> entry : usersMap.entrySet()){
            users.add(entry.getValue());
        }
        return users;
    }
}
