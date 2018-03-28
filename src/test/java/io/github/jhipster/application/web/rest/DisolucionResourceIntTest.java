package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.DemojhipsterApp;

import io.github.jhipster.application.domain.Disolucion;
import io.github.jhipster.application.repository.DisolucionRepository;
import io.github.jhipster.application.service.DisolucionService;
import io.github.jhipster.application.service.dto.DisolucionDTO;
import io.github.jhipster.application.service.mapper.DisolucionMapper;
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
 * Test class for the DisolucionResource REST controller.
 *
 * @see DisolucionResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemojhipsterApp.class)
public class DisolucionResourceIntTest {

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

    private static final String DEFAULT_REGCOM = "AAAAAAAAAA";
    private static final String UPDATED_REGCOM = "BBBBBBBBBB";

    private static final String DEFAULT_FOJAS = "AAAAAAAAAA";
    private static final String UPDATED_FOJAS = "BBBBBBBBBB";

    private static final String DEFAULT_NUM = "AAAAAAAAAA";
    private static final String UPDATED_NUM = "BBBBBBBBBB";

    private static final String DEFAULT_ANO = "AAAAAAAAAA";
    private static final String UPDATED_ANO = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_FECESC = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FECESC = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_ESTADO = 1;
    private static final Integer UPDATED_ESTADO = 2;

    private static final Integer DEFAULT_GRUPO = 1;
    private static final Integer UPDATED_GRUPO = 2;

    private static final LocalDate DEFAULT_FECACT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FECACT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_FECACTNOM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FECACTNOM = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private DisolucionRepository disolucionRepository;

    @Autowired
    private DisolucionMapper disolucionMapper;

    @Autowired
    private DisolucionService disolucionService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restDisolucionMockMvc;

    private Disolucion disolucion;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final DisolucionResource disolucionResource = new DisolucionResource(disolucionService);
        this.restDisolucionMockMvc = MockMvcBuilders.standaloneSetup(disolucionResource)
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
    public static Disolucion createEntity(EntityManager em) {
        Disolucion disolucion = new Disolucion()
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
            .regcom(DEFAULT_REGCOM)
            .fojas(DEFAULT_FOJAS)
            .num(DEFAULT_NUM)
            .ano(DEFAULT_ANO)
            .fecesc(DEFAULT_FECESC)
            .estado(DEFAULT_ESTADO)
            .grupo(DEFAULT_GRUPO)
            .fecact(DEFAULT_FECACT)
            .fecactnom(DEFAULT_FECACTNOM);
        return disolucion;
    }

    @Before
    public void initTest() {
        disolucion = createEntity(em);
    }

