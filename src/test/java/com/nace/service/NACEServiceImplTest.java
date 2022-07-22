package com.nace.service;

import com.nace.helper.NACEDetailsNotFound;
import com.nace.model.NACEDto;
import com.nace.repository.NACERepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class NACEServiceImplTest {

    @InjectMocks
    private NACEServiceImpl naceService;

    @Mock
    private NACERepository repository;

    @Before
    public void setUp() {
        ReflectionTestUtils.setField(naceService, "fileName", "NACE_REV2_20220720_143839.csv");
    }
    @Test
    public void test_saveNaceDetails() throws FileNotFoundException {
        naceService.saveNACEDetails();
        verify(repository,times(1)).saveAll(any(List.class));
    }

    @Test
    public void test_fetchNaceDetailsById() throws Exception {
        when(repository.findById(12345l)).thenReturn(getNaceDto());
        NACEDto actual = naceService.fetchNACEDetailsById(12345l);

        assertEquals(12345l,actual.getOrder_id());
        assertEquals("test123",actual.getCode());

    }
    @Test(expected = NACEDetailsNotFound.class)
    public void test_throwsExceptionIfIdNotPresent() throws Exception {
        when(repository.findById(123l)).thenReturn(Optional.empty());
        NACEDto actual = naceService.fetchNACEDetailsById(123l);
    }
    public Optional<NACEDto> getNaceDto(){
        NACEDto naceDto = new NACEDto();
        naceDto.setOrder_id(12345l);
        naceDto.setCode("test123");
        naceDto.setLevel_id(222);
        naceDto.setItemIncludes("testItems");
        return Optional.of(naceDto);
    }
}