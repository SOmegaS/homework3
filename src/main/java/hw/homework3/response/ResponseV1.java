package hw.homework3.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ResponseV1 {
    private ArrayList<String> logins;


    public ResponseV1() {
        logins = new ArrayList<>();
    }
}
