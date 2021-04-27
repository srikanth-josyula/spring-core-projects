package com.operations.dao;

import java.util.List;

import com.operations.entities.PersonEntity;

public interface PersonDAO {

	public void create(PersonEntity prs);
    public int delete(int prsId); 
    public List<PersonEntity> getAll();
    public int getCount();
    public int update(int prsId, String prsName);
    public PersonEntity get(int prsId);

}
