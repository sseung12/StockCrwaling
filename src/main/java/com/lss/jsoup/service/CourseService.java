package com.lss.jsoup.service;

import com.lss.jsoup.domain.Course;
import com.lss.jsoup.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;


    public void save(Course course) {
        courseRepository.save(course);

    }
}
