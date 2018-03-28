package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.DemojhipsterApp;

import io.github.jhipster.application.domain.Socio;
import io.github.jhipster.application.repository.SocioRepository;
import io.github.jhipster.application.service.SocioService;
import io.github.jhipster.application.service.dto.SocioDTO;
import io.github.jhipster.application.service.mapper.SocioMapper;
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
 * Test class for the SocioResource REST controller.
 *
 * @see SocioResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemojhipsterApp.class)
public class SocioResourceIntTest {

    private static final Integer DEFAULT_RUT = 1;
    private static final Integer UPDATED_RUT = 2;

    private static final String DEFAULT_DV = "AAAAAAAAAA";
    private static final String UPDATED_DV = "BBBBBBBBBB";

    private static final String DEFAULT_NOMBRE = "AAAAAAAAAA";
    private static final String UPDATED_NOMBRE = "BBBBBBBBBB";

    private static final String DEFAULT_EXTRACTO = "AAAAAAAAAA";
    private static final String UPDATED_EXTRACTO = "BBBBBBBBBB";

    private static final String DEFAULT_APORTE = "AAAAAAAAAA";
    private static final String UPDATED_APORTE = "BBBBBBBBBB";

    private static final Float DEFAULT_APORTE_PORCEN = 1F;
    private static final Float UPDATED_APORTE_PORCEN = 2F;

    private static final Integer DEFAULT_ESTADO = 1;
    private static final Integer UPDATED_ESTADO = 2;

    private static final Integer DEFAULT_ESTADO_ES = 1;
    private static final Integer UPDATED_ESTADO_ES = 2;

    private static final Integer DEFAULT_IDEN = 1;
    private static final Integer UPDATED_IDEN = 2;

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private SocioMapper socioMapper;

    @Autowired
    private SocioService socioService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restSocioMockMvc;

    private Socio socio;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SocioResource socioResource = new SocioResource(socioService);
        this.restSocioMockMvc = MockMvcBuilders.standaloneSetup(socioResource)
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
    public static Socio createEntity(EntityManager em) {
        Socio socio = new Socio()
            .rut(DEFAULT_RUT)
            .dv(DEFAULT_DV)
            .nombre(DEFAULT_NOMBRE)
            .extracto(DEFAULT_EXTRACTO)
            .aporte(DEFAULT_APORTE)
            .aportePorcen(DEFAULT_APORTE_PORCEN)
            .estado(DEFAULT_ESTADO)
            .estadoEs(DEFAULT_ESTADO_ES)
            .iden(DEFAULT_IDEN);
        return socio;
    }

    @Before
    public void initTest() {
        socio = createEntity(em);
    }

