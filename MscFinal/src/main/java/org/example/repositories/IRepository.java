package org.example.repositories;

import java.util.List;
// ESSA INTERFACE PE RESPONSAVEL POR CRIAR UM TERMO GENERICO <T> PARA OTIMIZAR A CONCTRUÇÃO DOS OUTROS REPOSITORYS
public interface IRepository <T> {

    public T findById(Long id) throws Exception;
    public List<T> findAll() throws Exception;
    public void save(T object) throws Exception;
    public void update(T object) throws Exception;
    public void delete(Long id) throws Exception;
}



