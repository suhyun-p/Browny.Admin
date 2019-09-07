package Browny.Admin.Model;

import Browny.Admin.Model.ApiResponse.InstructorContact;
import Browny.Admin.Model.ApiResponse.UserSimple;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class UserSimpleM {
    @NonNull
    private Long userNo;
    @NonNull
    private String nickname;
    @NonNull
    private String sex;
    @NonNull
    private Boolean instructor;

    public UserSimpleM(UserSimple m) {
        this.setUserNo(m.getUserNo());
        this.setNickname(m.getNickname());
        this.setSex(m.getSex());
        this.setInstructor(m.getInstructor());
    }
}