package com.service;

import java.util.List;

import com.entities.File;

public interface FileService 
{
	public boolean addFile(File file);
	public List<File> getFile(String str);
}
