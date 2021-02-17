package br.com.banco.sangue.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.banco.sangue.models.Doador;
import br.com.banco.sangue.models.pojos.CandidatosEstadosProjecao;
import br.com.banco.sangue.models.pojos.DoadoresPorTipoProjecao;
import br.com.banco.sangue.models.pojos.MediaIdadeTipoSanguineoProjecao;
import br.com.banco.sangue.models.pojos.TotalObesosProjecao;

public interface DoadorRepository extends JpaRepository<Doador, Long> {
	
	@Query(value = "select estado,count(*) as qtd from doador group by estado order by estado",
			nativeQuery = true)
	List<CandidatosEstadosProjecao> candidatosPorEstado();
	
	
	@Query(value = "select round(icm,2) as imc from	doador where idade >= ?1 and idade <= ?2 and peso >= 50",
			nativeQuery = true)
	List<?>mediaIcm(Integer faixaInicial, Integer faixaFim);
	
	@Query(value = " select data.sexo,round((data.obesos/data.total*100),2) as percentual from (" + 
			"	select sexo, count(*) total ,(select count(*)" + 
			"	 from doador x" + 
			"	 where x.sexo = doador.sexo" + 
			"	 and imc > 30) as obesos" + 
			"	 from doador " + 
			"  group by sexo) data;", nativeQuery = true)
	List<TotalObesosProjecao>totalObesos();
	
	@Query(value = "select d.tipo_sanguineo as tipoSanguineo, round((sum(d.idade)/count(*))) as mediaIdade" + 
			" from doador d " + 
			" group by d.tipo_sanguineo;" + 
			"",nativeQuery = true)
	List<MediaIdadeTipoSanguineoProjecao>mediaIdadePorGrupo();
	
	
	@Query(value = "select 'A+' as tipo, count(*) as qtd  from doador d  where d.tipo_sanguineo in ('A+','A-','O+','O-') and doador = 1\r\n" + 
			"union\r\n" + 
			"select 'A-', count(*) as qtd  from doador d  where d.tipo_sanguineo in ('A-','O-') and doador = 1 \r\n" + 
			"union\r\n" + 
			"select 'A-', count(*) as qtd  from doador d   where d.tipo_sanguineo in ('A-','O-') and doador = 1\r\n" + 
			"union\r\n" + 
			"select 'B+', count(*) as qtd  from doador d  where d.tipo_sanguineo in ('B+','B-','O+','O-') and doador = 1\r\n" + 
			"union\r\n" + 
			"select 'B-', count(*) as qtd  from doador d  where d.tipo_sanguineo in ('B-','O-') and doador = 1\r\n" + 
			"union\r\n" + 
			"select 'AB+', count(*) as qtd from doador d  where d.tipo_sanguineo in ('A+','B+','O+','AB+','A-','B-','O-','AB-') and doador = 1\r\n" + 
			"union\r\n" + 
			"select 'AB-', count(*) as qtd  from doador d  where d.tipo_sanguineo in ('A-','B-','O-','AB') and doador = 1\r\n" + 
			"union\r\n" + 
			"select 'O+', count(*) as qtd from doador d  where d.tipo_sanguineo in ('O-','O+') and doador = 1\r\n" + 
			"union\r\n" + 
			"select 'O-', count(*) as qtd from doador d  where d.tipo_sanguineo in ('O-') and doador = 1", nativeQuery = true)
	List<DoadoresPorTipoProjecao>getTotalDadoresTipo();
	
	


}
