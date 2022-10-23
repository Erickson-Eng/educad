package br.edu.ifpb.educad.controller;

import br.edu.ifpb.educad.dto.request.SubjectRequest;
import br.edu.ifpb.educad.dto.response.SubjectResponse;
import br.edu.ifpb.educad.service.SubjectService;
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
@RequestMapping("/api/v1/subject")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SubjectController {
    private SubjectService subjectService;

    @ApiOperation(value = "Create a new subject in the database")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = SubjectResponse.class)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubjectResponse createSubject(@RequestBody @Valid SubjectRequest subjectRequest) {
        return subjectService.save(subjectRequest);
    }

    @ApiOperation(value = "Update a subject in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = SubjectResponse.class)
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SubjectResponse updateSubject(@PathVariable Long id,
                                            @RequestBody @Valid SubjectRequest subjectRequest) {
        return subjectService.update(id, subjectRequest);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ApiOperation(value = "Delete a subject from the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = SubjectResponse.class)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SubjectResponse deleteSubject(@PathVariable Long id) {
        return subjectService.delete(id);
    }

    @ApiOperation(value = "Find a subject by ID in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = SubjectResponse.class)
    })
    @GetMapping("/find-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SubjectResponse findSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }
}
