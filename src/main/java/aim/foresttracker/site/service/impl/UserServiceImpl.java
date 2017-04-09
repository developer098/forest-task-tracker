package aim.foresttracker.site.service.impl;

import aim.foresttracker.site.entities.User;
import aim.foresttracker.site.service.UserService;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import aim.foresttracker.site.security.LoggedInChecker;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final static String USER_TEST = "root";

    private final LoggedInChecker loggedInChecker;

    @Inject
    UserServiceImpl(LoggedInChecker loggedInChecker) {
        this.loggedInChecker = loggedInChecker;
    }

    @Override
    public User getUserByUsername(String username) {
        // Just a mock interface support only one single root
        // Here you can add DAO to load user from the database
        if (username.equals(USER_TEST)) {
            User user = new User();
            user.setLogin(USER_TEST);
            user.setPassword(new ShaPasswordEncoder().encodePassword("password", null));

            return user;
        } else {
            return null;
        }
    }

    @Override
    public List<String> getPermissions(String username) {
        return new ArrayList<>();
    }

    @Override
    public User getCurrentUser() {
        return loggedInChecker.getLoggedInUser();
    }

    @Override
    public Boolean isCurrentUserLoggedIn() {
        return loggedInChecker.getLoggedInUser() != null;
    }
}

