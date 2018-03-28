package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.DemojhipsterApp;

import io.github.jhipster.application.domain.ControlCambioRazon;
import io.github.jhipster.application.repository.ControlCambioRazonRepository;
import io.github.jhipster.application.service.dto.ControlCambioRazonDTO;
import io.github.jhipster.application.service.mapper.ControlCambioRazonMapper;
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
 * Test class for the ControlCambioRazonResource REST controller.
 *
 * @see ControlCambioRazonResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemojhipsterApp.class)
public class ControlCambioRazonResourceIntTest {

    private static final String DEFAULT_CAMBIO_EXTRACTO = "AAAAAAAAAA";
    private static final String UPDATED_CAMBIO_EXTRACTO = "BBBBBBBBBB";

    private static final Integer DEFAULT_CAMBIO_RUT = 1;
    private static final Integer UPDATED_CAMBIO_RUT = 2;

    private static final String DEFAULT_CAMBIO_DV = "AAAAAAAAAA";
    private static final String UPDATED_CAMBIO_DV = "BBBBBBBBBB";

    private static final String DEFAULT_CAMBIO_EMP = "AAAAAAAAAA";
    private static final String UPDATED_CAMBIO_EMP = "BBBBBBBBBB";

    private static final String DEFAULT_CAMBIO_FANTA = "AAAAAAAAAA";
    private static final String UPDATED_CAMBIO_FANTA = "BBBBBBBBBB";

    private static final String DEFAULT_CAMBIOA_EMP = "AAAAAAAAAA";
    private static final String UPDATED_CAMBIOA_EMP = "BBBBBBBBBB";

    private static final String DEFAULT_CAMBIOA_FANTA = "AAAAAAAAAA";
    private static final String UPDATED_CAMBIOA_FANTA = "BBBBBBBBBB";

    @Autowired
    private ControlCambioRazonRepository controlCambioRazonRepository;

    @Autowired
    private ControlCambioRazonMapper controlCambioRazonMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restControlCambioRazonMockMvc;

    private ControlCambioRazon controlCambioRazon;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ControlCambioRazonResource controlCambioRazonResource = new ControlCambioRazonResource(controlCambioRazonRepository, controlCambioRazonMapper);
        this.restControlCambioRazonMockMvc = MockMvcBuilders.standaloneSetup(controlCambioRazonResource)
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
    public static ControlCambioRazon createEntity(EntityManager em) {
        ControlCambioRazon controlCambioRazon = new ControlCambioRazon()
            .cambioExtracto(DEFAULT_CAMBIO_EXTRACTO)
            .cambioRut(DEFAULT_CAMBIO_RUT)
            .cambioDv(DEFAULT_CAMBIO_DV)
            .cambioEmp(DEFAULT_CAMBIO_EMP)
            .cambioFanta(DEFAULT_CAMBIO_FANTA)
            .cambioaEmp(DEFAULT_CAMBIOA_EMP)
            .cambioaFanta(DEFAULT_CAMBIOA_FANTA);
        return controlCambioRazon;
    }

    @Before
    public void initTest() {
        controlCambioRazon = createEntity(em);
    }

    @Test
    @Transactional
    public void createControlCambioRazon() throws Exception {
        int databaseSizeBeforeCreate = controlCambioRazonRepository.findAll().size();

        // Create the ControlCambioRazon
        ControlCambioRazonDTO controlCambioRazonDTO = controlCambioRazonMapper.toDto(controlCambioRazon);
        restControlCambioRazonMockMvc.perform(post("/api/control-cambio-razons")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(controlCambioRazonDTO)))
            .andExpect(status().isCreated());

