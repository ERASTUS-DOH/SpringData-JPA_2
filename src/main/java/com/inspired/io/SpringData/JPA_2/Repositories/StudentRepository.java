package com.inspired.io.SpringData.JPA_2.Repositories;

import com.inspired.io.SpringData.JPA_2.Model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<Student , Integer> {
    @Query("from Student")
    List<Student>findAllStudents();

    @Query("select st.firstname, st.lastname from Student st")
    List<Object[]> findAllStudentsPartialData();

    @Query("from Student where firstname=:firstname")
    List<Student> findAllStudentsByFirstName(@Param("firstname") String firstname);

    @Query("from Student where score>:min and score<:max")
    List<Student> findAllStudentsByGivenScore(@Param("min") double min, @Param("max") double max, Pageable pageable);

//    @Modifying
//    @Query("delete from Student where firstname=:firstname")
//    List<Student> deleteStudentByFirstName(@Param("firstname") String firstname);

    //using real native sql query statement.
    @Query(value = "select * from Student", nativeQuery = true)
    List<Student> findAllStudentsNativeQuery();

    //find Statement using native query.
    @Query(value = "select * from Student where fname=:firstname", nativeQuery = true )
    Student findStudentByFirstnameNativeQuery(@Param("firstname") String firstname);


}
