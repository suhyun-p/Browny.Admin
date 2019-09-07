package Browny.Admin.Model;

import Browny.Admin.Model.ApiResponse.ClassContact;
import Browny.Admin.Model.ApiResponse.ClassDetail;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ClassDetailM {
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
    private List<ClassContactM> classContactList = new ArrayList<>();
    private Optional<Long> clubNo;
    private String exposeYn;

    public ClassDetailM(ClassDetail m) {
        this.setClassNo(m.getClassNo());

        this.setGenre(m.getGenre());
        this.setRegion(m.getRegion());
        this.setClassType(m.getClassType());
        this.setOnly(m.getOnly());

        this.setTitle(m.getTitle());
        this.setClassImage(m.getClassImage());

        this.setInstructorNo1(m.getInstructorNo1());
        this.setInstructorNo2(m.getInstructorNo2());

        this.setStartDate(m.getStartDate());
        this.setEndDate(m.getEndDate());
        this.setDateSummary(m.getDateSummary());
        if (m.getDateOptionList().isPresent()) {
            this.setDateOptionList(m.getDateOptionList());
        }

        this.setStartTime(m.getStartTime());
        this.setEndTime(m.getEndTime());

        this.setLocation(m.getLocation());

        this.setMalePrice(m.getMalePrice());
        this.setFemalePrice(m.getFemalePrice());
        if (m.getPriceOptionList().isPresent()) {
            this.setPriceOptionList(m.getPriceOptionList());
        }

        this.setPayment(m.getPayment());

        if (m.getClassContactList().isPresent()) {
            for(ClassContact classContact : m.getClassContactList().get()) {
                this.getClassContactList().add(new ClassContactM(classContact));
            }
        }

        if (m.getClubNo().isPresent()) {
            this.setClubNo(m.getClubNo());
        }
    }
}
