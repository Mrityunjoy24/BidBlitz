package org.mrityunjoy24.services;

import org.mrityunjoy24.models.Event;
import org.mrityunjoy24.models.Registration;
import org.mrityunjoy24.models.User;
import org.mrityunjoy24.repositories.IRepository;

public class RegistrationService implements IRegistrationService {
    private int id=1;
    private IRepository registrationRepository;
    private IUserService userService;

    private IEventService eventService;

    public RegistrationService(IRepository eventRegistrationRepository, IUserService userService, IEventService eventService) {
        this.registrationRepository = eventRegistrationRepository;
        this.userService = userService;
        this.eventService = eventService;
    }
    @Override
    public Registration register(int memberId, int eventId) {
        User user = userService.getUserById(memberId);

        if (user == null) {
            throw new RuntimeException("User not found with id: " + memberId);
        }
        Event event = (Event) eventService.getEventById(eventId);

        if (event == null) {
            throw new RuntimeException("Event not found with id: " + eventId);
        }

        Registration registration = new Registration(id++, event, user);
        registrationRepository.save(registration);
        return registration;
    }
}
