package Browny.Admin.Model.ApiResponse;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ClassSimple {
    private Long classNo;
    private String genre;
    private String region;
    private String classType;
    private String only;
    private long instructorNo1;
    private String instructorNickname1;
    private long instructorNo2;
    private String instructorNickname2;
    private long clubNo;
    private String clubName;
    private String title;
    private String classImage;
}