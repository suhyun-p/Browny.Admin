package Browny.Admin.Model.ApiResponse;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
public class ClassContact {
    private Optional<Long> instructorNo;
    private Optional<String> type;
    private String contact;
}