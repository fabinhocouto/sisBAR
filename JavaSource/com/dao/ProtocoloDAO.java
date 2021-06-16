package com.dao;

import com.model.Dog;
import com.model.Protocolo;

public class ProtocoloDAO extends GenericDAO<Protocolo> {

	private static final long serialVersionUID = 1L;

	public ProtocoloDAO() {
		super(Protocolo.class);
	}

	public void delete(Protocolo protocolo) {
		super.delete(protocolo.getId(), Protocolo.class);
	}

}