package com.facade;

import java.io.Serializable;
import java.util.List;

import com.dao.DogDAO;
import com.dao.ProtocoloDAO;
import com.model.Dog;
import com.model.Protocolo;

public class ProtocoloFacade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private ProtocoloDAO protocoloDAO = new ProtocoloDAO();

	public void createProtocolo(Protocolo protocolo) {
		protocoloDAO.beginTransaction();
		protocoloDAO.save(protocolo);
		protocoloDAO.commitAndCloseTransaction();
	}

	public void updateProtocolo(Protocolo protocolo) {
		protocoloDAO.beginTransaction();
		Protocolo persistedProtocolo = protocoloDAO.find(protocolo.getId());
		persistedProtocolo.setUser(protocolo.getUser());
		protocoloDAO.update(persistedProtocolo);
		protocoloDAO.commitAndCloseTransaction();
	}

	public Protocolo findProtocolo(int protocoloId) {
		protocoloDAO.beginTransaction();
		Protocolo protocolo = protocoloDAO.find(protocoloId);
		protocoloDAO.closeTransaction();
		return protocolo;
	}

	public List<Protocolo> listAll() {
		protocoloDAO.beginTransaction();
		List<Protocolo> result = protocoloDAO.findAll();
		protocoloDAO.closeTransaction();
		return result;
	}

	public void deleteProtocolo(Protocolo protocolo) {
		protocoloDAO.beginTransaction();
		Protocolo persistedProtocolo = protocoloDAO.findReferenceOnly(protocolo.getId());
		protocoloDAO.delete(persistedProtocolo);
		protocoloDAO.commitAndCloseTransaction();
	}
}