    @Test
    @Transactional
    public void createDisolucion() throws Exception {
        int databaseSizeBeforeCreate = disolucionRepository.findAll().size();

        // Create the Disolucion
        DisolucionDTO disolucionDTO = disolucionMapper.toDto(disolucion);
        restDisolucionMockMvc.perform(post("/api/disolucions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(disolucionDTO)))
            .andExpect(status().isCreated());

        // Validate the Disolucion in the database
        List<Disolucion> disolucionList = disolucionRepository.findAll();
        assertThat(disolucionList).hasSize(databaseSizeBeforeCreate + 1);
        Disolucion testDisolucion = disolucionList.get(disolucionList.size() - 1);
        assertThat(testDisolucion.getRut()).isEqualTo(DEFAULT_RUT);
        assertThat(testDisolucion.getDv()).isEqualTo(DEFAULT_DV);
        assertThat(testDisolucion.getExtracto()).isEqualTo(DEFAULT_EXTRACTO);
        assertThat(testDisolucion.getNombre()).isEqualTo(DEFAULT_NOMBRE);
        assertThat(testDisolucion.getFecpub()).isEqualTo(DEFAULT_FECPUB);
        assertThat(testDisolucion.getNomfan()).isEqualTo(DEFAULT_NOMFAN);
        assertThat(testDisolucion.getFeconst()).isEqualTo(DEFAULT_FECONST);
        assertThat(testDisolucion.getTipconst()).isEqualTo(DEFAULT_TIPCONST);
        assertThat(testDisolucion.getDuracion()).isEqualTo(DEFAULT_DURACION);
        assertThat(testDisolucion.getFecterm()).isEqualTo(DEFAULT_FECTERM);
        assertThat(testDisolucion.getCappag()).isEqualTo(DEFAULT_CAPPAG);
        assertThat(testDisolucion.getCapsus()).isEqualTo(DEFAULT_CAPSUS);
        assertThat(testDisolucion.getNacciones()).isEqualTo(DEFAULT_NACCIONES);
        assertThat(testDisolucion.getNotariorut()).isEqualTo(DEFAULT_NOTARIORUT);
        assertThat(testDisolucion.getNotariodv()).isEqualTo(DEFAULT_NOTARIODV);
        assertThat(testDisolucion.getDirectorrut()).isEqualTo(DEFAULT_DIRECTORRUT);
        assertThat(testDisolucion.getDirectordv()).isEqualTo(DEFAULT_DIRECTORDV);
        assertThat(testDisolucion.getReprut()).isEqualTo(DEFAULT_REPRUT);
        assertThat(testDisolucion.getRepdv()).isEqualTo(DEFAULT_REPDV);
        assertThat(testDisolucion.getRegcom()).isEqualTo(DEFAULT_REGCOM);
        assertThat(testDisolucion.getFojas()).isEqualTo(DEFAULT_FOJAS);
        assertThat(testDisolucion.getNum()).isEqualTo(DEFAULT_NUM);
        assertThat(testDisolucion.getAno()).isEqualTo(DEFAULT_ANO);
        assertThat(testDisolucion.getFecesc()).isEqualTo(DEFAULT_FECESC);
        assertThat(testDisolucion.getEstado()).isEqualTo(DEFAULT_ESTADO);
        assertThat(testDisolucion.getGrupo()).isEqualTo(DEFAULT_GRUPO);
        assertThat(testDisolucion.getFecact()).isEqualTo(DEFAULT_FECACT);
        assertThat(testDisolucion.getFecactnom()).isEqualTo(DEFAULT_FECACTNOM);
    }

    @Test
    @Transactional
    public void createDisolucionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = disolucionRepository.findAll().size();

        // Create the Disolucion with an existing ID
        disolucion.setId(1L);
        DisolucionDTO disolucionDTO = disolucionMapper.toDto(disolucion);

        // An entity with an existing ID cannot be created, so this API call must fail
        restDisolucionMockMvc.perform(post("/api/disolucions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(disolucionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Disolucion in the database
        List<Disolucion> disolucionList = disolucionRepository.findAll();
        assertThat(disolucionList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllDisolucions() throws Exception {
        // Initialize the database
        disolucionRepository.saveAndFlush(disolucion);

        // Get all the disolucionList
        restDisolucionMockMvc.perform(get("/api/disolucions?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(disolucion.getId().intValue())))
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
            .andExpect(jsonPath("$.[*].regcom").value(hasItem(DEFAULT_REGCOM.toString())))
            .andExpect(jsonPath("$.[*].fojas").value(hasItem(DEFAULT_FOJAS.toString())))
            .andExpect(jsonPath("$.[*].num").value(hasItem(DEFAULT_NUM.toString())))
            .andExpect(jsonPath("$.[*].ano").value(hasItem(DEFAULT_ANO.toString())))
            .andExpect(jsonPath("$.[*].fecesc").value(hasItem(DEFAULT_FECESC.toString())))
            .andExpect(jsonPath("$.[*].estado").value(hasItem(DEFAULT_ESTADO)))
            .andExpect(jsonPath("$.[*].grupo").value(hasItem(DEFAULT_GRUPO)))
            .andExpect(jsonPath("$.[*].fecact").value(hasItem(DEFAULT_FECACT.toString())))
            .andExpect(jsonPath("$.[*].fecactnom").value(hasItem(DEFAULT_FECACTNOM.toString())));
    }

    @Test
    @Transactional
    public void getDisolucion() throws Exception {
        // Initialize the database
        disolucionRepository.saveAndFlush(disolucion);

        // Get the disolucion
        restDisolucionMockMvc.perform(get("/api/disolucions/{id}", disolucion.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(disolucion.getId().intValue()))
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
            .andExpect(jsonPath("$.regcom").value(DEFAULT_REGCOM.toString()))
            .andExpect(jsonPath("$.fojas").value(DEFAULT_FOJAS.toString()))
            .andExpect(jsonPath("$.num").value(DEFAULT_NUM.toString()))
            .andExpect(jsonPath("$.ano").value(DEFAULT_ANO.toString()))
            .andExpect(jsonPath("$.fecesc").value(DEFAULT_FECESC.toString()))
            .andExpect(jsonPath("$.estado").value(DEFAULT_ESTADO))
            .andExpect(jsonPath("$.grupo").value(DEFAULT_GRUPO))
            .andExpect(jsonPath("$.fecact").value(DEFAULT_FECACT.toString()))
            .andExpect(jsonPath("$.fecactnom").value(DEFAULT_FECACTNOM.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingDisolucion() throws Exception {
        // Get the disolucion
        restDisolucionMockMvc.perform(get("/api/disolucions/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateDisolucion() throws Exception {
        // Initialize the database
        disolucionRepository.saveAndFlush(disolucion);
        int databaseSizeBeforeUpdate = disolucionRepository.findAll().size();

        // Update the disolucion
        Disolucion updatedDisolucion = disolucionRepository.findOne(disolucion.getId());
        // Disconnect from session so that the updates on updatedDisolucion are not directly saved in db
        em.detach(updatedDisolucion);
        updatedDisolucion
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
            .regcom(UPDATED_REGCOM)
            .fojas(UPDATED_FOJAS)
            .num(UPDATED_NUM)
            .ano(UPDATED_ANO)
            .fecesc(UPDATED_FECESC)
            .estado(UPDATED_ESTADO)
            .grupo(UPDATED_GRUPO)
            .fecact(UPDATED_FECACT)
            .fecactnom(UPDATED_FECACTNOM);
        DisolucionDTO disolucionDTO = disolucionMapper.toDto(updatedDisolucion);

        restDisolucionMockMvc.perform(put("/api/disolucions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(disolucionDTO)))
            .andExpect(status().isOk());

        // Validate the Disolucion in the database
        List<Disolucion> disolucionList = disolucionRepository.findAll();
        assertThat(disolucionList).hasSize(databaseSizeBeforeUpdate);
        Disolucion testDisolucion = disolucionList.get(disolucionList.size() - 1);
        assertThat(testDisolucion.getRut()).isEqualTo(UPDATED_RUT);
        assertThat(testDisolucion.getDv()).isEqualTo(UPDATED_DV);
        assertThat(testDisolucion.getExtracto()).isEqualTo(UPDATED_EXTRACTO);
        assertThat(testDisolucion.getNombre()).isEqualTo(UPDATED_NOMBRE);
        assertThat(testDisolucion.getFecpub()).isEqualTo(UPDATED_FECPUB);
        assertThat(testDisolucion.getNomfan()).isEqualTo(UPDATED_NOMFAN);
        assertThat(testDisolucion.getFeconst()).isEqualTo(UPDATED_FECONST);
        assertThat(testDisolucion.getTipconst()).isEqualTo(UPDATED_TIPCONST);
        assertThat(testDisolucion.getDuracion()).isEqualTo(UPDATED_DURACION);
        assertThat(testDisolucion.getFecterm()).isEqualTo(UPDATED_FECTERM);
        assertThat(testDisolucion.getCappag()).isEqualTo(UPDATED_CAPPAG);
        assertThat(testDisolucion.getCapsus()).isEqualTo(UPDATED_CAPSUS);
        assertThat(testDisolucion.getNacciones()).isEqualTo(UPDATED_NACCIONES);
        assertThat(testDisolucion.getNotariorut()).isEqualTo(UPDATED_NOTARIORUT);
        assertThat(testDisolucion.getNotariodv()).isEqualTo(UPDATED_NOTARIODV);
        assertThat(testDisolucion.getDirectorrut()).isEqualTo(UPDATED_DIRECTORRUT);
        assertThat(testDisolucion.getDirectordv()).isEqualTo(UPDATED_DIRECTORDV);
        assertThat(testDisolucion.getReprut()).isEqualTo(UPDATED_REPRUT);
        assertThat(testDisolucion.getRepdv()).isEqualTo(UPDATED_REPDV);
        assertThat(testDisolucion.getRegcom()).isEqualTo(UPDATED_REGCOM);
        assertThat(testDisolucion.getFojas()).isEqualTo(UPDATED_FOJAS);
        assertThat(testDisolucion.getNum()).isEqualTo(UPDATED_NUM);
        assertThat(testDisolucion.getAno()).isEqualTo(UPDATED_ANO);
        assertThat(testDisolucion.getFecesc()).isEqualTo(UPDATED_FECESC);
        assertThat(testDisolucion.getEstado()).isEqualTo(UPDATED_ESTADO);
        assertThat(testDisolucion.getGrupo()).isEqualTo(UPDATED_GRUPO);
        assertThat(testDisolucion.getFecact()).isEqualTo(UPDATED_FECACT);
        assertThat(testDisolucion.getFecactnom()).isEqualTo(UPDATED_FECACTNOM);
    }

    @Test
    @Transactional
    public void updateNonExistingDisolucion() throws Exception {
        int databaseSizeBeforeUpdate = disolucionRepository.findAll().size();

        // Create the Disolucion
        DisolucionDTO disolucionDTO = disolucionMapper.toDto(disolucion);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restDisolucionMockMvc.perform(put("/api/disolucions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(disolucionDTO)))
            .andExpect(status().isCreated());

        // Validate the Disolucion in the database
        List<Disolucion> disolucionList = disolucionRepository.findAll();
        assertThat(disolucionList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteDisolucion() throws Exception {
        // Initialize the database
        disolucionRepository.saveAndFlush(disolucion);
        int databaseSizeBeforeDelete = disolucionRepository.findAll().size();

        // Get the disolucion
        restDisolucionMockMvc.perform(delete("/api/disolucions/{id}", disolucion.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Disolucion> disolucionList = disolucionRepository.findAll();
        assertThat(disolucionList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Disolucion.class);
        Disolucion disolucion1 = new Disolucion();
        disolucion1.setId(1L);
        Disolucion disolucion2 = new Disolucion();
        disolucion2.setId(disolucion1.getId());
        assertThat(disolucion1).isEqualTo(disolucion2);
        disolucion2.setId(2L);
        assertThat(disolucion1).isNotEqualTo(disolucion2);
        disolucion1.setId(null);
        assertThat(disolucion1).isNotEqualTo(disolucion2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DisolucionDTO.class);
        DisolucionDTO disolucionDTO1 = new DisolucionDTO();
        disolucionDTO1.setId(1L);
        DisolucionDTO disolucionDTO2 = new DisolucionDTO();
        assertThat(disolucionDTO1).isNotEqualTo(disolucionDTO2);
        disolucionDTO2.setId(disolucionDTO1.getId());
        assertThat(disolucionDTO1).isEqualTo(disolucionDTO2);
        disolucionDTO2.setId(2L);
        assertThat(disolucionDTO1).isNotEqualTo(disolucionDTO2);
        disolucionDTO1.setId(null);
        assertThat(disolucionDTO1).isNotEqualTo(disolucionDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(disolucionMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(disolucionMapper.fromId(null)).isNull();
    }
}
