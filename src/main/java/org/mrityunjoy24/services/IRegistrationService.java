package org.mrityunjoy24.services;

import org.mrityunjoy24.models.Registration;

public interface IRegistrationService {
    Registration register(int memberId, int eventId);
}
