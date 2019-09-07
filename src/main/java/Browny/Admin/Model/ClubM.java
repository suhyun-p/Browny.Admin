package Browny.Admin.Model;

import Browny.Admin.Model.ApiResponse.ClubResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClubM {
    private Long clubNo;
    private String clubName;

    public ClubM(ClubResponse response) {
        this.setClubNo(response.getClubNo());
        this.setClubName(response.getClubName());
    }
}