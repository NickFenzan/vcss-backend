package com.millervein.vcss.ceap;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CEAPRepository extends JpaRepository<CEAP, Integer> {
	public CEAP findByPidAndDos(Integer pid, LocalDate dos);
}
