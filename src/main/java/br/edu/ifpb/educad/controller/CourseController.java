package br.edu.ifpb.educad.controller;

import br.edu.ifpb.educad.dto.request.CourseRequest;
import br.edu.ifpb.educad.dto.response.CourseResponse;
import br.edu.ifpb.educad.service.CourseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CourseController {

    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "List all courses in the database")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CourseResponse> list() {
        return courseService.list();
    }

    @ApiOperation(value = "Create a new course in the database")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = CourseResponse.class)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse createCourse(@RequestBody @Valid CourseRequest courseRequest) {
        return courseService.save(courseRequest);
    }

    @ApiOperation(value = "Update a course in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = CourseResponse.class)
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseResponse updateCourse(@PathVariable Long id, @RequestBody @Valid CourseRequest courseRequest) {
        return courseService.update(id, courseRequest);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ApiOperation(value = "Delete a course from the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = CourseResponse.class)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseResponse deleteCourse(@PathVariable Long id) {
        return courseService.delete(id);
    }

    @ApiOperation(value = "Find a course by ID in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = CourseResponse.class)
    })
    @GetMapping("/find-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseResponse findCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

}
