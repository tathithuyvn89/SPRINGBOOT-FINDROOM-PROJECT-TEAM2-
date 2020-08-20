package com.codegym.vn.services.hostServiceImpl;

import com.codegym.vn.models.Host;
import com.codegym.vn.repositories.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
  public class HostServiceImpl implements HostService {
    @Autowired
    private HostRepository hostRepository;

    @Override
    public Host findById(Long id) {
        return hostRepository.findById(id).orElse(null);
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Host remove(Long id) {
        Host host = this.findById(id);
        hostRepository.deleteById(id);
        return host;
    }

    @Override
    public Host save(Host model) {
        return hostRepository.save(model);
    }
}