package com.nace.controller;

import com.nace.model.NACEDto;
import com.nace.service.NACEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api")
public class NACEController {


    @Autowired
    private NACEService naceService;

    @PostMapping("/NACEDetails")
    public ResponseEntity createNACEDetails() throws FileNotFoundException {
        naceService.saveNACEDetails();
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/NACEDetails/{order}")
    public ResponseEntity<NACEDto> getNACEDetails(@PathVariable Long order) throws Exception {
        NACEDto nacedto = naceService.fetchNACEDetailsById(order);
        if (nacedto == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(nacedto);

    }
}
