package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class Company {
    @Id
    @SequenceGenerator(name = "company_gen",
    sequenceName = "company_seq",
    allocationSize = 1)
    @GeneratedValue(generator = "company_gen")
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    private String locatedCountry;
    public Company(String companyName, String locatedCountry) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
    }
    @OneToMany(cascade = ALL, mappedBy = "company")
    private List<Student> students = new ArrayList<>();
    @OneToMany(cascade = ALL, mappedBy = "company")
    private List<Course> courses = new ArrayList<>();

    @OneToMany(cascade = {MERGE, PERSIST, DETACH, REFRESH}, mappedBy = "company")
    private List<Instructor> instructors;


    public void setCourse(Course course){
        this.courses.add(course);

    }
    public void setStudent(Student student){
        this.students.add(student);
    }
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", locatedCountry='" + locatedCountry + '\'' +
                '}';
    }
}
