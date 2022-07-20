package com.nace.Service;

import com.nace.Model.NACEDto;

import java.io.FileNotFoundException;

public interface NACEService {
    public void saveNACEDetails() throws FileNotFoundException;
    public NACEDto fetchNACEDetailsById(Long order_id) throws Exception;
}
