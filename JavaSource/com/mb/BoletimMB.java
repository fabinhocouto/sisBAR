package com.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.TreeNode;

import com.util.AcessoFTP;

@ViewScoped
@ManagedBean
public class BoletimMB extends AbstractMB implements Serializable {
	private static final long serialVersionUID = 1L;

	private TreeNode root;
	
		
	  
	/*
	 * public TreeNode getRoot() throws Exception { //AcessoFTP.teste(); return
	 * AcessoFTP.montaArvore(); }
	 */

	
}