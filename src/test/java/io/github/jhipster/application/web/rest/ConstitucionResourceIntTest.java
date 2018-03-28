package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.DemojhipsterApp;

import io.github.jhipster.application.domain.Constitucion;
import io.github.jhipster.application.repository.ConstitucionRepository;
import io.github.jhipster.application.service.ConstitucionService;
import io.github.jhipster.application.service.dto.ConstitucionDTO;
import io.github.jhipster.application.service.mapper.ConstitucionMapper;
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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static io.github.jhipster.application.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ConstitucionResource REST controller.
 *
 * @see ConstitucionResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemojhipsterApp.class)
public class ConstitucionResourceIntTest {

    private static final Integer DEFAULT_RUT = 1;
    private static final Integer UPDATED_RUT = 2;

    private static final String DEFAULT_DV = "AAAAAAAAAA";
    private static final String UPDATED_DV = "BBBBBBBBBB";

    private static final String DEFAULT_EXTRACTO = "AAAAAAAAAA";
    private static final String UPDATED_EXTRACTO = "BBBBBBBBBB";

    private static final String DEFAULT_NOMBRE = "AAAAAAAAAA";
    private static final String UPDATED_NOMBRE = "BBBBBBBBBB";

    private static final String DEFAULT_FECPUB = "AAAAAAAAAA";
    private static final String UPDATED_FECPUB = "BBBBBBBBBB";

    private static final String DEFAULT_NOMFAN = "AAAAAAAAAA";
    private static final String UPDATED_NOMFAN = "BBBBBBBBBB";

    private static final String DEFAULT_FECONST = "AAAAAAAAAA";
    private static final String UPDATED_FECONST = "BBBBBBBBBB";

    private static final String DEFAULT_TIPCONST = "AAAAAAAAAA";
    private static final String UPDATED_TIPCONST = "BBBBBBBBBB";

    private static final String DEFAULT_DURACION = "AAAAAAAAAA";
    private static final String UPDATED_DURACION = "BBBBBBBBBB";

    private static final String DEFAULT_FECTERM = "AAAAAAAAAA";
    private static final String UPDATED_FECTERM = "BBBBBBBBBB";

    private static final String DEFAULT_CAPPAG = "AAAAAAAAAA";
    private static final String UPDATED_CAPPAG = "BBBBBBBBBB";

    private static final String DEFAULT_CAPSUS = "AAAAAAAAAA";
    private static final String UPDATED_CAPSUS = "BBBBBBBBBB";

    private static final String DEFAULT_NACCIONES = "AAAAAAAAAA";
    private static final String UPDATED_NACCIONES = "BBBBBBBBBB";

    private static final Integer DEFAULT_NOTARIORUT = 1;
    private static final Integer UPDATED_NOTARIORUT = 2;

    private static final String DEFAULT_NOTARIODV = "AAAAAAAAAA";
    private static final String UPDATED_NOTARIODV = "BBBBBBBBBB";

    private static final Integer DEFAULT_DIRECTORRUT = 1;
    private static final Integer UPDATED_DIRECTORRUT = 2;

    private static final String DEFAULT_DIRECTORDV = "AAAAAAAAAA";
    private static final String UPDATED_DIRECTORDV = "BBBBBBBBBB";

    private static final Integer DEFAULT_REPRUT = 1;
    private static final Integer UPDATED_REPRUT = 2;

    private static final String DEFAULT_REPDV = "AAAAAAAAAA";
    private static final String UPDATED_REPDV = "BBBBBBBBBB";

    private static final Integer DEFAULT_ESTADO = 1;
    private static final Integer UPDATED_ESTADO = 2;

    private static final Integer DEFAULT_EXTNOMDUP = 1;
    private static final Integer UPDATED_EXTNOMDUP = 2;

    private static final Integer DEFAULT_EXTNOMDUPRUT = 1;
    private static final Integer UPDATED_EXTNOMDUPRUT = 2;

    private static final String DEFAULT_EXTNOMDUPDV = "AAAAAAAAAA";
    private static final String UPDATED_EXTNOMDUPDV = "BBBBBBBBBB";

