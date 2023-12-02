package org.mrityunjoy24.commands;

import org.mrityunjoy24.models.User;
import org.mrityunjoy24.services.IUserService;

import java.util.List;

public class AddMemberCommand implements ICommands{
    private IUserService userService;

    public AddMemberCommand(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(List<String> tokens) throws Exception {
        int id = Integer.parseInt(tokens.get(1));
        String name = tokens.get(2);
        int superCoins = Integer.parseInt(tokens.get(3));
        User user = userService.addMember(id,name, superCoins);
        return user.getName() + " added Successfully";
    }
}
