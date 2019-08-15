package Browny.Admin.Model;

import Browny.Admin.Enum.ClassType;
import Browny.Admin.Enum.Genre;
import Browny.Admin.Enum.Only;
import Browny.Admin.Enum.Region;
import Browny.Admin.Model.ApiResponse.ClassSimple;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClassSimpleM {
    private Long classNo;
    private String genre;
    private String region;
    private String classType;
    private String only;
    private String title;
    private String classImage;

    public ClassSimpleM(ClassSimple m) {
        this.setClassNo(m.getClassNo());

        this.setGenre(Genre.valueOf(m.getGenreCode()).getValue());
        this.setRegion(Region.valueOf(m.getRegionCode()).getValue());

        if(m.getTypeCode() != null) {
            this.setClassType(ClassType.valueOf(m.getTypeCode()).getValue());
        }

        if(m.getOnlyCode() != null) {
            this.setOnly(Only.valueOf(m.getRegionCode()).getValue());
        }

        this.setTitle(m.getTitle());
        this.setClassImage(String.format("http://image.browny.kr/%s", m.getClassImage()));
    }
}