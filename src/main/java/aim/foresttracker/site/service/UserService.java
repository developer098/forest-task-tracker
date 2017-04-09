package aim.foresttracker.site.service;

import aim.foresttracker.site.entities.User;

import java.util.List;

/**
 *
 */
public interface UserService {
    User getUserByUsername(String username);

    List<String> getPermissions(String username);

    User getCurrentUser();

    Boolean isCurrentUserLoggedIn();
}
