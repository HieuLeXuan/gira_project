package cybersoft.javabackend.java18.role.service;

import cybersoft.javabackend.java18.role.model.Role;
import cybersoft.javabackend.java18.role.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role save(Role role);

    Role update(Role role, String code);

    void delete(String code);
}

@Service
@Transactional
class RoleServiceImpl implements RoleService {

    /**
     * tai sao bat dung constructor thay vi autowried
     * mot lop chi nen lam mot viec
     */
    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role, String code) {
        Role currentRole = roleRepository.findByCode(code);
        currentRole.setName(role.getName());
        currentRole.setDescription(role.getDescription());
        return roleRepository.save(currentRole);
    }

    @Override
    public void delete(String code) {
        roleRepository.deleteByCode(code);
    }
}
