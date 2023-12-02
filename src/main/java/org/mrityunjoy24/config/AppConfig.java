package org.mrityunjoy24.config;

import org.mrityunjoy24.commands.*;
import org.mrityunjoy24.repositories.*;
import org.mrityunjoy24.services.*;

public class AppConfig {
    private CommandInvoker commandInvoker;
    private ICommands addMemberCommand, addEventCommand, registerMemberCommand, submitBidCommand, declareWinnerCommand, listWinnerCommand;
    private IRepository eventRepository,registrationRepository,userRepository, bidRepository, winnerRepository;
    private IUserService userService;
    private IEventService eventService;
    private IRegistrationService eventRegistrationService;
    private IBidService bidService;

    public AppConfig() {
        commandInvoker = new CommandInvoker();
        userRepository = new UserRepository();
        userService = new UserService(userRepository);
        addMemberCommand = new AddMemberCommand(userService);

        winnerRepository = new WinnerRepository();
        eventRepository = new EventRepository();
        eventService = new EventService(eventRepository, winnerRepository);
        addEventCommand = new AddEventCommand(eventService);

        registrationRepository = new RegistrationRepository();
        eventRegistrationService = new RegistrationService(registrationRepository, userService, eventService);
        registerMemberCommand = new RegisterMemberCommand(eventRegistrationService);

        bidRepository = new BidRepository();
        bidService = new BidService((BidRepository) bidRepository, userService, eventService, registrationRepository, winnerRepository);
        submitBidCommand = new SubmitBidCommand(bidService);

        declareWinnerCommand = new DeclareWinnerCommand(bidService);

        listWinnerCommand = new ListWinnerCommand(eventService);
    }

    public CommandInvoker getCommandInvoker() {
        commandInvoker.addCommand("ADD_MEMBER",addMemberCommand);
        commandInvoker.addCommand("ADD_EVENT",addEventCommand);
        commandInvoker.addCommand("REGISTER_MEMBER",registerMemberCommand);
        commandInvoker.addCommand("SUBMIT_BID",submitBidCommand);
        commandInvoker.addCommand("DECLARE_WINNER",declareWinnerCommand);
        commandInvoker.addCommand("LIST_WINNERS",listWinnerCommand);
        return commandInvoker;
    }
}
