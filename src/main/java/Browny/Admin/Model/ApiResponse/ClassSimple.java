package Browny.Admin.Model.ApiResponse;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClassSimple {
    private Long classNo;
    private String genreText;
    private String genreCode;
    private String regionText;
    private String regionCode;
    private String typeText;
    private String typeCode;
    private String onlyText;
    private String onlyCode;
    private String title;
    private String classImage;
}