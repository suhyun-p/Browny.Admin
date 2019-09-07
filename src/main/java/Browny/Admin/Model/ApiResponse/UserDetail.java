package Browny.Admin.Model.ApiResponse;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
public class UserDetail {
    @NonNull
    private Long userNo;
    @NonNull
    private String nickname;
    @NonNull
    private String sex;
    @NonNull
    private Boolean instructor;
    private String account;
    private List<String> careerList;
    private List<InstructorContact> contactList;
}
