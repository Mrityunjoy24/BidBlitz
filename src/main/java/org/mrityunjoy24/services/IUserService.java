package org.mrityunjoy24.services;

import org.mrityunjoy24.models.User;

public interface IUserService {
    User addMember(int id, String name, int superCoins) throws Exception;

    User getUserById(int memberId);
}
