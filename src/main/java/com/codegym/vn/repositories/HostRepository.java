package com.codegym.vn.repositories;

import com.codegym.vn.models.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
  public interface HostRepository  extends JpaRepository<Host, Long> { }