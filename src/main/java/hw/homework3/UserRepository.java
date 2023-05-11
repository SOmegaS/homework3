package hw.homework3;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepository {
    ArrayList<User> users;

    UserRepository() {
        users = new ArrayList<>();
        users.add(new User(0L,"Oleg", "Vyacheslavovich", "oleg@mail.ru", 88));
        users.add(new User(1L,"Olegsey", "Memologov", "between_oleg_and_alexey@mail.ru", 12));
        users.add(new User(2L,"Alexey", "Borisov", "alexey@mail.ru", 20));
    }
}
