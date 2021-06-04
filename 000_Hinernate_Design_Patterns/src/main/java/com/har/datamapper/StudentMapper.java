package com.har.datamapper;

import java.util.Optional;

/**
 * Interface lists out the possible behavior for all possible student mappers.
 */
public interface StudentMapper {

	Optional<Student> find(int studentId);

	  void insert(Student student) throws DataMapperException;

	  void update(Student student) throws DataMapperException;

	  void delete(Student student) throws DataMapperException;
}
	
