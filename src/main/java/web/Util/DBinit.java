package web.Util;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import web.model.User;
import web.service.UserService;

import javax.annotation.PostConstruct;



@Component
public class DBinit {

    private final UserService userService;

    public DBinit(UserService userService) {
        this.userService = userService;
    }

    @Lazy
    @PostConstruct
    private void initDB(){
        userService.add(new User("name1", "lastName1", 35));
        userService.add(new User("name2", "lastName2", 36));
        userService.add(new User("name3", "lastName3", 37));
        userService.add(new User("name4", "lastName4", 38));
        userService.add(new User("name5", "lastName5", 39));
    }
}
