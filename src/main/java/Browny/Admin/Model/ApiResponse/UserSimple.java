package Browny.Admin.Model.ApiResponse;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class UserSimple {
    private Long userNo;
    private String nickname;
    private String sex;
    private Boolean instructor;

}
