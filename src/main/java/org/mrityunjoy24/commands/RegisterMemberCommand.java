package org.mrityunjoy24.commands;

import org.mrityunjoy24.models.Registration;
import org.mrityunjoy24.services.IRegistrationService;

import java.util.List;

public class RegisterMemberCommand implements ICommands{

    private IRegistrationService registrationService;

    public RegisterMemberCommand(IRegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @Override
    public String execute(List<String> tokens) throws Exception {
        int memberId = Integer.parseInt(tokens.get(1));
        int eventId = Integer.parseInt(tokens.get(2));

        Registration registration = registrationService.register(memberId, eventId);
        //Akshay registered to the BBD event successfully
        return  registration.getUser().getName() + " registered to the " + registration.getEvent().getName() + " event successfully";
    }
}
