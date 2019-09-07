package Browny.Admin.Model;

import Browny.Admin.Model.ApiResponse.InstructorContact;
import Browny.Admin.Model.ApiResponse.UserDetail;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDetailM {
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
    private List<InstructorContactM> contactList;

    public UserDetailM(UserDetail m){
        this.setUserNo(m.getUserNo());
        this.setNickname(m.getNickname());
        this.setSex(m.getSex());
        this.setInstructor(m.getInstructor());

        if(m.getInstructor()) {
            if(m.getAccount() != null) this.setAccount(m.getAccount());
            if(m.getCareerList() != null && !m.getCareerList().isEmpty()) {
                this.careerList = new ArrayList<>();
                m.getCareerList().forEach(x -> this.careerList.add(x));
            }
            if(m.getContactList() != null && !m.getContactList().isEmpty()) {
                this.contactList = new ArrayList<>();
                m.getContactList().forEach(x -> this.contactList.add(new InstructorContactM(x)));
            }
        }
    }
}