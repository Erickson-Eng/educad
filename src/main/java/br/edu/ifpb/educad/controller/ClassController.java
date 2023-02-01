package br.edu.ifpb.educad.controller;

import br.edu.ifpb.educad.dto.request.ClassRequest;
import br.edu.ifpb.educad.dto.response.ClassResponse;
import br.edu.ifpb.educad.service.ClassService;
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
@RequestMapping("/api/v1/class")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClassController {

    private ClassService classService;

    @ApiOperation(value = "Create a new class in the database")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = ClassResponse.class)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClassResponse createClass(@RequestBody @Valid ClassRequest classRequest) {
        return classService.save(classRequest);
    }

    @ApiOperation(value = "Update a class in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = ClassResponse.class)
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClassResponse updateClass(@PathVariable Long id,
                                     @RequestBody @Valid ClassRequest classRequest) {
        return classService.update(id, classRequest);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ApiOperation(value = "Delete a class from the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = ClassResponse.class)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClassResponse deleteClass(@PathVariable Long id) {
        return classService.delete(id);
    }

    @ApiOperation(value = "Find a class by ID in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = ClassResponse.class)
    })
    @GetMapping("/find-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClassResponse findClassById(@PathVariable Long id) {
        return classService.getClassById(id);
    }

}