    @Test
    @Transactional
    public void createSocio() throws Exception {
        int databaseSizeBeforeCreate = socioRepository.findAll().size();

        // Create the Socio
        SocioDTO socioDTO = socioMapper.toDto(socio);
        restSocioMockMvc.perform(post("/api/socios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(socioDTO)))
            .andExpect(status().isCreated());

        // Validate the Socio in the database
        List<Socio> socioList = socioRepository.findAll();
        assertThat(socioList).hasSize(databaseSizeBeforeCreate + 1);
        Socio testSocio = socioList.get(socioList.size() - 1);
        assertThat(testSocio.getRut()).isEqualTo(DEFAULT_RUT);
        assertThat(testSocio.getDv()).isEqualTo(DEFAULT_DV);
        assertThat(testSocio.getNombre()).isEqualTo(DEFAULT_NOMBRE);
        assertThat(testSocio.getExtracto()).isEqualTo(DEFAULT_EXTRACTO);
        assertThat(testSocio.getAporte()).isEqualTo(DEFAULT_APORTE);
        assertThat(testSocio.getAportePorcen()).isEqualTo(DEFAULT_APORTE_PORCEN);
        assertThat(testSocio.getEstado()).isEqualTo(DEFAULT_ESTADO);
        assertThat(testSocio.getEstadoEs()).isEqualTo(DEFAULT_ESTADO_ES);
        assertThat(testSocio.getIden()).isEqualTo(DEFAULT_IDEN);
    }

    @Test
    @Transactional
    public void createSocioWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = socioRepository.findAll().size();

        // Create the Socio with an existing ID
        socio.setId(1L);
        SocioDTO socioDTO = socioMapper.toDto(socio);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSocioMockMvc.perform(post("/api/socios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(socioDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Socio in the database
        List<Socio> socioList = socioRepository.findAll();
        assertThat(socioList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllSocios() throws Exception {
        // Initialize the database
        socioRepository.saveAndFlush(socio);

        // Get all the socioList
        restSocioMockMvc.perform(get("/api/socios?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(socio.getId().intValue())))
            .andExpect(jsonPath("$.[*].rut").value(hasItem(DEFAULT_RUT)))
            .andExpect(jsonPath("$.[*].dv").value(hasItem(DEFAULT_DV.toString())))
            .andExpect(jsonPath("$.[*].nombre").value(hasItem(DEFAULT_NOMBRE.toString())))
            .andExpect(jsonPath("$.[*].extracto").value(hasItem(DEFAULT_EXTRACTO.toString())))
            .andExpect(jsonPath("$.[*].aporte").value(hasItem(DEFAULT_APORTE.toString())))
            .andExpect(jsonPath("$.[*].aportePorcen").value(hasItem(DEFAULT_APORTE_PORCEN.doubleValue())))
            .andExpect(jsonPath("$.[*].estado").value(hasItem(DEFAULT_ESTADO)))
            .andExpect(jsonPath("$.[*].estadoEs").value(hasItem(DEFAULT_ESTADO_ES)))
            .andExpect(jsonPath("$.[*].iden").value(hasItem(DEFAULT_IDEN)));
    }

    @Test
    @Transactional
    public void getSocio() throws Exception {
        // Initialize the database
        socioRepository.saveAndFlush(socio);

        // Get the socio
        restSocioMockMvc.perform(get("/api/socios/{id}", socio.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(socio.getId().intValue()))
            .andExpect(jsonPath("$.rut").value(DEFAULT_RUT))
            .andExpect(jsonPath("$.dv").value(DEFAULT_DV.toString()))
            .andExpect(jsonPath("$.nombre").value(DEFAULT_NOMBRE.toString()))
            .andExpect(jsonPath("$.extracto").value(DEFAULT_EXTRACTO.toString()))
            .andExpect(jsonPath("$.aporte").value(DEFAULT_APORTE.toString()))
            .andExpect(jsonPath("$.aportePorcen").value(DEFAULT_APORTE_PORCEN.doubleValue()))
            .andExpect(jsonPath("$.estado").value(DEFAULT_ESTADO))
            .andExpect(jsonPath("$.estadoEs").value(DEFAULT_ESTADO_ES))
            .andExpect(jsonPath("$.iden").value(DEFAULT_IDEN));
    }

    @Test
    @Transactional
    public void getNonExistingSocio() throws Exception {
        // Get the socio
        restSocioMockMvc.perform(get("/api/socios/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSocio() throws Exception {
        // Initialize the database
        socioRepository.saveAndFlush(socio);
        int databaseSizeBeforeUpdate = socioRepository.findAll().size();

        // Update the socio
        Socio updatedSocio = socioRepository.findOne(socio.getId());
        // Disconnect from session so that the updates on updatedSocio are not directly saved in db
        em.detach(updatedSocio);
        updatedSocio
            .rut(UPDATED_RUT)
            .dv(UPDATED_DV)
            .nombre(UPDATED_NOMBRE)
            .extracto(UPDATED_EXTRACTO)
            .aporte(UPDATED_APORTE)
            .aportePorcen(UPDATED_APORTE_PORCEN)
            .estado(UPDATED_ESTADO)
            .estadoEs(UPDATED_ESTADO_ES)
            .iden(UPDATED_IDEN);
        SocioDTO socioDTO = socioMapper.toDto(updatedSocio);

        restSocioMockMvc.perform(put("/api/socios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(socioDTO)))
            .andExpect(status().isOk());

        // Validate the Socio in the database
        List<Socio> socioList = socioRepository.findAll();
        assertThat(socioList).hasSize(databaseSizeBeforeUpdate);
        Socio testSocio = socioList.get(socioList.size() - 1);
        assertThat(testSocio.getRut()).isEqualTo(UPDATED_RUT);
        assertThat(testSocio.getDv()).isEqualTo(UPDATED_DV);
        assertThat(testSocio.getNombre()).isEqualTo(UPDATED_NOMBRE);
        assertThat(testSocio.getExtracto()).isEqualTo(UPDATED_EXTRACTO);
        assertThat(testSocio.getAporte()).isEqualTo(UPDATED_APORTE);
        assertThat(testSocio.getAportePorcen()).isEqualTo(UPDATED_APORTE_PORCEN);
        assertThat(testSocio.getEstado()).isEqualTo(UPDATED_ESTADO);
        assertThat(testSocio.getEstadoEs()).isEqualTo(UPDATED_ESTADO_ES);
        assertThat(testSocio.getIden()).isEqualTo(UPDATED_IDEN);
    }

    @Test
    @Transactional
    public void updateNonExistingSocio() throws Exception {
        int databaseSizeBeforeUpdate = socioRepository.findAll().size();

        // Create the Socio
        SocioDTO socioDTO = socioMapper.toDto(socio);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restSocioMockMvc.perform(put("/api/socios")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(socioDTO)))
            .andExpect(status().isCreated());

        // Validate the Socio in the database
        List<Socio> socioList = socioRepository.findAll();
        assertThat(socioList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteSocio() throws Exception {
        // Initialize the database
        socioRepository.saveAndFlush(socio);
        int databaseSizeBeforeDelete = socioRepository.findAll().size();

        // Get the socio
        restSocioMockMvc.perform(delete("/api/socios/{id}", socio.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Socio> socioList = socioRepository.findAll();
        assertThat(socioList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Socio.class);
        Socio socio1 = new Socio();
        socio1.setId(1L);
        Socio socio2 = new Socio();
        socio2.setId(socio1.getId());
        assertThat(socio1).isEqualTo(socio2);
        socio2.setId(2L);
        assertThat(socio1).isNotEqualTo(socio2);
        socio1.setId(null);
        assertThat(socio1).isNotEqualTo(socio2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(SocioDTO.class);
        SocioDTO socioDTO1 = new SocioDTO();
        socioDTO1.setId(1L);
        SocioDTO socioDTO2 = new SocioDTO();
        assertThat(socioDTO1).isNotEqualTo(socioDTO2);
        socioDTO2.setId(socioDTO1.getId());
        assertThat(socioDTO1).isEqualTo(socioDTO2);
        socioDTO2.setId(2L);
        assertThat(socioDTO1).isNotEqualTo(socioDTO2);
        socioDTO1.setId(null);
        assertThat(socioDTO1).isNotEqualTo(socioDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(socioMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(socioMapper.fromId(null)).isNull();
    }
}
