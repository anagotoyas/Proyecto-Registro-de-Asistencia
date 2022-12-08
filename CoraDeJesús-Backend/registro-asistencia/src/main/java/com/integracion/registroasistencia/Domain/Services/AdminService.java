package com.integracion.registroasistencia.Domain.Services;

import com.integracion.registroasistencia.Domain.Entities.Admin;
import com.integracion.registroasistencia.Domain.Repositories.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    public Admin crearAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public Admin modificarAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public void eliminarAdmin(Integer idAdmin){
        adminRepository.deleteById(idAdmin);
    }

    public List<Admin> listarAdmins(){
        return adminRepository.findAll();
    }

    public Admin obtenerAdminPorId(Integer idAdmin){
        return adminRepository.findById(idAdmin).orElse(new Admin());

    }
}
