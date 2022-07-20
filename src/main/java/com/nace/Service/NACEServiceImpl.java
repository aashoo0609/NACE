package com.nace.Service;

import com.nace.Helper.NACEDetailsNotFound;
import com.nace.Model.NACEDto;
import com.nace.Repository.NACERepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;

@Service
public class NACEServiceImpl implements NACEService{
    @Autowired
    private NACERepository naceRepository;

    @Override
    public void saveNACEDetails() throws FileNotFoundException {
        String fileName = "C:\\Users\\hemra\\Downloads\\NACE_REV2_20220707_121503.csv";

        List<NACEDto> beans = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(NACEDto.class)
                .build()
                .parse();
        naceRepository.saveAll(beans);
    }

    @Override
    public NACEDto fetchNACEDetailsById(Long order_id) throws Exception {
        Optional<NACEDto> naceDto = naceRepository.findById(order_id);
        if(naceDto.isEmpty())
            throw new NACEDetailsNotFound("Cant find NACE Details with order_id: "+order_id);
        else
            return naceDto.get();
    }
}
