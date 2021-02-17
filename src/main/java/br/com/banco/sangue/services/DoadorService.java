package br.com.banco.sangue.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.banco.sangue.models.Doador;
import br.com.banco.sangue.models.pojos.ImcFaixaPojo;
import br.com.banco.sangue.repositories.DoadorRepository;

@Service
public class DoadorService {

	@Autowired
	DoadorRepository doadorRepository;

	public List<ImcFaixaPojo> gerarFaixaImc() {

		final Integer faixa = 10;
		final Integer idadeMaxima = 100;
		Integer idade = 1;

		List<Doador> doadores = doadorRepository.findAll();

		List<ImcFaixaPojo> listaImcFaixa = new ArrayList<>();
		while (idade < idadeMaxima) {
			Float total = 0F;
			Integer count = 0;
			final Integer peso = 50;
			for (Doador doador : doadores) {

				if (doador.getIdade() >= idade && doador.getIdade() <= (idade - 1 + faixa)
						&& doador.getPeso() >= peso) {

					total += doador.getImc();
					count += 1;

				}

			}
			if (total > 0F) {
				listaImcFaixa.add(new ImcFaixaPojo(idade, (idade - 1 + faixa), (total / count)));
			}
			idade += faixa;

		}

		return listaImcFaixa;
	}

	public void uploadFile(InputStream file) {

		List<Doador> lista = getDoadores(file);
		doadorRepository.deleteAll();
		doadorRepository.saveAll(lista);

	}

	static List<Doador> getDoadores(InputStream impStream) {

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			TypeReference<List<Doador>> typeReference = new TypeReference<List<Doador>>() {
			};
			return objectMapper.readValue(impStream, typeReference);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}
}
