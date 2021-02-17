package br.com.banco.sangue.models.pojos;

public class ImcFaixaPojo {

	private Integer faixaInicio;
	private Integer faixaFim;
	private Float mediaIcm;

	public ImcFaixaPojo() {

	}

	public ImcFaixaPojo(Integer faixaInicio, Integer faixaFim, Float mediaIcm) {
		super();
		this.faixaInicio = faixaInicio;
		this.faixaFim = faixaFim;
		this.mediaIcm = mediaIcm;
	}

	public Integer getFaixaInicio() {
		return faixaInicio;
	}

	public void setFaixaInicio(Integer faixaInicio) {
		this.faixaInicio = faixaInicio;
	}

	public Integer getFaixaFim() {
		return faixaFim;
	}

	public void setFaixaFim(Integer faixaFim) {
		this.faixaFim = faixaFim;
	}

	public Float getMediaIcm() {
		return mediaIcm;
	}

	public void setMediaIcm(Float mediaIcm) {
		this.mediaIcm = mediaIcm;
	}

}
