package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.DemojhipsterApp;

import io.github.jhipster.application.domain.SocioDatPer;
import io.github.jhipster.application.repository.SocioDatPerRepository;
import io.github.jhipster.application.service.SocioDatPerService;
import io.github.jhipster.application.service.dto.SocioDatPerDTO;
import io.github.jhipster.application.service.mapper.SocioDatPerMapper;
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
 * Test class for the SocioDatPerResource REST controller.
 *
 * @see SocioDatPerResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemojhipsterApp.class)
public class SocioDatPerResourceIntTest {

    private static final Integer DEFAULT_IDEN = 1;
    private static final Integer UPDATED_IDEN = 2;

    private static final String DEFAULT_PROFESION = "AAAAAAAAAA";
    private static final String UPDATED_PROFESION = "BBBBBBBBBB";

    private static final String DEFAULT_DIRECCION = "AAAAAAAAAA";
    private static final String UPDATED_DIRECCION = "BBBBBBBBBB";

    private static final String DEFAULT_COMUNA = "AAAAAAAAAA";
    private static final String UPDATED_COMUNA = "BBBBBBBBBB";

    private static final String DEFAULT_CIUDAD = "AAAAAAAAAA";
    private static final String UPDATED_CIUDAD = "BBBBBBBBBB";

    private static final Integer DEFAULT_REGION = 1;
    private static final Integer UPDATED_REGION = 2;

    @Autowired
    private SocioDatPerRepository socioDatPerRepository;

    @Autowired
    private SocioDatPerMapper socioDatPerMapper;

    @Autowired
    private SocioDatPerService socioDatPerService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restSocioDatPerMockMvc;

    private SocioDatPer socioDatPer;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SocioDatPerResource socioDatPerResource = new SocioDatPerResource(socioDatPerService);
        this.restSocioDatPerMockMvc = MockMvcBuilders.standaloneSetup(socioDatPerResource)
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
    public static SocioDatPer createEntity(EntityManager em) {
        SocioDatPer socioDatPer = new SocioDatPer()
            .iden(DEFAULT_IDEN)
            .profesion(DEFAULT_PROFESION)
            .direccion(DEFAULT_DIRECCION)
            .comuna(DEFAULT_COMUNA)
            .ciudad(DEFAULT_CIUDAD)
            .region(DEFAULT_REGION);
        return socioDatPer;
    }

    @Before
    public void initTest() {
        socioDatPer = createEntity(em);
    }

