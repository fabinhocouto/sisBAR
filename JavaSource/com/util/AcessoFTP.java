package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.primefaces.model.TreeNode;

import com.jcraft.jsch.*;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.model.Arvore;

public class AcessoFTP {
	
	private static String remoteHost = "10.122.32.22";
	private static String username = "root";
	private static String password = "pqpmsogra";
	private static int port = 22;
	private static String diretorio = "/var/www/html/images/banners/Capelania/2021/";
	
	private static ChannelSftp setupJsch() throws JSchException {
        JSch jsch = new JSch();
        Session jschSession = jsch.getSession(username, remoteHost, port);
        jschSession.setConfig("StrictHostKeyChecking", "no");
        jschSession.setPassword(password);
        jschSession.connect();
        return (ChannelSftp) jschSession.openChannel("sftp");
    }
	
	private static List<Arvore> montaArvore() throws JSchException, SftpException {
		List<Arvore> arvores = new ArrayList<Arvore>();
		ChannelSftp channelSftp = setupJsch();
	    channelSftp.connect();   
	    
	    channelSftp.cd(diretorio);
	    
	    Vector<LsEntry> arquivos = channelSftp.ls("*");
	    	
	    for (LsEntry lse : arquivos) {
	    	Arvore arvore = new Arvore();
	    	arvore.setNome(lse.getFilename());
	    	if(lse.getAttrs().isDir()) {
	    		
	    	}
	    	
		   	channelSftp.cd(diretorio + lse.getFilename());
		   	Vector<LsEntry> arquivos1 = channelSftp.ls("*");
		}
		
	    channelSftp.exit();
	    channelSftp.disconnect();
	    return arvores;
		
	}
	
	private static void downloadFile(String nomeArquivo, String diretorio) throws JSchException, SftpException {
	    ChannelSftp channelSftp = setupJsch();
	    channelSftp.connect();
	 
	    channelSftp.get(diretorio + nomeArquivo, "C:\\Users\\couto.fgc\\Desktop\\Diversos\\Pasta Viúva");
	 
	    channelSftp.exit();
	}    
    
}