package cybersoft.javabackend.java18.role.resource;

import cybersoft.javabackend.java18.role.model.Role;
import cybersoft.javabackend.java18.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
public class RoleResource {

    @Autowired
    RoleService roleService;

    @GetMapping
    public ResponseEntity<Object> getAllRole() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createRole(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.save(role), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> updateRole(@RequestBody Role role,
                                             @RequestParam("code") String code) {
        return new ResponseEntity<>(roleService.update(role, code),
                HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteRole(@RequestParam("code") String code) {
        roleService.delete(code);
    }

}
