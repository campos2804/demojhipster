package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.DemojhipsterApp;

import io.github.jhipster.application.domain.CargaSocvig;
import io.github.jhipster.application.repository.CargaSocvigRepository;
import io.github.jhipster.application.service.CargaSocvigService;
import io.github.jhipster.application.service.dto.CargaSocvigDTO;
import io.github.jhipster.application.service.mapper.CargaSocvigMapper;
import io.github.jhipster.application.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static io.github.jhipster.application.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the CargaSocvigResource REST controller.
 *
 * @see CargaSocvigResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemojhipsterApp.class)
public class CargaSocvigResourceIntTest {

    private static final Integer DEFAULT_RUT = 1;
    private static final Integer UPDATED_RUT = 2;

    private static final String DEFAULT_DV = "AAAAAAAAAA";
    private static final String UPDATED_DV = "BBBBBBBBBB";

    private static final Integer DEFAULT_NIVEL = 1;
    private static final Integer UPDATED_NIVEL = 2;

    @Autowired
    private CargaSocvigRepository cargaSocvigRepository;

    @Autowired
    private CargaSocvigMapper cargaSocvigMapper;

    @Autowired
    private CargaSocvigService cargaSocvigService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restCargaSocvigMockMvc;

    private CargaSocvig cargaSocvig;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CargaSocvigResource cargaSocvigResource = new CargaSocvigResource(cargaSocvigService);
        this.restCargaSocvigMockMvc = MockMvcBuilders.standaloneSetup(cargaSocvigResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CargaSocvig createEntity(EntityManager em) {
        CargaSocvig cargaSocvig = new CargaSocvig()
            .rut(DEFAULT_RUT)
            .dv(DEFAULT_DV)
            .nivel(DEFAULT_NIVEL);
        return cargaSocvig;
    }

    @Before
    public void initTest() {
        cargaSocvig = createEntity(em);
    }

    @Test
    @Transactional
    public void createCargaSocvig() throws Exception {
        int databaseSizeBeforeCreate = cargaSocvigRepository.findAll().size();

        // Create the CargaSocvig
        CargaSocvigDTO cargaSocvigDTO = cargaSocvigMapper.toDto(cargaSocvig);
        restCargaSocvigMockMvc.perform(post("/api/carga-socvigs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cargaSocvigDTO)))
            .andExpect(status().isCreated());

        // Validate the CargaSocvig in the database
        List<CargaSocvig> cargaSocvigList = cargaSocvigRepository.findAll();
        assertThat(cargaSocvigList).hasSize(databaseSizeBeforeCreate + 1);
        CargaSocvig testCargaSocvig = cargaSocvigList.get(cargaSocvigList.size() - 1);
        assertThat(testCargaSocvig.getRut()).isEqualTo(DEFAULT_RUT);
        assertThat(testCargaSocvig.getDv()).isEqualTo(DEFAULT_DV);
        assertThat(testCargaSocvig.getNivel()).isEqualTo(DEFAULT_NIVEL);
    }

    @Test
    @Transactional
    public void createCargaSocvigWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = cargaSocvigRepository.findAll().size();

        // Create the CargaSocvig with an existing ID
        cargaSocvig.setId(1L);
        CargaSocvigDTO cargaSocvigDTO = cargaSocvigMapper.toDto(cargaSocvig);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCargaSocvigMockMvc.perform(post("/api/carga-socvigs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cargaSocvigDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CargaSocvig in the database
        List<CargaSocvig> cargaSocvigList = cargaSocvigRepository.findAll();
        assertThat(cargaSocvigList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllCargaSocvigs() throws Exception {
        // Initialize the database
        cargaSocvigRepository.saveAndFlush(cargaSocvig);

        // Get all the cargaSocvigList
        restCargaSocvigMockMvc.perform(get("/api/carga-socvigs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cargaSocvig.getId().intValue())))
            .andExpect(jsonPath("$.[*].rut").value(hasItem(DEFAULT_RUT)))
            .andExpect(jsonPath("$.[*].dv").value(hasItem(DEFAULT_DV.toString())))
            .andExpect(jsonPath("$.[*].nivel").value(hasItem(DEFAULT_NIVEL)));
    }

    @Test
    @Transactional
    public void getCargaSocvig() throws Exception {
        // Initialize the database
        cargaSocvigRepository.saveAndFlush(cargaSocvig);

        // Get the cargaSocvig
        restCargaSocvigMockMvc.perform(get("/api/carga-socvigs/{id}", cargaSocvig.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(cargaSocvig.getId().intValue()))
            .andExpect(jsonPath("$.rut").value(DEFAULT_RUT))
            .andExpect(jsonPath("$.dv").value(DEFAULT_DV.toString()))
            .andExpect(jsonPath("$.nivel").value(DEFAULT_NIVEL));
    }

    @Test
    @Transactional
    public void getNonExistingCargaSocvig() throws Exception {
        // Get the cargaSocvig
        restCargaSocvigMockMvc.perform(get("/api/carga-socvigs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCargaSocvig() throws Exception {
        // Initialize the database
        cargaSocvigRepository.saveAndFlush(cargaSocvig);
        int databaseSizeBeforeUpdate = cargaSocvigRepository.findAll().size();

        // Update the cargaSocvig
        CargaSocvig updatedCargaSocvig = cargaSocvigRepository.findOne(cargaSocvig.getId());
        // Disconnect from session so that the updates on updatedCargaSocvig are not directly saved in db
        em.detach(updatedCargaSocvig);
        updatedCargaSocvig
            .rut(UPDATED_RUT)
            .dv(UPDATED_DV)
            .nivel(UPDATED_NIVEL);
        CargaSocvigDTO cargaSocvigDTO = cargaSocvigMapper.toDto(updatedCargaSocvig);

        restCargaSocvigMockMvc.perform(put("/api/carga-socvigs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cargaSocvigDTO)))
            .andExpect(status().isOk());

        // Validate the CargaSocvig in the database
        List<CargaSocvig> cargaSocvigList = cargaSocvigRepository.findAll();
        assertThat(cargaSocvigList).hasSize(databaseSizeBeforeUpdate);
        CargaSocvig testCargaSocvig = cargaSocvigList.get(cargaSocvigList.size() - 1);
        assertThat(testCargaSocvig.getRut()).isEqualTo(UPDATED_RUT);
        assertThat(testCargaSocvig.getDv()).isEqualTo(UPDATED_DV);
        assertThat(testCargaSocvig.getNivel()).isEqualTo(UPDATED_NIVEL);
    }

    @Test
    @Transactional
    public void updateNonExistingCargaSocvig() throws Exception {
        int databaseSizeBeforeUpdate = cargaSocvigRepository.findAll().size();

        // Create the CargaSocvig
        CargaSocvigDTO cargaSocvigDTO = cargaSocvigMapper.toDto(cargaSocvig);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restCargaSocvigMockMvc.perform(put("/api/carga-socvigs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cargaSocvigDTO)))
            .andExpect(status().isCreated());

        // Validate the CargaSocvig in the database
        List<CargaSocvig> cargaSocvigList = cargaSocvigRepository.findAll();
        assertThat(cargaSocvigList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteCargaSocvig() throws Exception {
        // Initialize the database
        cargaSocvigRepository.saveAndFlush(cargaSocvig);
        int databaseSizeBeforeDelete = cargaSocvigRepository.findAll().size();

        // Get the cargaSocvig
        restCargaSocvigMockMvc.perform(delete("/api/carga-socvigs/{id}", cargaSocvig.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<CargaSocvig> cargaSocvigList = cargaSocvigRepository.findAll();
        assertThat(cargaSocvigList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CargaSocvig.class);
        CargaSocvig cargaSocvig1 = new CargaSocvig();
        cargaSocvig1.setId(1L);
        CargaSocvig cargaSocvig2 = new CargaSocvig();
        cargaSocvig2.setId(cargaSocvig1.getId());
        assertThat(cargaSocvig1).isEqualTo(cargaSocvig2);
        cargaSocvig2.setId(2L);
        assertThat(cargaSocvig1).isNotEqualTo(cargaSocvig2);
        cargaSocvig1.setId(null);
        assertThat(cargaSocvig1).isNotEqualTo(cargaSocvig2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CargaSocvigDTO.class);
        CargaSocvigDTO cargaSocvigDTO1 = new CargaSocvigDTO();
        cargaSocvigDTO1.setId(1L);
        CargaSocvigDTO cargaSocvigDTO2 = new CargaSocvigDTO();
        assertThat(cargaSocvigDTO1).isNotEqualTo(cargaSocvigDTO2);
        cargaSocvigDTO2.setId(cargaSocvigDTO1.getId());
        assertThat(cargaSocvigDTO1).isEqualTo(cargaSocvigDTO2);
        cargaSocvigDTO2.setId(2L);
        assertThat(cargaSocvigDTO1).isNotEqualTo(cargaSocvigDTO2);
        cargaSocvigDTO1.setId(null);
        assertThat(cargaSocvigDTO1).isNotEqualTo(cargaSocvigDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(cargaSocvigMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(cargaSocvigMapper.fromId(null)).isNull();
    }
}
