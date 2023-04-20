package hw.homework3;

import com.fasterxml.jackson.core.JsonProcessingException;
import hw.homework3.request.RequestV1;
import hw.homework3.request.RequestV4;
import hw.homework3.request.RequestV5;
import hw.homework3.response.ResponseV1;
import hw.homework3.response.ResponseV2;
import hw.homework3.response.ResponseV3;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static hw.homework3.LikeToRegex.likeToRegex;

@RestController
public class Controller {
    UserRepository userRepository;

    @Autowired
    Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/api/v1/get-like")
    public ResponseV1 getLikeV1(@Nullable @RequestBody RequestV1 request) {
        if (request == null) {
            request = new RequestV1();
        }
        if (request.getLikePattern() == null) {
            request.setLikePattern("%");
        }
        String regexPattern = likeToRegex(request.getLikePattern());
        ResponseV1 response = new ResponseV1();
        for (User user : userRepository.users) {
            if (user.login().matches(regexPattern)) {
                response.getLogins().add(user.login());
            }
        }
        return response;
    }

    @GetMapping("/api/v2/get-like")
    public ResponseV2 getLikeV2(@Nullable @RequestBody RequestV1 request) {
        if (request == null) {
            request = new RequestV1();
        }
        if (request.getLikePattern() == null) {
            request.setLikePattern("%");
        }
        String regexPattern = likeToRegex(request.getLikePattern());
        ResponseV2 response = new ResponseV2();
        response.setUserCount(userRepository.users.size());
        for (User user : userRepository.users) {
            if (user.login().matches(regexPattern)) {
                response.getLogins().add(user.login());
            }
        }
        return response;
    }

    @GetMapping("/api/v3/get-like")
    public ResponseV3 getLikeV3(@Nullable @RequestBody RequestV1 request) throws JsonProcessingException {
        if (request == null) {
            request = new RequestV1();
        }
        if (request.getLikePattern() == null) {
            request.setLikePattern("%");
        }
        String regexPattern = likeToRegex(request.getLikePattern());
        ResponseV3 response = new ResponseV3();
        response.setUserCount(userRepository.users.size());
        for (User user : userRepository.users) {
            if (user.login().matches(regexPattern)) {
                response.getUsers().add(user);
                response.getLogins().add(user.login());
            }
        }
        return response;
    }

    @GetMapping("/api/v4/get-like")
    public ResponseV3 getLikeV4(@Nullable @RequestBody RequestV4 request) throws JsonProcessingException {
        if (request == null) {
            request = new RequestV4();
        }
        if (request.getLikePattern() == null) {
            request.setLikePattern("%");
        }
        if (request.getRegexPattern() == null) {
            request.setRegexPattern(likeToRegex(request.getLikePattern()));
        }
        ResponseV3 response = new ResponseV3();
        response.setUserCount(userRepository.users.size());
        for (User user : userRepository.users) {
            if (user.login().matches(request.getRegexPattern())) {
                response.getUsers().add(user);
                response.getLogins().add(user.login());
            }
        }
        return response;
    }

    @GetMapping("api/v5/get-like")
    public ResponseV3 getLikeV5(@Nullable @RequestBody RequestV5 request) throws JsonProcessingException {
        if (request == null) {
            request = new RequestV5();
        }
        if (request.getLikePattern() == null) {
            request.setLikePattern("%");
        }
        if (request.getRegexPattern() == null) {
            request.setRegexPattern(likeToRegex(request.getLikePattern()));
        }
        ResponseV3 response = new ResponseV3();
        response.setUserCount(userRepository.users.size());
        for (User user : userRepository.users) {
            boolean isMatchesPattern = user.login().matches(request.getRegexPattern());
            boolean isMatchesSurname = request.getSurname() == null || Objects.equals(user.surname(), request.getSurname());
            boolean isMatchesAge =
                    (request.getLowerAge() == null || request.getLowerAge() <= user.age()) &&
                            (request.getUpperAge() == null || user.age() <= request.getUpperAge());
            if (isMatchesPattern && isMatchesSurname && isMatchesAge) {
                response.getUsers().add(user);
                response.getLogins().add(user.login());
            }
        }
        return response;
    }
}
