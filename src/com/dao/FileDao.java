package com.dao;

import java.util.List;

import com.entities.File;

public interface FileDao 
{
	public boolean addFile(File file);
	public List<File> getFile(String str);
}