    private static final Integer DEFAULT_GRUPO = 1;
    private static final Integer UPDATED_GRUPO = 2;

    private static final LocalDate DEFAULT_FECACT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FECACT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_FECACTNOM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FECACTNOM = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private ConstitucionRepository constitucionRepository;

    @Autowired
    private ConstitucionMapper constitucionMapper;

    @Autowired
    private ConstitucionService constitucionService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restConstitucionMockMvc;

    private Constitucion constitucion;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ConstitucionResource constitucionResource = new ConstitucionResource(constitucionService);
        this.restConstitucionMockMvc = MockMvcBuilders.standaloneSetup(constitucionResource)
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
    public static Constitucion createEntity(EntityManager em) {
        Constitucion constitucion = new Constitucion()
            .rut(DEFAULT_RUT)
            .dv(DEFAULT_DV)
            .extracto(DEFAULT_EXTRACTO)
            .nombre(DEFAULT_NOMBRE)
            .fecpub(DEFAULT_FECPUB)
            .nomfan(DEFAULT_NOMFAN)
            .feconst(DEFAULT_FECONST)
            .tipconst(DEFAULT_TIPCONST)
            .duracion(DEFAULT_DURACION)
            .fecterm(DEFAULT_FECTERM)
            .cappag(DEFAULT_CAPPAG)
            .capsus(DEFAULT_CAPSUS)
            .nacciones(DEFAULT_NACCIONES)
            .notariorut(DEFAULT_NOTARIORUT)
            .notariodv(DEFAULT_NOTARIODV)
            .directorrut(DEFAULT_DIRECTORRUT)
            .directordv(DEFAULT_DIRECTORDV)
            .reprut(DEFAULT_REPRUT)
            .repdv(DEFAULT_REPDV)
            .estado(DEFAULT_ESTADO)
            .extnomdup(DEFAULT_EXTNOMDUP)
            .extnomduprut(DEFAULT_EXTNOMDUPRUT)
            .extnomdupdv(DEFAULT_EXTNOMDUPDV)
            .grupo(DEFAULT_GRUPO)
            .fecact(DEFAULT_FECACT)
            .fecactnom(DEFAULT_FECACTNOM);
        return constitucion;
    }

    @Before
    public void initTest() {
        constitucion = createEntity(em);
    }

