package com.serviceimp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.FileDao;
import com.entities.File;
import com.service.FileService;

@Service
@Transactional
public class FileServiceImp implements FileService
{
	@Autowired
	private FileDao fileDAO;
	
	@Transactional
	public boolean addFile(File file)
	{
		return fileDAO.addFile(file);
	}
	
	@Transactional
	public List<File> getFile(String str)
	{
		return fileDAO.getFile(str);
	}
}