    @Test
    @Transactional
    public void createSocioDatPer() throws Exception {
        int databaseSizeBeforeCreate = socioDatPerRepository.findAll().size();

        // Create the SocioDatPer
        SocioDatPerDTO socioDatPerDTO = socioDatPerMapper.toDto(socioDatPer);
        restSocioDatPerMockMvc.perform(post("/api/socio-dat-pers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(socioDatPerDTO)))
            .andExpect(status().isCreated());

        // Validate the SocioDatPer in the database
        List<SocioDatPer> socioDatPerList = socioDatPerRepository.findAll();
        assertThat(socioDatPerList).hasSize(databaseSizeBeforeCreate + 1);
        SocioDatPer testSocioDatPer = socioDatPerList.get(socioDatPerList.size() - 1);
        assertThat(testSocioDatPer.getIden()).isEqualTo(DEFAULT_IDEN);
        assertThat(testSocioDatPer.getProfesion()).isEqualTo(DEFAULT_PROFESION);
        assertThat(testSocioDatPer.getDireccion()).isEqualTo(DEFAULT_DIRECCION);
        assertThat(testSocioDatPer.getComuna()).isEqualTo(DEFAULT_COMUNA);
        assertThat(testSocioDatPer.getCiudad()).isEqualTo(DEFAULT_CIUDAD);
        assertThat(testSocioDatPer.getRegion()).isEqualTo(DEFAULT_REGION);
    }

    @Test
    @Transactional
    public void createSocioDatPerWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = socioDatPerRepository.findAll().size();

        // Create the SocioDatPer with an existing ID
        socioDatPer.setId(1L);
        SocioDatPerDTO socioDatPerDTO = socioDatPerMapper.toDto(socioDatPer);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSocioDatPerMockMvc.perform(post("/api/socio-dat-pers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(socioDatPerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the SocioDatPer in the database
        List<SocioDatPer> socioDatPerList = socioDatPerRepository.findAll();
        assertThat(socioDatPerList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllSocioDatPers() throws Exception {
        // Initialize the database
        socioDatPerRepository.saveAndFlush(socioDatPer);

        // Get all the socioDatPerList
        restSocioDatPerMockMvc.perform(get("/api/socio-dat-pers?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(socioDatPer.getId().intValue())))
            .andExpect(jsonPath("$.[*].iden").value(hasItem(DEFAULT_IDEN)))
            .andExpect(jsonPath("$.[*].profesion").value(hasItem(DEFAULT_PROFESION.toString())))
            .andExpect(jsonPath("$.[*].direccion").value(hasItem(DEFAULT_DIRECCION.toString())))
            .andExpect(jsonPath("$.[*].comuna").value(hasItem(DEFAULT_COMUNA.toString())))
            .andExpect(jsonPath("$.[*].ciudad").value(hasItem(DEFAULT_CIUDAD.toString())))
            .andExpect(jsonPath("$.[*].region").value(hasItem(DEFAULT_REGION)));
    }

    @Test
    @Transactional
    public void getSocioDatPer() throws Exception {
        // Initialize the database
        socioDatPerRepository.saveAndFlush(socioDatPer);

        // Get the socioDatPer
        restSocioDatPerMockMvc.perform(get("/api/socio-dat-pers/{id}", socioDatPer.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(socioDatPer.getId().intValue()))
            .andExpect(jsonPath("$.iden").value(DEFAULT_IDEN))
            .andExpect(jsonPath("$.profesion").value(DEFAULT_PROFESION.toString()))
            .andExpect(jsonPath("$.direccion").value(DEFAULT_DIRECCION.toString()))
            .andExpect(jsonPath("$.comuna").value(DEFAULT_COMUNA.toString()))
            .andExpect(jsonPath("$.ciudad").value(DEFAULT_CIUDAD.toString()))
            .andExpect(jsonPath("$.region").value(DEFAULT_REGION));
    }

    @Test
    @Transactional
    public void getNonExistingSocioDatPer() throws Exception {
        // Get the socioDatPer
        restSocioDatPerMockMvc.perform(get("/api/socio-dat-pers/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSocioDatPer() throws Exception {
        // Initialize the database
        socioDatPerRepository.saveAndFlush(socioDatPer);
        int databaseSizeBeforeUpdate = socioDatPerRepository.findAll().size();

        // Update the socioDatPer
        SocioDatPer updatedSocioDatPer = socioDatPerRepository.findOne(socioDatPer.getId());
        // Disconnect from session so that the updates on updatedSocioDatPer are not directly saved in db
        em.detach(updatedSocioDatPer);
        updatedSocioDatPer
            .iden(UPDATED_IDEN)
            .profesion(UPDATED_PROFESION)
            .direccion(UPDATED_DIRECCION)
            .comuna(UPDATED_COMUNA)
            .ciudad(UPDATED_CIUDAD)
            .region(UPDATED_REGION);
        SocioDatPerDTO socioDatPerDTO = socioDatPerMapper.toDto(updatedSocioDatPer);

        restSocioDatPerMockMvc.perform(put("/api/socio-dat-pers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(socioDatPerDTO)))
            .andExpect(status().isOk());

        // Validate the SocioDatPer in the database
        List<SocioDatPer> socioDatPerList = socioDatPerRepository.findAll();
        assertThat(socioDatPerList).hasSize(databaseSizeBeforeUpdate);
        SocioDatPer testSocioDatPer = socioDatPerList.get(socioDatPerList.size() - 1);
        assertThat(testSocioDatPer.getIden()).isEqualTo(UPDATED_IDEN);
        assertThat(testSocioDatPer.getProfesion()).isEqualTo(UPDATED_PROFESION);
        assertThat(testSocioDatPer.getDireccion()).isEqualTo(UPDATED_DIRECCION);
        assertThat(testSocioDatPer.getComuna()).isEqualTo(UPDATED_COMUNA);
        assertThat(testSocioDatPer.getCiudad()).isEqualTo(UPDATED_CIUDAD);
        assertThat(testSocioDatPer.getRegion()).isEqualTo(UPDATED_REGION);
    }

    @Test
    @Transactional
    public void updateNonExistingSocioDatPer() throws Exception {
        int databaseSizeBeforeUpdate = socioDatPerRepository.findAll().size();

        // Create the SocioDatPer
        SocioDatPerDTO socioDatPerDTO = socioDatPerMapper.toDto(socioDatPer);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restSocioDatPerMockMvc.perform(put("/api/socio-dat-pers")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(socioDatPerDTO)))
            .andExpect(status().isCreated());

        // Validate the SocioDatPer in the database
        List<SocioDatPer> socioDatPerList = socioDatPerRepository.findAll();
        assertThat(socioDatPerList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteSocioDatPer() throws Exception {
        // Initialize the database
        socioDatPerRepository.saveAndFlush(socioDatPer);
        int databaseSizeBeforeDelete = socioDatPerRepository.findAll().size();

        // Get the socioDatPer
        restSocioDatPerMockMvc.perform(delete("/api/socio-dat-pers/{id}", socioDatPer.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<SocioDatPer> socioDatPerList = socioDatPerRepository.findAll();
        assertThat(socioDatPerList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SocioDatPer.class);
        SocioDatPer socioDatPer1 = new SocioDatPer();
        socioDatPer1.setId(1L);
        SocioDatPer socioDatPer2 = new SocioDatPer();
        socioDatPer2.setId(socioDatPer1.getId());
        assertThat(socioDatPer1).isEqualTo(socioDatPer2);
        socioDatPer2.setId(2L);
        assertThat(socioDatPer1).isNotEqualTo(socioDatPer2);
        socioDatPer1.setId(null);
        assertThat(socioDatPer1).isNotEqualTo(socioDatPer2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SocioDatPerDTO.class);
        SocioDatPerDTO socioDatPerDTO1 = new SocioDatPerDTO();
        socioDatPerDTO1.setId(1L);
        SocioDatPerDTO socioDatPerDTO2 = new SocioDatPerDTO();
        assertThat(socioDatPerDTO1).isNotEqualTo(socioDatPerDTO2);
        socioDatPerDTO2.setId(socioDatPerDTO1.getId());
        assertThat(socioDatPerDTO1).isEqualTo(socioDatPerDTO2);
        socioDatPerDTO2.setId(2L);
        assertThat(socioDatPerDTO1).isNotEqualTo(socioDatPerDTO2);
        socioDatPerDTO1.setId(null);
        assertThat(socioDatPerDTO1).isNotEqualTo(socioDatPerDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(socioDatPerMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(socioDatPerMapper.fromId(null)).isNull();
    }
}