    @Test
    @Transactional
    public void createConstitucion() throws Exception {
        int databaseSizeBeforeCreate = constitucionRepository.findAll().size();

        // Create the Constitucion
        ConstitucionDTO constitucionDTO = constitucionMapper.toDto(constitucion);
        restConstitucionMockMvc.perform(post("/api/constitucions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(constitucionDTO)))
            .andExpect(status().isCreated());

        // Validate the Constitucion in the database
        List<Constitucion> constitucionList = constitucionRepository.findAll();
        assertThat(constitucionList).hasSize(databaseSizeBeforeCreate + 1);
        Constitucion testConstitucion = constitucionList.get(constitucionList.size() - 1);
        assertThat(testConstitucion.getRut()).isEqualTo(DEFAULT_RUT);
        assertThat(testConstitucion.getDv()).isEqualTo(DEFAULT_DV);
        assertThat(testConstitucion.getExtracto()).isEqualTo(DEFAULT_EXTRACTO);
        assertThat(testConstitucion.getNombre()).isEqualTo(DEFAULT_NOMBRE);
        assertThat(testConstitucion.getFecpub()).isEqualTo(DEFAULT_FECPUB);
        assertThat(testConstitucion.getNomfan()).isEqualTo(DEFAULT_NOMFAN);
        assertThat(testConstitucion.getFeconst()).isEqualTo(DEFAULT_FECONST);
        assertThat(testConstitucion.getTipconst()).isEqualTo(DEFAULT_TIPCONST);
        assertThat(testConstitucion.getDuracion()).isEqualTo(DEFAULT_DURACION);
        assertThat(testConstitucion.getFecterm()).isEqualTo(DEFAULT_FECTERM);
        assertThat(testConstitucion.getCappag()).isEqualTo(DEFAULT_CAPPAG);
        assertThat(testConstitucion.getCapsus()).isEqualTo(DEFAULT_CAPSUS);
        assertThat(testConstitucion.getNacciones()).isEqualTo(DEFAULT_NACCIONES);
        assertThat(testConstitucion.getNotariorut()).isEqualTo(DEFAULT_NOTARIORUT);
        assertThat(testConstitucion.getNotariodv()).isEqualTo(DEFAULT_NOTARIODV);
        assertThat(testConstitucion.getDirectorrut()).isEqualTo(DEFAULT_DIRECTORRUT);
        assertThat(testConstitucion.getDirectordv()).isEqualTo(DEFAULT_DIRECTORDV);
        assertThat(testConstitucion.getReprut()).isEqualTo(DEFAULT_REPRUT);
        assertThat(testConstitucion.getRepdv()).isEqualTo(DEFAULT_REPDV);
        assertThat(testConstitucion.getEstado()).isEqualTo(DEFAULT_ESTADO);
        assertThat(testConstitucion.getExtnomdup()).isEqualTo(DEFAULT_EXTNOMDUP);
        assertThat(testConstitucion.getExtnomduprut()).isEqualTo(DEFAULT_EXTNOMDUPRUT);
        assertThat(testConstitucion.getExtnomdupdv()).isEqualTo(DEFAULT_EXTNOMDUPDV);
        assertThat(testConstitucion.getGrupo()).isEqualTo(DEFAULT_GRUPO);
        assertThat(testConstitucion.getFecact()).isEqualTo(DEFAULT_FECACT);
        assertThat(testConstitucion.getFecactnom()).isEqualTo(DEFAULT_FECACTNOM);
    }

    @Test
    @Transactional
    public void createConstitucionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = constitucionRepository.findAll().size();

        // Create the Constitucion with an existing ID
        constitucion.setId(1L);
        ConstitucionDTO constitucionDTO = constitucionMapper.toDto(constitucion);

        // An entity with an existing ID cannot be created, so this API call must fail
        restConstitucionMockMvc.perform(post("/api/constitucions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(constitucionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Constitucion in the database
        List<Constitucion> constitucionList = constitucionRepository.findAll();
        assertThat(constitucionList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllConstitucions() throws Exception {
        // Initialize the database
        constitucionRepository.saveAndFlush(constitucion);

        // Get all the constitucionList
        restConstitucionMockMvc.perform(get("/api/constitucions?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(constitucion.getId().intValue())))
            .andExpect(jsonPath("$.[*].rut").value(hasItem(DEFAULT_RUT)))
            .andExpect(jsonPath("$.[*].dv").value(hasItem(DEFAULT_DV.toString())))
            .andExpect(jsonPath("$.[*].extracto").value(hasItem(DEFAULT_EXTRACTO.toString())))
            .andExpect(jsonPath("$.[*].nombre").value(hasItem(DEFAULT_NOMBRE.toString())))
            .andExpect(jsonPath("$.[*].fecpub").value(hasItem(DEFAULT_FECPUB.toString())))
            .andExpect(jsonPath("$.[*].nomfan").value(hasItem(DEFAULT_NOMFAN.toString())))
            .andExpect(jsonPath("$.[*].feconst").value(hasItem(DEFAULT_FECONST.toString())))
            .andExpect(jsonPath("$.[*].tipconst").value(hasItem(DEFAULT_TIPCONST.toString())))
            .andExpect(jsonPath("$.[*].duracion").value(hasItem(DEFAULT_DURACION.toString())))
            .andExpect(jsonPath("$.[*].fecterm").value(hasItem(DEFAULT_FECTERM.toString())))
            .andExpect(jsonPath("$.[*].cappag").value(hasItem(DEFAULT_CAPPAG.toString())))
            .andExpect(jsonPath("$.[*].capsus").value(hasItem(DEFAULT_CAPSUS.toString())))
            .andExpect(jsonPath("$.[*].nacciones").value(hasItem(DEFAULT_NACCIONES.toString())))
            .andExpect(jsonPath("$.[*].notariorut").value(hasItem(DEFAULT_NOTARIORUT)))
            .andExpect(jsonPath("$.[*].notariodv").value(hasItem(DEFAULT_NOTARIODV.toString())))
            .andExpect(jsonPath("$.[*].directorrut").value(hasItem(DEFAULT_DIRECTORRUT)))
            .andExpect(jsonPath("$.[*].directordv").value(hasItem(DEFAULT_DIRECTORDV.toString())))
            .andExpect(jsonPath("$.[*].reprut").value(hasItem(DEFAULT_REPRUT)))
            .andExpect(jsonPath("$.[*].repdv").value(hasItem(DEFAULT_REPDV.toString())))
            .andExpect(jsonPath("$.[*].estado").value(hasItem(DEFAULT_ESTADO)))
            .andExpect(jsonPath("$.[*].extnomdup").value(hasItem(DEFAULT_EXTNOMDUP)))
            .andExpect(jsonPath("$.[*].extnomduprut").value(hasItem(DEFAULT_EXTNOMDUPRUT)))
            .andExpect(jsonPath("$.[*].extnomdupdv").value(hasItem(DEFAULT_EXTNOMDUPDV.toString())))
            .andExpect(jsonPath("$.[*].grupo").value(hasItem(DEFAULT_GRUPO)))
            .andExpect(jsonPath("$.[*].fecact").value(hasItem(DEFAULT_FECACT.toString())))
            .andExpect(jsonPath("$.[*].fecactnom").value(hasItem(DEFAULT_FECACTNOM.toString())));
    }

    @Test
    @Transactional
    public void getConstitucion() throws Exception {
        // Initialize the database
        constitucionRepository.saveAndFlush(constitucion);

        // Get the constitucion
        restConstitucionMockMvc.perform(get("/api/constitucions/{id}", constitucion.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(constitucion.getId().intValue()))
            .andExpect(jsonPath("$.rut").value(DEFAULT_RUT))
            .andExpect(jsonPath("$.dv").value(DEFAULT_DV.toString()))
            .andExpect(jsonPath("$.extracto").value(DEFAULT_EXTRACTO.toString()))
            .andExpect(jsonPath("$.nombre").value(DEFAULT_NOMBRE.toString()))
            .andExpect(jsonPath("$.fecpub").value(DEFAULT_FECPUB.toString()))
            .andExpect(jsonPath("$.nomfan").value(DEFAULT_NOMFAN.toString()))
            .andExpect(jsonPath("$.feconst").value(DEFAULT_FECONST.toString()))
            .andExpect(jsonPath("$.tipconst").value(DEFAULT_TIPCONST.toString()))
            .andExpect(jsonPath("$.duracion").value(DEFAULT_DURACION.toString()))
            .andExpect(jsonPath("$.fecterm").value(DEFAULT_FECTERM.toString()))
            .andExpect(jsonPath("$.cappag").value(DEFAULT_CAPPAG.toString()))
            .andExpect(jsonPath("$.capsus").value(DEFAULT_CAPSUS.toString()))
            .andExpect(jsonPath("$.nacciones").value(DEFAULT_NACCIONES.toString()))
            .andExpect(jsonPath("$.notariorut").value(DEFAULT_NOTARIORUT))
            .andExpect(jsonPath("$.notariodv").value(DEFAULT_NOTARIODV.toString()))
            .andExpect(jsonPath("$.directorrut").value(DEFAULT_DIRECTORRUT))
            .andExpect(jsonPath("$.directordv").value(DEFAULT_DIRECTORDV.toString()))
            .andExpect(jsonPath("$.reprut").value(DEFAULT_REPRUT))
            .andExpect(jsonPath("$.repdv").value(DEFAULT_REPDV.toString()))
            .andExpect(jsonPath("$.estado").value(DEFAULT_ESTADO))
            .andExpect(jsonPath("$.extnomdup").value(DEFAULT_EXTNOMDUP))
            .andExpect(jsonPath("$.extnomduprut").value(DEFAULT_EXTNOMDUPRUT))
            .andExpect(jsonPath("$.extnomdupdv").value(DEFAULT_EXTNOMDUPDV.toString()))
            .andExpect(jsonPath("$.grupo").value(DEFAULT_GRUPO))
            .andExpect(jsonPath("$.fecact").value(DEFAULT_FECACT.toString()))
            .andExpect(jsonPath("$.fecactnom").value(DEFAULT_FECACTNOM.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingConstitucion() throws Exception {
        // Get the constitucion
        restConstitucionMockMvc.perform(get("/api/constitucions/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateConstitucion() throws Exception {
        // Initialize the database
        constitucionRepository.saveAndFlush(constitucion);
        int databaseSizeBeforeUpdate = constitucionRepository.findAll().size();

        // Update the constitucion
        Constitucion updatedConstitucion = constitucionRepository.findOne(constitucion.getId());
        // Disconnect from session so that the updates on updatedConstitucion are not directly saved in db
        em.detach(updatedConstitucion);
        updatedConstitucion
            .rut(UPDATED_RUT)
            .dv(UPDATED_DV)
            .extracto(UPDATED_EXTRACTO)
            .nombre(UPDATED_NOMBRE)
            .fecpub(UPDATED_FECPUB)
            .nomfan(UPDATED_NOMFAN)
            .feconst(UPDATED_FECONST)
            .tipconst(UPDATED_TIPCONST)
            .duracion(UPDATED_DURACION)
            .fecterm(UPDATED_FECTERM)
            .cappag(UPDATED_CAPPAG)
            .capsus(UPDATED_CAPSUS)
            .nacciones(UPDATED_NACCIONES)
            .notariorut(UPDATED_NOTARIORUT)
            .notariodv(UPDATED_NOTARIODV)
            .directorrut(UPDATED_DIRECTORRUT)
            .directordv(UPDATED_DIRECTORDV)
            .reprut(UPDATED_REPRUT)
            .repdv(UPDATED_REPDV)
            .estado(UPDATED_ESTADO)
            .extnomdup(UPDATED_EXTNOMDUP)
            .extnomduprut(UPDATED_EXTNOMDUPRUT)
            .extnomdupdv(UPDATED_EXTNOMDUPDV)
            .grupo(UPDATED_GRUPO)
            .fecact(UPDATED_FECACT)
            .fecactnom(UPDATED_FECACTNOM);
        ConstitucionDTO constitucionDTO = constitucionMapper.toDto(updatedConstitucion);

        restConstitucionMockMvc.perform(put("/api/constitucions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(constitucionDTO)))
            .andExpect(status().isOk());

        // Validate the Constitucion in the database
        List<Constitucion> constitucionList = constitucionRepository.findAll();
        assertThat(constitucionList).hasSize(databaseSizeBeforeUpdate);
        Constitucion testConstitucion = constitucionList.get(constitucionList.size() - 1);
        assertThat(testConstitucion.getRut()).isEqualTo(UPDATED_RUT);
        assertThat(testConstitucion.getDv()).isEqualTo(UPDATED_DV);
        assertThat(testConstitucion.getExtracto()).isEqualTo(UPDATED_EXTRACTO);
        assertThat(testConstitucion.getNombre()).isEqualTo(UPDATED_NOMBRE);
        assertThat(testConstitucion.getFecpub()).isEqualTo(UPDATED_FECPUB);
        assertThat(testConstitucion.getNomfan()).isEqualTo(UPDATED_NOMFAN);
        assertThat(testConstitucion.getFeconst()).isEqualTo(UPDATED_FECONST);
        assertThat(testConstitucion.getTipconst()).isEqualTo(UPDATED_TIPCONST);
        assertThat(testConstitucion.getDuracion()).isEqualTo(UPDATED_DURACION);
        assertThat(testConstitucion.getFecterm()).isEqualTo(UPDATED_FECTERM);
        assertThat(testConstitucion.getCappag()).isEqualTo(UPDATED_CAPPAG);
        assertThat(testConstitucion.getCapsus()).isEqualTo(UPDATED_CAPSUS);
        assertThat(testConstitucion.getNacciones()).isEqualTo(UPDATED_NACCIONES);
        assertThat(testConstitucion.getNotariorut()).isEqualTo(UPDATED_NOTARIORUT);
        assertThat(testConstitucion.getNotariodv()).isEqualTo(UPDATED_NOTARIODV);
        assertThat(testConstitucion.getDirectorrut()).isEqualTo(UPDATED_DIRECTORRUT);
        assertThat(testConstitucion.getDirectordv()).isEqualTo(UPDATED_DIRECTORDV);
        assertThat(testConstitucion.getReprut()).isEqualTo(UPDATED_REPRUT);
        assertThat(testConstitucion.getRepdv()).isEqualTo(UPDATED_REPDV);
        assertThat(testConstitucion.getEstado()).isEqualTo(UPDATED_ESTADO);
        assertThat(testConstitucion.getExtnomdup()).isEqualTo(UPDATED_EXTNOMDUP);
        assertThat(testConstitucion.getExtnomduprut()).isEqualTo(UPDATED_EXTNOMDUPRUT);
        assertThat(testConstitucion.getExtnomdupdv()).isEqualTo(UPDATED_EXTNOMDUPDV);
        assertThat(testConstitucion.getGrupo()).isEqualTo(UPDATED_GRUPO);
        assertThat(testConstitucion.getFecact()).isEqualTo(UPDATED_FECACT);
        assertThat(testConstitucion.getFecactnom()).isEqualTo(UPDATED_FECACTNOM);
    }

    @Test
    @Transactional
    public void updateNonExistingConstitucion() throws Exception {
        int databaseSizeBeforeUpdate = constitucionRepository.findAll().size();

        // Create the Constitucion
        ConstitucionDTO constitucionDTO = constitucionMapper.toDto(constitucion);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restConstitucionMockMvc.perform(put("/api/constitucions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(constitucionDTO)))
            .andExpect(status().isCreated());

        // Validate the Constitucion in the database
        List<Constitucion> constitucionList = constitucionRepository.findAll();
        assertThat(constitucionList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteConstitucion() throws Exception {
        // Initialize the database
        constitucionRepository.saveAndFlush(constitucion);
        int databaseSizeBeforeDelete = constitucionRepository.findAll().size();

        // Get the constitucion
        restConstitucionMockMvc.perform(delete("/api/constitucions/{id}", constitucion.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Constitucion> constitucionList = constitucionRepository.findAll();
        assertThat(constitucionList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Constitucion.class);
        Constitucion constitucion1 = new Constitucion();
        constitucion1.setId(1L);
        Constitucion constitucion2 = new Constitucion();
        constitucion2.setId(constitucion1.getId());
        assertThat(constitucion1).isEqualTo(constitucion2);
        constitucion2.setId(2L);
        assertThat(constitucion1).isNotEqualTo(constitucion2);
        constitucion1.setId(null);
        assertThat(constitucion1).isNotEqualTo(constitucion2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ConstitucionDTO.class);
        ConstitucionDTO constitucionDTO1 = new ConstitucionDTO();
        constitucionDTO1.setId(1L);
        ConstitucionDTO constitucionDTO2 = new ConstitucionDTO();
        assertThat(constitucionDTO1).isNotEqualTo(constitucionDTO2);
        constitucionDTO2.setId(constitucionDTO1.getId());
        assertThat(constitucionDTO1).isEqualTo(constitucionDTO2);
        constitucionDTO2.setId(2L);
        assertThat(constitucionDTO1).isNotEqualTo(constitucionDTO2);
        constitucionDTO1.setId(null);
        assertThat(constitucionDTO1).isNotEqualTo(constitucionDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(constitucionMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(constitucionMapper.fromId(null)).isNull();
    }
}
