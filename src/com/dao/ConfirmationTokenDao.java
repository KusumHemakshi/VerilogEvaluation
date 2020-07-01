package com.dao;

import java.util.List;

import com.entities.ConfirmationToken;
public interface ConfirmationTokenDao 
{
	public boolean addConfirmationToken(ConfirmationToken configT);
	public List<ConfirmationToken> getConfirmation(String username);
	public List<ConfirmationToken> findToken(String token);
	public boolean setEnable(String token);
}
