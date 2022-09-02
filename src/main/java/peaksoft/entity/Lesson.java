package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "lessons")
@Getter @Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @SequenceGenerator(name = "lesson_gen",
    sequenceName = "lesson_seq",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lesson_gen")

   private Long id;
   @Column(name = "lesson_name")
   private String lessonName;

    public Lesson(String lessonName) {
        this.lessonName = lessonName;
    }
    @ManyToOne(cascade = {DETACH,MERGE,REFRESH,PERSIST})
    private Course course;
    @OneToMany(cascade = ALL, mappedBy = "lesson", fetch = EAGER)
    private List<Task> tasks;

    @OneToOne(cascade = ALL, mappedBy = "lesson")
    private Video video;

    public void setTask(Task task){
        this.tasks.add(task);
    }
}


