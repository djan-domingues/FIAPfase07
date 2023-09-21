package br.com.fiap.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.com.fiap.entity.Produto;

public interface ProdutoService extends Remote{

	Produto buscar(int id) throws RemoteException;
	
}
