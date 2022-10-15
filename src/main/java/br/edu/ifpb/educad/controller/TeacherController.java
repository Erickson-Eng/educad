package br.edu.ifpb.educad.controller;

import br.edu.ifpb.educad.dto.request.TeacherRequest;
import br.edu.ifpb.educad.dto.response.TeacherResponse;
import br.edu.ifpb.educad.service.TeacherService;
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
@RequestMapping("/api/v1/teacher")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherController {
    private TeacherService teacherService;

    @ApiOperation(value = "List all teachers in the database")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeacherResponse> list() {
        return teacherService.list();
    }

    @ApiOperation(value = "Create a new teacher in the database")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = TeacherResponse.class)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherResponse createTeacher(@RequestBody @Valid TeacherRequest teacherRequest) {
        return teacherService.save(teacherRequest);
    }

    @ApiOperation(value = "Update a teacher in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = TeacherResponse.class)
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherResponse updateTeacher(@PathVariable Long id, @RequestBody @Valid TeacherRequest teacherRequest) {
        return teacherService.update(id, teacherRequest);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ApiOperation(value = "Delete a student in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = TeacherResponse.class)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherResponse deleteTeacher(@PathVariable Long id) {
        return teacherService.delete(id);
    }

    @ApiOperation(value = "Find a teacher by ID in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = TeacherResponse.class)
    })
    @GetMapping("/find-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherResponse findTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    // findTeacherByName
}
