package com.hbt.semillero.pojo;

import java.util.List;

import com.hbt.semillero.dto.ComicDTO;

public class GestionarComicPOJO {

	private List<ComicDTO> listaComics = null;

	public void crearComicDTO() {
		ComicDTO comicDTO = new ComicDTO();
		comicDTO.setAutores(""); //TODO continuar llenando POJO...
		listaComics.add(comicDTO);
	}
	
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	} 
}
