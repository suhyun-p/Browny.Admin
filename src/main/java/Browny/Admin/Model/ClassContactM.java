package Browny.Admin.Model;

import Browny.Admin.Model.ApiResponse.ClassContact;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
public class ClassContactM {
    private Optional<Long> instructorNo;
    private Optional<String> type;
    private String contact;

    public ClassContactM(ClassContact m) {
        this.setInstructorNo(m.getInstructorNo());
        this.setType(m.getType());
        this.setContact(m.getContact());
    }
}