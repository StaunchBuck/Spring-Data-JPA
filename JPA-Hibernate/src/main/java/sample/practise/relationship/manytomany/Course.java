package sample.practise.relationship.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
public class Course {

	@ManyToMany(mappedBy = "coarses")
	private Set<Student> students = new HashSet<>();
}
