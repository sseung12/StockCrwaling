package com.lss.jsoup.repository;

import com.lss.jsoup.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
