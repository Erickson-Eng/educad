package br.edu.ifpb.educad.controller;

import br.edu.ifpb.educad.dto.request.InstitutionRequest;
import br.edu.ifpb.educad.dto.response.CourseResponse;
import br.edu.ifpb.educad.dto.response.InstitutionResponse;
import br.edu.ifpb.educad.dto.response.table.InstitutionResponseTable;
import br.edu.ifpb.educad.service.InstitutionService;
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
@RequestMapping("api/v1/institution")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class InstitutionController {
    private InstitutionService institutionService;

    @ApiOperation(value = "Create a new institution in the database")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created", response = InstitutionResponse.class)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InstitutionResponse createInstitution(@RequestBody @Valid InstitutionRequest institutionRequest) {
        return institutionService.save(institutionRequest);
    }

    @ApiOperation(value = "Update an institution in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = InstitutionResponse.class)
    })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InstitutionResponse updateInstitution(@PathVariable Long id,
                                         @RequestBody @Valid InstitutionRequest institutionRequest) {
        return institutionService.update(id, institutionRequest);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @ApiOperation(value = "Delete an institution from the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = InstitutionResponse.class)
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InstitutionResponse deleteInstitution(@PathVariable Long id) {
        return institutionService.delete(id);
    }

    @ApiOperation(value = "Find an institution by ID in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = InstitutionResponse.class)
    })
    @GetMapping("/find-by-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InstitutionResponse findInstitutionById(@PathVariable Long id) {
        return institutionService.getInstitutionById(id);
    }

    @ApiOperation(value = "Find institutions by name in the database")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = InstitutionResponse.class)
    })
    @GetMapping("/find-by-name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public InstitutionResponseTable findInstitutionByName(@PathVariable String name) {
        InstitutionResponseTable institutionResponseTable = new InstitutionResponseTable();

        institutionResponseTable.setInstitutionResponseList(institutionService.getInstitutionByName(name));

        return institutionResponseTable;
    }

    @ApiOperation(value = "Get all courses from an institution")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = InstitutionResponse.class)
    })
    @GetMapping("/{id}/courses")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseResponse> getCoursesByInstitution(@PathVariable Long id) {
        return institutionService.getCoursesByInstitution(id);
    }
}
