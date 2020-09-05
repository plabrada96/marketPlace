/**
 * 
 */
package com.test.marketplace.common.data.builder;

import java.io.Serializable;


public abstract class CommonBuilder implements Serializable {
	private static final long serialVersionUID = -5573988559789204386L;
	protected Integer page;
	protected Integer size;
	protected Boolean seleccionarRegistro;

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Boolean getSeleccionarRegistro() {
		return seleccionarRegistro;
	}

	public void setSeleccionarRegistro(Boolean seleccionarRegistro) {
		this.seleccionarRegistro = seleccionarRegistro;
	}
}
