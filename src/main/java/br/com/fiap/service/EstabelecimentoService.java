package br.com.fiap.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.com.fiap.entity.Estabelecimento;

public interface EstabelecimentoService extends Remote{

	Estabelecimento buscar(int id) throws RemoteException;
}
