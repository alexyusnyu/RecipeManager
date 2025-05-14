package com.aldrin.foodfam.repository;

import com.aldrin.foodfam.model.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructionRepository extends JpaRepository<Instruction,Long> {
}
