package br.edu.ifpb.educad.controller;

import br.edu.ifpb.educad.dto.request.StudentRequest;
import br.edu.ifpb.educad.dto.response.StudentResponse;
import br.edu.ifpb.educad.dto.response.table.StudentResponseTable;
import br.edu.ifpb.educad.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {

    private StudentService studentService;

    @ApiOperation(value = "Create a new student in the database")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = StudentResponse.class)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse createStudent(@RequestBody @Valid StudentRequest studentRequest){
        return studentService.save(studentRequest);
    }

    @ApiOperation(value = "Update a student in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = StudentResponse.class)
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse updateStudentInfo(@PathVariable Long id,
                                             @RequestBody @Valid StudentRequest studentRequest){
        return studentService.update(id, studentRequest);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ApiOperation(value = "Delete a student in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = StudentResponse.class)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse deleteStudent(@PathVariable Long id){
        return studentService.delete(id);
    }

    @ApiOperation(value = "Find a student by ID in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = StudentResponse.class)
    })
    @GetMapping("/find-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse findStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @ApiOperation(value = "Find a student by name in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = StudentResponse.class)
    })
    @GetMapping("/find-by-name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponseTable findStudentByName(@PathVariable String name){
        StudentResponseTable studentResponseTable = new StudentResponseTable();
        studentResponseTable.setStudentResponseList(studentService.getStudentByName(name));
        return studentResponseTable;
    }
}
