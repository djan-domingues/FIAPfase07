package br.com.fiap.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.com.fiap.service.CategoriaService;
import br.com.fiap.service.CategoriaServiceImpl;
import br.com.fiap.service.EstabelecimentoService;
import br.com.fiap.service.EstabelecimentoServiceImpl;
import br.com.fiap.service.ProdutoService;
import br.com.fiap.service.ProdutoServiceImpl;

public class RMIServer {
	public static void main(String[] args) throws Exception {
		CategoriaService clienteService = new CategoriaServiceImpl();
		
		EstabelecimentoService estabelecimentoService = new EstabelecimentoServiceImpl();
		
		ProdutoService produtoService = new ProdutoServiceImpl();
		
		ProdutoService skeleton = (ProdutoService) UnicastRemoteObject.exportObject(produtoService, 0);
	
		Registry registro = LocateRegistry.createRegistry(8080);
		
		registro.bind("cliente", skeleton);
		
		System.out.println("obj pronto");
	}

}
