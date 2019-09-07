package Browny.Admin.Model.ApiResponse;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class ClassDetail {
    private Long classNo;
    private String genre;
    private String region;
    private Optional<String> classType;
    private Optional<String> only;
    private String title;
    private String classImage;
    private Long instructorNo1;
    private Optional<Long> instructorNo2;
    private String startDate;
    private String endDate;
    private Optional<String> dateSummary;
    private Optional<List<String>> dateOptionList;
    private String startTime;
    private String endTime;
    private String location;
    private int malePrice;
    private int femalePrice;
    private Optional<List<String>> priceOptionList;
    private Optional<String> payment;
    private Optional<List<ClassContact>> classContactList;
    private Optional<Long> clubNo;
    private String exposeYn;
}
