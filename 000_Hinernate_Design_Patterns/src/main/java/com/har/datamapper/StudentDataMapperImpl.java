package com.har.datamapper;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class StudentDataMapperImpl implements StudentMapper {

	/* Note:Actaully it is a Database (Temp)  */
	  private final List<Student> students = new ArrayList<>();
	
	
	@Override
	public Optional<Student> find(int studentId) {
		return this.getStudents().stream().filter(stud -> stud.getStudentId() == studentId).findFirst();
	}

	@Override
	public void insert(Student student) throws DataMapperException {
		Optional<Student> stud = find(student.getStudentId());
	    if (stud.isPresent()) {
	      String name = student.getStudentName();
	      throw new DataMapperException("Student already [" + name + "] exists");
	    }
	    students.add(student);
	}

	@Override
	public void update(Student student) throws DataMapperException {
		String name = student.getStudentName();
		Integer index = Optional.of(student)
		        .map(Student::getStudentId)
		        .flatMap(this::find) //calling above find method
		        .map(students::indexOf)
		        .orElseThrow(() -> new DataMapperException("Student [" + name + "] is not found"));
		    students.set(index, student);
	}

	@Override
	public void delete(Student student) throws DataMapperException {
		if (!students.remove(student)) {
		      String name = student.getStudentName();
		      throw new DataMapperException("Student [" + name + "] is not found");
		    }
	}

	 public List<Student> getStudents() {
		    return this.students;
		  }
}
