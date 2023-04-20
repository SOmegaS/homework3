package hw.homework3.request;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestV5 {
    private String likePattern;

    @Nullable
    private String regexPattern;

    @Nullable
    private String surname;

    @Nullable
    private Integer lowerAge;

    @Nullable
    private Integer upperAge;
}
