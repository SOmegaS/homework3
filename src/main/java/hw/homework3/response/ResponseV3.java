package hw.homework3.response;

import hw.homework3.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ResponseV3 {
    @Deprecated(forRemoval = true)
    private ArrayList<String> logins;

    private Integer userCount;

    private ArrayList<User> users;

    public ResponseV3() {
        logins = new ArrayList<>();
        users = new ArrayList<>();
    }
}
