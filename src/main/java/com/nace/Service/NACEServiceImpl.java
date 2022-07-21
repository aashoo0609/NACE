package com.nace.Service;

import com.nace.Helper.NACEDetailsNotFound;
import com.nace.Model.NACEDto;
import com.nace.Repository.NACERepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NACEServiceImpl implements NACEService{
    @Autowired
    private NACERepository naceRepository;
    @Value("${csv.fileName}")
    String fileName;
    @Override
    public void saveNACEDetails() throws FileNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        List beans = new CsvToBeanBuilder(new FileReader(file))
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
