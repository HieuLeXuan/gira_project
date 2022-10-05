package cybersoft.javabackend.java18.role.resource;

import cybersoft.javabackend.java18.common.util.ResponseUtils;
import cybersoft.javabackend.java18.role.dto.RoleDTO;
import cybersoft.javabackend.java18.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/roles")
public class RoleResource {

    @Autowired
    RoleService roleService;

    @GetMapping
    public Object findAll() {
        return ResponseUtils.get(roleService.findAllDto(RoleDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public Object save(@RequestBody @Valid RoleDTO roleDTO) {
        return ResponseUtils.get(roleService.save(roleDTO), HttpStatus.CREATED);
    }
}
