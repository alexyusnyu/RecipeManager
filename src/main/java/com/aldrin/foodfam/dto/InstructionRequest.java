package com.aldrin.foodfam.dto;



import com.aldrin.foodfam.model.Instruction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InstructionRequest {
    private Instruction instruction;
}
