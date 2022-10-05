package cybersoft.javabackend.java18.role.service;

import cybersoft.javabackend.java18.common.service.GenericService;
import cybersoft.javabackend.java18.common.util.GiraMapper;
import cybersoft.javabackend.java18.role.dto.RoleDTO;
import cybersoft.javabackend.java18.role.model.Role;
import cybersoft.javabackend.java18.role.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

public interface RoleService extends GenericService<Role, RoleDTO, UUID> {
    Role update(Role role, String code);

    void deleteByCode(String code);

    RoleDTO save(RoleDTO dto);
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

    @Autowired
    GiraMapper giraMapper;

    @Override
    public Role update(Role role, String code) {
        Role currentRole = roleRepository.findByCode(code);
        currentRole.setName(role.getName());
        currentRole.setDescription(role.getDescription());
        return roleRepository.save(currentRole);
    }

    @Override
    public void deleteByCode(String code) {
        roleRepository.deleteByCode(code);
    }

    @Override
    public RoleDTO save(RoleDTO dto) {
        Role model = giraMapper.map(dto, Role.class);
        Role saveModel = roleRepository.save(model);
        return giraMapper.map(saveModel, RoleDTO.class);
    }

    @Override
    public JpaRepository<Role, UUID> getRepository() {
        return this.roleRepository;
    }

    @Override
    public ModelMapper getMapper() {
        return this.giraMapper;
    }
}
