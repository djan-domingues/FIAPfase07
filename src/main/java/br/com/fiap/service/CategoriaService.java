package br.com.fiap.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.com.fiap.entity.Categoria;

public interface CategoriaService extends Remote{
	
	Categoria buscar(int id) throws RemoteException;

}
