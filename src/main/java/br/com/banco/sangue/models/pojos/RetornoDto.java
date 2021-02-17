package br.com.banco.sangue.models.pojos;

import java.util.List;

public class RetornoDto {
	public List<CandidatosEstadosProjecao> candidatosEstado;
	public List<ImcFaixaPojo> imcFaixa;
	public List<MediaIdadeTipoSanguineoProjecao> mediaIdade;
	public List<TotalObesosProjecao> totalObesos;
	List<DoadoresPorTipoProjecao> totalDoadoresTipo;

	public RetornoDto() {

	}

	public RetornoDto(List<CandidatosEstadosProjecao> candidatosEstado, List<ImcFaixaPojo> imcFaixa,
			List<MediaIdadeTipoSanguineoProjecao> mediaIdade, List<TotalObesosProjecao> totalObesos,
			List<DoadoresPorTipoProjecao> totalDoadoresTipo) {
		super();
		this.candidatosEstado = candidatosEstado;
		this.imcFaixa = imcFaixa;
		this.mediaIdade = mediaIdade;
		this.totalObesos = totalObesos;
		this.totalDoadoresTipo = totalDoadoresTipo;
	}

	public List<CandidatosEstadosProjecao> getCandidatosEstado() {
		return candidatosEstado;
	}

	public void setCandidatosEstado(List<CandidatosEstadosProjecao> candidatosEstado) {
		this.candidatosEstado = candidatosEstado;
	}

	public List<ImcFaixaPojo> getImcFaixa() {
		return imcFaixa;
	}

	public void setImcFaixa(List<ImcFaixaPojo> imcFaixa) {
		this.imcFaixa = imcFaixa;
	}

	public List<MediaIdadeTipoSanguineoProjecao> getMediaIdade() {
		return mediaIdade;
	}

	public void setMediaIdade(List<MediaIdadeTipoSanguineoProjecao> mediaIdade) {
		this.mediaIdade = mediaIdade;
	}

	public List<TotalObesosProjecao> getTotalObesos() {
		return totalObesos;
	}

	public void setTotalObesos(List<TotalObesosProjecao> totalObesos) {
		this.totalObesos = totalObesos;
	}

	public List<DoadoresPorTipoProjecao> getTotalDoadoresTipo() {
		return totalDoadoresTipo;
	}

	public void setTotalDoadoresTipo(List<DoadoresPorTipoProjecao> totalDoadoresTipo) {
		this.totalDoadoresTipo = totalDoadoresTipo;
	}

}
