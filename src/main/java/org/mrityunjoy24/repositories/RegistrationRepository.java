package org.mrityunjoy24.repositories;

import org.mrityunjoy24.models.Registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationRepository implements IRepository<Registration>{

    private Map<Integer, Registration> registrationsMap = new HashMap<>();
    @Override
    public void save(Registration registration) {
        registrationsMap.put(registration.getId(), registration);
    }

    @Override
    public Registration getById(int id) {
        return registrationsMap.get(id);
    }

    @Override
    public List<Registration> getAll() {
        List<Registration> registrations = new ArrayList<>();
        //iterate over the map and get all the registrations
        for(Map.Entry<Integer, Registration> entry : registrationsMap.entrySet()){
            registrations.add(entry.getValue());
        }
        return registrations;
    }
}
