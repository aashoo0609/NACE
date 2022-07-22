package com.nace.service;

import com.nace.model.NACEDto;

import java.io.FileNotFoundException;

public interface NACEService {
    public void saveNACEDetails() throws FileNotFoundException;
    public NACEDto fetchNACEDetailsById(Long order_id) throws Exception;
}
