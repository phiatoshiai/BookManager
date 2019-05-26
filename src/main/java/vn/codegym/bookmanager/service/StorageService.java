package vn.codegym.bookmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.bookmanager.entity.Storage;
import vn.codegym.bookmanager.repository.StorageRepository;

import java.util.List;

@Service
public interface StorageService {

    List<Storage> findAddStorageBook();




}
