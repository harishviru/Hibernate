package com.har.datamapper;

import java.util.Optional;

public class ClientTest {

	public static void main(String[] args) {
	
		//Create Student mapper
		StudentMapper mapper = new StudentDataMapperImpl();

		 /* Create new student */
		Student student = new Student(1, "Harish", 'A');
		
		/* Add student in respectibe store */
	    mapper.insert(student);
		
	      System.out.println( student + ", is inserted");
		
	      /* Find this student */
	      Optional<Student> studentOpt = mapper.find(student.getStudentId());
	      
	      System.out.println( studentOpt.get().getStudentName() + ", is searched");

	      
	      /* Update existing student object */
	       student = new Student(student.getStudentId(), "HarishUpdated", 'A');
	       
	       
	       /* Update student in  db */
	        mapper.update(student);
	       
		      System.out.println(student.getStudentName() + ", is updated");
		      
		      System.out.println(student.getStudentName() + ", is going to be deleted");

		      /* Delete student in db */
		      mapper.delete(student);
	}

}