        // Validate the ControlCambioRazon in the database
        List<ControlCambioRazon> controlCambioRazonList = controlCambioRazonRepository.findAll();
        assertThat(controlCambioRazonList).hasSize(databaseSizeBeforeCreate + 1);
        ControlCambioRazon testControlCambioRazon = controlCambioRazonList.get(controlCambioRazonList.size() - 1);
        assertThat(testControlCambioRazon.getCambioExtracto()).isEqualTo(DEFAULT_CAMBIO_EXTRACTO);
        assertThat(testControlCambioRazon.getCambioRut()).isEqualTo(DEFAULT_CAMBIO_RUT);
        assertThat(testControlCambioRazon.getCambioDv()).isEqualTo(DEFAULT_CAMBIO_DV);
        assertThat(testControlCambioRazon.getCambioEmp()).isEqualTo(DEFAULT_CAMBIO_EMP);
        assertThat(testControlCambioRazon.getCambioFanta()).isEqualTo(DEFAULT_CAMBIO_FANTA);
        assertThat(testControlCambioRazon.getCambioaEmp()).isEqualTo(DEFAULT_CAMBIOA_EMP);
        assertThat(testControlCambioRazon.getCambioaFanta()).isEqualTo(DEFAULT_CAMBIOA_FANTA);
    }

    @Test
    @Transactional
    public void createControlCambioRazonWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = controlCambioRazonRepository.findAll().size();

        // Create the ControlCambioRazon with an existing ID
        controlCambioRazon.setId(1L);
        ControlCambioRazonDTO controlCambioRazonDTO = controlCambioRazonMapper.toDto(controlCambioRazon);

        // An entity with an existing ID cannot be created, so this API call must fail
        restControlCambioRazonMockMvc.perform(post("/api/control-cambio-razons")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(controlCambioRazonDTO)))
            .andExpect(status().isBadRequest());

        // Validate the ControlCambioRazon in the database
        List<ControlCambioRazon> controlCambioRazonList = controlCambioRazonRepository.findAll();
        assertThat(controlCambioRazonList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllControlCambioRazons() throws Exception {
        // Initialize the database
        controlCambioRazonRepository.saveAndFlush(controlCambioRazon);

        // Get all the controlCambioRazonList
        restControlCambioRazonMockMvc.perform(get("/api/control-cambio-razons?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(controlCambioRazon.getId().intValue())))
            .andExpect(jsonPath("$.[*].cambioExtracto").value(hasItem(DEFAULT_CAMBIO_EXTRACTO.toString())))
            .andExpect(jsonPath("$.[*].cambioRut").value(hasItem(DEFAULT_CAMBIO_RUT)))
            .andExpect(jsonPath("$.[*].cambioDv").value(hasItem(DEFAULT_CAMBIO_DV.toString())))
            .andExpect(jsonPath("$.[*].cambioEmp").value(hasItem(DEFAULT_CAMBIO_EMP.toString())))
            .andExpect(jsonPath("$.[*].cambioFanta").value(hasItem(DEFAULT_CAMBIO_FANTA.toString())))
            .andExpect(jsonPath("$.[*].cambioaEmp").value(hasItem(DEFAULT_CAMBIOA_EMP.toString())))
            .andExpect(jsonPath("$.[*].cambioaFanta").value(hasItem(DEFAULT_CAMBIOA_FANTA.toString())));
    }

    @Test
    @Transactional
    public void getControlCambioRazon() throws Exception {
        // Initialize the database
        controlCambioRazonRepository.saveAndFlush(controlCambioRazon);

        // Get the controlCambioRazon
        restControlCambioRazonMockMvc.perform(get("/api/control-cambio-razons/{id}", controlCambioRazon.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(controlCambioRazon.getId().intValue()))
            .andExpect(jsonPath("$.cambioExtracto").value(DEFAULT_CAMBIO_EXTRACTO.toString()))
            .andExpect(jsonPath("$.cambioRut").value(DEFAULT_CAMBIO_RUT))
            .andExpect(jsonPath("$.cambioDv").value(DEFAULT_CAMBIO_DV.toString()))
            .andExpect(jsonPath("$.cambioEmp").value(DEFAULT_CAMBIO_EMP.toString()))
            .andExpect(jsonPath("$.cambioFanta").value(DEFAULT_CAMBIO_FANTA.toString()))
            .andExpect(jsonPath("$.cambioaEmp").value(DEFAULT_CAMBIOA_EMP.toString()))
            .andExpect(jsonPath("$.cambioaFanta").value(DEFAULT_CAMBIOA_FANTA.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingControlCambioRazon() throws Exception {
        // Get the controlCambioRazon
        restControlCambioRazonMockMvc.perform(get("/api/control-cambio-razons/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateControlCambioRazon() throws Exception {
        // Initialize the database
        controlCambioRazonRepository.saveAndFlush(controlCambioRazon);
        int databaseSizeBeforeUpdate = controlCambioRazonRepository.findAll().size();

        // Update the controlCambioRazon
        ControlCambioRazon updatedControlCambioRazon = controlCambioRazonRepository.findOne(controlCambioRazon.getId());
        // Disconnect from session so that the updates on updatedControlCambioRazon are not directly saved in db
        em.detach(updatedControlCambioRazon);
        updatedControlCambioRazon
            .cambioExtracto(UPDATED_CAMBIO_EXTRACTO)
            .cambioRut(UPDATED_CAMBIO_RUT)
            .cambioDv(UPDATED_CAMBIO_DV)
            .cambioEmp(UPDATED_CAMBIO_EMP)
            .cambioFanta(UPDATED_CAMBIO_FANTA)
            .cambioaEmp(UPDATED_CAMBIOA_EMP)
            .cambioaFanta(UPDATED_CAMBIOA_FANTA);
        ControlCambioRazonDTO controlCambioRazonDTO = controlCambioRazonMapper.toDto(updatedControlCambioRazon);

        restControlCambioRazonMockMvc.perform(put("/api/control-cambio-razons")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(controlCambioRazonDTO)))
            .andExpect(status().isOk());

        // Validate the ControlCambioRazon in the database
        List<ControlCambioRazon> controlCambioRazonList = controlCambioRazonRepository.findAll();
        assertThat(controlCambioRazonList).hasSize(databaseSizeBeforeUpdate);
        ControlCambioRazon testControlCambioRazon = controlCambioRazonList.get(controlCambioRazonList.size() - 1);
        assertThat(testControlCambioRazon.getCambioExtracto()).isEqualTo(UPDATED_CAMBIO_EXTRACTO);
        assertThat(testControlCambioRazon.getCambioRut()).isEqualTo(UPDATED_CAMBIO_RUT);
        assertThat(testControlCambioRazon.getCambioDv()).isEqualTo(UPDATED_CAMBIO_DV);
        assertThat(testControlCambioRazon.getCambioEmp()).isEqualTo(UPDATED_CAMBIO_EMP);
        assertThat(testControlCambioRazon.getCambioFanta()).isEqualTo(UPDATED_CAMBIO_FANTA);
        assertThat(testControlCambioRazon.getCambioaEmp()).isEqualTo(UPDATED_CAMBIOA_EMP);
        assertThat(testControlCambioRazon.getCambioaFanta()).isEqualTo(UPDATED_CAMBIOA_FANTA);
    }

    @Test
    @Transactional
    public void updateNonExistingControlCambioRazon() throws Exception {
        int databaseSizeBeforeUpdate = controlCambioRazonRepository.findAll().size();

        // Create the ControlCambioRazon
        ControlCambioRazonDTO controlCambioRazonDTO = controlCambioRazonMapper.toDto(controlCambioRazon);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restControlCambioRazonMockMvc.perform(put("/api/control-cambio-razons")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(controlCambioRazonDTO)))
            .andExpect(status().isCreated());

        // Validate the ControlCambioRazon in the database
        List<ControlCambioRazon> controlCambioRazonList = controlCambioRazonRepository.findAll();
        assertThat(controlCambioRazonList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteControlCambioRazon() throws Exception {
        // Initialize the database
        controlCambioRazonRepository.saveAndFlush(controlCambioRazon);
        int databaseSizeBeforeDelete = controlCambioRazonRepository.findAll().size();

        // Get the controlCambioRazon
        restControlCambioRazonMockMvc.perform(delete("/api/control-cambio-razons/{id}", controlCambioRazon.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<ControlCambioRazon> controlCambioRazonList = controlCambioRazonRepository.findAll();
        assertThat(controlCambioRazonList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ControlCambioRazon.class);
        ControlCambioRazon controlCambioRazon1 = new ControlCambioRazon();
        controlCambioRazon1.setId(1L);
        ControlCambioRazon controlCambioRazon2 = new ControlCambioRazon();
        controlCambioRazon2.setId(controlCambioRazon1.getId());
        assertThat(controlCambioRazon1).isEqualTo(controlCambioRazon2);
        controlCambioRazon2.setId(2L);
        assertThat(controlCambioRazon1).isNotEqualTo(controlCambioRazon2);
        controlCambioRazon1.setId(null);
        assertThat(controlCambioRazon1).isNotEqualTo(controlCambioRazon2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ControlCambioRazonDTO.class);
        ControlCambioRazonDTO controlCambioRazonDTO1 = new ControlCambioRazonDTO();
        controlCambioRazonDTO1.setId(1L);
        ControlCambioRazonDTO controlCambioRazonDTO2 = new ControlCambioRazonDTO();
        assertThat(controlCambioRazonDTO1).isNotEqualTo(controlCambioRazonDTO2);
        controlCambioRazonDTO2.setId(controlCambioRazonDTO1.getId());
        assertThat(controlCambioRazonDTO1).isEqualTo(controlCambioRazonDTO2);
        controlCambioRazonDTO2.setId(2L);
        assertThat(controlCambioRazonDTO1).isNotEqualTo(controlCambioRazonDTO2);
        controlCambioRazonDTO1.setId(null);
        assertThat(controlCambioRazonDTO1).isNotEqualTo(controlCambioRazonDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(controlCambioRazonMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(controlCambioRazonMapper.fromId(null)).isNull();
    }
}
