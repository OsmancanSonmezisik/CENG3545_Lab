package com.osmancansonmezisik.lab11;

import androidx.core.content.ContextCompat;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UniversityDAO {

    @Query("Select * from department")
    List<Department> getAllDepartments();

    @Query("Select * from course where deptId = :deptId")
    List<Course> getCourses(long deptId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertDepartment(Department department);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCourses(Course... courses);

    @Update
    void updateDepartment(Department department);

    @Update
    void updateCourse(Course course);

    @Delete
    void deleteDepartment(Department department);

    @Delete
    void deleteCourse(Course course);


}
