package com.lino.teste.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExameDTO {
	
	private String descricao;
	private String dataExame;
	private Integer idPaciente;

}
