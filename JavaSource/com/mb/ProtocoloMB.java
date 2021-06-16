package com.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.facade.ProtocoloFacade;
import com.model.Protocolo;

@ViewScoped
@ManagedBean
public class ProtocoloMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	private Protocolo protocolo;
	private List<Protocolo> protocolos;
	private ProtocoloFacade protocoloFacade;

	public ProtocoloFacade getProtocoloFacade() {
		if (protocoloFacade == null) {
			protocoloFacade = new ProtocoloFacade();
		}

		return protocoloFacade;
	}

	public Protocolo getProtocolo() {
		if (protocolo == null) {
			protocolo = new Protocolo();
		}

		return protocolo;
	}

	public void setProtocolo(Protocolo protocolo) {
		this.protocolo = protocolo;
	}

	public void createProtocolo() {
		try {
			getProtocoloFacade().createProtocolo(protocolo);
			closeDialog();
			displayInfoMessageToUser("Protocolo criado com sucesso.");
			loadProtocolos();
			resetProtocolo();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("Erro ao tentar criar protocolo. Tente novamente.");
			e.printStackTrace();
		}
	}
	
	public void updateProtocolo() {
		try {
			getProtocoloFacade().updateProtocolo(protocolo);
			closeDialog();
			displayInfoMessageToUser("Protocolo atualizado com sucesso.");
			loadProtocolos();
			resetProtocolo();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("Erro ao tentar atualizar protocolo. Tente novamente.");
			e.printStackTrace();
		}
	}
	
	public void deleteProtocolo() {
		try {
			getProtocoloFacade().deleteProtocolo(protocolo);
			closeDialog();
			displayInfoMessageToUser("Protocolo excluído com sucesso.");
			loadProtocolos();
			resetProtocolo();
		} catch (Exception e) {
			keepDialogOpen();
			displayErrorMessageToUser("Erro ao excluir protocolo. Tente novamente.");
			e.printStackTrace();
		}
	}

	public List<Protocolo> getAllProtocolos() {
		if (protocolos == null) {
			loadProtocolos();
		}

		return protocolos;
	}

	private void loadProtocolos() {
		protocolos = getProtocoloFacade().listAll();
	}

	public void resetProtocolo() {
		protocolo = new Protocolo();
	}
}