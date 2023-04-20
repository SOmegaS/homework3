package hw.homework3.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ResponseV2 {
    private ArrayList<String> logins;

    private Integer userCount;

    public ResponseV2() {
        logins = new ArrayList<>();
    }
}
