package vn.codegym.bookmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.bookmanager.entity.Storage;
import vn.codegym.bookmanager.repository.StorageRepository;
import vn.codegym.bookmanager.service.StorageService;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageRepository storageRepository;


    @Override
    public List<Storage> findAddStorageBook() {
        return storageRepository.findAll();
    }
}
