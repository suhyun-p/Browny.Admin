package Browny.Admin.Model;

import Browny.Admin.Model.ApiResponse.InstructorContact;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class InstructorContactM {
    private String type;
    private String name;
    private String contact;

    public InstructorContactM(InstructorContact m) {
        this.setType(m.getType());
        this.setName(m.getName());
        this.setContact(m.getContact());
    }
}