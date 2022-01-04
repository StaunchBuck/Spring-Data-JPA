package sample.practise.relationship.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="student_course",
			joinColumns = { @JoinColumn(name="student_id")},
			inverseJoinColumns= {@JoinColumn(name = "course_id")}
			)
	private List<Course> coarses;
}
