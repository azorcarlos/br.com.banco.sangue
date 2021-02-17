package br.com.banco.sangue.controllers;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.banco.sangue.models.pojos.RetornoDto;
import br.com.banco.sangue.repositories.DoadorRepository;
import br.com.banco.sangue.services.DoadorService;

@RestController
@RequestMapping(path = "api/v1/")
public class DoadorController {

	@Autowired
	private DoadorRepository doadorRepository;

	@Autowired
	private DoadorService doadorService;

	@PostMapping(path = "upload")
	@CrossOrigin
	@Transactional
	public ResponseEntity<RetornoDto> upload( @RequestParam("file") MultipartFile file) {


		try {
			doadorService.uploadFile(file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(
				new RetornoDto(doadorRepository.candidatosPorEstado(),
				doadorService.gerarFaixaImc(),
				doadorRepository.mediaIdadePorGrupo(),
				doadorRepository.totalObesos(),
				doadorRepository.getTotalDadoresTipo()), HttpStatus.CREATED);
		
	}

}
