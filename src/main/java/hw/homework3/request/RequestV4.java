package hw.homework3.request;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestV4 {
    @Nullable
    private String likePattern;

    @Nullable
    private String regexPattern;
}
