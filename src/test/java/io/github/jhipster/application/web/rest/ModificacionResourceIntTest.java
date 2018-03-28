package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.DemojhipsterApp;

import io.github.jhipster.application.domain.Modificacion;
import io.github.jhipster.application.repository.ModificacionRepository;
import io.github.jhipster.application.service.ModificacionService;
import io.github.jhipster.application.service.dto.ModificacionDTO;
import io.github.jhipster.application.service.mapper.ModificacionMapper;
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
 * Test class for the ModificacionResource REST controller.
 *
 * @see ModificacionResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemojhipsterApp.class)
public class ModificacionResourceIntTest {

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

    private static final String DEFAULT_FPUBCONST = "AAAAAAAAAA";
    private static final String UPDATED_FPUBCONST = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_FECESCRIT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FECESCRIT = LocalDate.now(ZoneId.systemDefault());

    private static final Integer DEFAULT_ESTADO = 1;
    private static final Integer UPDATED_ESTADO = 2;

    private static final Integer DEFAULT_GRUPO = 1;
    private static final Integer UPDATED_GRUPO = 2;

    private static final LocalDate DEFAULT_FECACT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FECACT = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_FECACTNOM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FECACTNOM = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private ModificacionRepository modificacionRepository;

    @Autowired
    private ModificacionMapper modificacionMapper;

    @Autowired
    private ModificacionService modificacionService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restModificacionMockMvc;

    private Modificacion modificacion;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ModificacionResource modificacionResource = new ModificacionResource(modificacionService);
        this.restModificacionMockMvc = MockMvcBuilders.standaloneSetup(modificacionResource)
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
    public static Modificacion createEntity(EntityManager em) {
        Modificacion modificacion = new Modificacion()
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
            .fpubconst(DEFAULT_FPUBCONST)
            .fecescrit(DEFAULT_FECESCRIT)
            .estado(DEFAULT_ESTADO)
            .grupo(DEFAULT_GRUPO)
            .fecact(DEFAULT_FECACT)
            .fecactnom(DEFAULT_FECACTNOM);
        return modificacion;
    }

    @Before
    public void initTest() {
        modificacion = createEntity(em);
    }

    @Test
    @Transactional
    public void createModificacion() throws Exception {
        int databaseSizeBeforeCreate = modificacionRepository.findAll().size();

        // Create the Modificacion
        ModificacionDTO modificacionDTO = modificacionMapper.toDto(modificacion);
        restModificacionMockMvc.perform(post("/api/modificacions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(modificacionDTO)))
            .andExpect(status().isCreated());

        // Validate the Modificacion in the database
        List<Modificacion> modificacionList = modificacionRepository.findAll();
        assertThat(modificacionList).hasSize(databaseSizeBeforeCreate + 1);
        Modificacion testModificacion = modificacionList.get(modificacionList.size() - 1);
        assertThat(testModificacion.getRut()).isEqualTo(DEFAULT_RUT);
        assertThat(testModificacion.getDv()).isEqualTo(DEFAULT_DV);
        assertThat(testModificacion.getExtracto()).isEqualTo(DEFAULT_EXTRACTO);
        assertThat(testModificacion.getNombre()).isEqualTo(DEFAULT_NOMBRE);
        assertThat(testModificacion.getFecpub()).isEqualTo(DEFAULT_FECPUB);
        assertThat(testModificacion.getNomfan()).isEqualTo(DEFAULT_NOMFAN);
        assertThat(testModificacion.getFeconst()).isEqualTo(DEFAULT_FECONST);
        assertThat(testModificacion.getTipconst()).isEqualTo(DEFAULT_TIPCONST);
        assertThat(testModificacion.getDuracion()).isEqualTo(DEFAULT_DURACION);
        assertThat(testModificacion.getFecterm()).isEqualTo(DEFAULT_FECTERM);
        assertThat(testModificacion.getCappag()).isEqualTo(DEFAULT_CAPPAG);
        assertThat(testModificacion.getCapsus()).isEqualTo(DEFAULT_CAPSUS);
        assertThat(testModificacion.getNacciones()).isEqualTo(DEFAULT_NACCIONES);
        assertThat(testModificacion.getNotariorut()).isEqualTo(DEFAULT_NOTARIORUT);
        assertThat(testModificacion.getNotariodv()).isEqualTo(DEFAULT_NOTARIODV);
        assertThat(testModificacion.getDirectorrut()).isEqualTo(DEFAULT_DIRECTORRUT);
        assertThat(testModificacion.getDirectordv()).isEqualTo(DEFAULT_DIRECTORDV);
        assertThat(testModificacion.getReprut()).isEqualTo(DEFAULT_REPRUT);
        assertThat(testModificacion.getRepdv()).isEqualTo(DEFAULT_REPDV);
        assertThat(testModificacion.getRegcom()).isEqualTo(DEFAULT_REGCOM);
        assertThat(testModificacion.getFojas()).isEqualTo(DEFAULT_FOJAS);
        assertThat(testModificacion.getNum()).isEqualTo(DEFAULT_NUM);
        assertThat(testModificacion.getAno()).isEqualTo(DEFAULT_ANO);
        assertThat(testModificacion.getFpubconst()).isEqualTo(DEFAULT_FPUBCONST);
        assertThat(testModificacion.getFecescrit()).isEqualTo(DEFAULT_FECESCRIT);
        assertThat(testModificacion.getEstado()).isEqualTo(DEFAULT_ESTADO);
        assertThat(testModificacion.getGrupo()).isEqualTo(DEFAULT_GRUPO);
        assertThat(testModificacion.getFecact()).isEqualTo(DEFAULT_FECACT);
        assertThat(testModificacion.getFecactnom()).isEqualTo(DEFAULT_FECACTNOM);
    }

    @Test
    @Transactional
    public void createModificacionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = modificacionRepository.findAll().size();

        // Create the Modificacion with an existing ID
        modificacion.setId(1L);
        ModificacionDTO modificacionDTO = modificacionMapper.toDto(modificacion);

        // An entity with an existing ID cannot be created, so this API call must fail
        restModificacionMockMvc.perform(post("/api/modificacions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(modificacionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Modificacion in the database
        List<Modificacion> modificacionList = modificacionRepository.findAll();
        assertThat(modificacionList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllModificacions() throws Exception {
        // Initialize the database
        modificacionRepository.saveAndFlush(modificacion);

        // Get all the modificacionList
        restModificacionMockMvc.perform(get("/api/modificacions?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(modificacion.getId().intValue())))
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
            .andExpect(jsonPath("$.[*].fpubconst").value(hasItem(DEFAULT_FPUBCONST.toString())))
            .andExpect(jsonPath("$.[*].fecescrit").value(hasItem(DEFAULT_FECESCRIT.toString())))
            .andExpect(jsonPath("$.[*].estado").value(hasItem(DEFAULT_ESTADO)))
            .andExpect(jsonPath("$.[*].grupo").value(hasItem(DEFAULT_GRUPO)))
            .andExpect(jsonPath("$.[*].fecact").value(hasItem(DEFAULT_FECACT.toString())))
            .andExpect(jsonPath("$.[*].fecactnom").value(hasItem(DEFAULT_FECACTNOM.toString())));
    }

    @Test
    @Transactional
    public void getModificacion() throws Exception {
        // Initialize the database
        modificacionRepository.saveAndFlush(modificacion);

        // Get the modificacion
        restModificacionMockMvc.perform(get("/api/modificacions/{id}", modificacion.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(modificacion.getId().intValue()))
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
            .andExpect(jsonPath("$.fpubconst").value(DEFAULT_FPUBCONST.toString()))
            .andExpect(jsonPath("$.fecescrit").value(DEFAULT_FECESCRIT.toString()))
            .andExpect(jsonPath("$.estado").value(DEFAULT_ESTADO))
            .andExpect(jsonPath("$.grupo").value(DEFAULT_GRUPO))
            .andExpect(jsonPath("$.fecact").value(DEFAULT_FECACT.toString()))
            .andExpect(jsonPath("$.fecactnom").value(DEFAULT_FECACTNOM.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingModificacion() throws Exception {
        // Get the modificacion
        restModificacionMockMvc.perform(get("/api/modificacions/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateModificacion() throws Exception {
        // Initialize the database
        modificacionRepository.saveAndFlush(modificacion);
        int databaseSizeBeforeUpdate = modificacionRepository.findAll().size();

        // Update the modificacion
        Modificacion updatedModificacion = modificacionRepository.findOne(modificacion.getId());
        // Disconnect from session so that the updates on updatedModificacion are not directly saved in db
        em.detach(updatedModificacion);
        updatedModificacion
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
            .fpubconst(UPDATED_FPUBCONST)
            .fecescrit(UPDATED_FECESCRIT)
            .estado(UPDATED_ESTADO)
            .grupo(UPDATED_GRUPO)
            .fecact(UPDATED_FECACT)
            .fecactnom(UPDATED_FECACTNOM);
        ModificacionDTO modificacionDTO = modificacionMapper.toDto(updatedModificacion);

        restModificacionMockMvc.perform(put("/api/modificacions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(modificacionDTO)))
            .andExpect(status().isOk());

        // Validate the Modificacion in the database
        List<Modificacion> modificacionList = modificacionRepository.findAll();
        assertThat(modificacionList).hasSize(databaseSizeBeforeUpdate);
        Modificacion testModificacion = modificacionList.get(modificacionList.size() - 1);
        assertThat(testModificacion.getRut()).isEqualTo(UPDATED_RUT);
        assertThat(testModificacion.getDv()).isEqualTo(UPDATED_DV);
        assertThat(testModificacion.getExtracto()).isEqualTo(UPDATED_EXTRACTO);
        assertThat(testModificacion.getNombre()).isEqualTo(UPDATED_NOMBRE);
        assertThat(testModificacion.getFecpub()).isEqualTo(UPDATED_FECPUB);
        assertThat(testModificacion.getNomfan()).isEqualTo(UPDATED_NOMFAN);
        assertThat(testModificacion.getFeconst()).isEqualTo(UPDATED_FECONST);
        assertThat(testModificacion.getTipconst()).isEqualTo(UPDATED_TIPCONST);
        assertThat(testModificacion.getDuracion()).isEqualTo(UPDATED_DURACION);
        assertThat(testModificacion.getFecterm()).isEqualTo(UPDATED_FECTERM);
        assertThat(testModificacion.getCappag()).isEqualTo(UPDATED_CAPPAG);
        assertThat(testModificacion.getCapsus()).isEqualTo(UPDATED_CAPSUS);
        assertThat(testModificacion.getNacciones()).isEqualTo(UPDATED_NACCIONES);
        assertThat(testModificacion.getNotariorut()).isEqualTo(UPDATED_NOTARIORUT);
        assertThat(testModificacion.getNotariodv()).isEqualTo(UPDATED_NOTARIODV);
        assertThat(testModificacion.getDirectorrut()).isEqualTo(UPDATED_DIRECTORRUT);
        assertThat(testModificacion.getDirectordv()).isEqualTo(UPDATED_DIRECTORDV);
        assertThat(testModificacion.getReprut()).isEqualTo(UPDATED_REPRUT);
        assertThat(testModificacion.getRepdv()).isEqualTo(UPDATED_REPDV);
        assertThat(testModificacion.getRegcom()).isEqualTo(UPDATED_REGCOM);
        assertThat(testModificacion.getFojas()).isEqualTo(UPDATED_FOJAS);
        assertThat(testModificacion.getNum()).isEqualTo(UPDATED_NUM);
        assertThat(testModificacion.getAno()).isEqualTo(UPDATED_ANO);
        assertThat(testModificacion.getFpubconst()).isEqualTo(UPDATED_FPUBCONST);
        assertThat(testModificacion.getFecescrit()).isEqualTo(UPDATED_FECESCRIT);
        assertThat(testModificacion.getEstado()).isEqualTo(UPDATED_ESTADO);
        assertThat(testModificacion.getGrupo()).isEqualTo(UPDATED_GRUPO);
        assertThat(testModificacion.getFecact()).isEqualTo(UPDATED_FECACT);
        assertThat(testModificacion.getFecactnom()).isEqualTo(UPDATED_FECACTNOM);
    }

    @Test
    @Transactional
    public void updateNonExistingModificacion() throws Exception {
        int databaseSizeBeforeUpdate = modificacionRepository.findAll().size();

        // Create the Modificacion
        ModificacionDTO modificacionDTO = modificacionMapper.toDto(modificacion);

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restModificacionMockMvc.perform(put("/api/modificacions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(modificacionDTO)))
            .andExpect(status().isCreated());

        // Validate the Modificacion in the database
        List<Modificacion> modificacionList = modificacionRepository.findAll();
        assertThat(modificacionList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteModificacion() throws Exception {
        // Initialize the database
        modificacionRepository.saveAndFlush(modificacion);
        int databaseSizeBeforeDelete = modificacionRepository.findAll().size();

        // Get the modificacion
        restModificacionMockMvc.perform(delete("/api/modificacions/{id}", modificacion.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Modificacion> modificacionList = modificacionRepository.findAll();
        assertThat(modificacionList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Modificacion.class);
        Modificacion modificacion1 = new Modificacion();
        modificacion1.setId(1L);
        Modificacion modificacion2 = new Modificacion();
        modificacion2.setId(modificacion1.getId());
        assertThat(modificacion1).isEqualTo(modificacion2);
        modificacion2.setId(2L);
        assertThat(modificacion1).isNotEqualTo(modificacion2);
        modificacion1.setId(null);
        assertThat(modificacion1).isNotEqualTo(modificacion2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ModificacionDTO.class);
        ModificacionDTO modificacionDTO1 = new ModificacionDTO();
        modificacionDTO1.setId(1L);
        ModificacionDTO modificacionDTO2 = new ModificacionDTO();
        assertThat(modificacionDTO1).isNotEqualTo(modificacionDTO2);
        modificacionDTO2.setId(modificacionDTO1.getId());
        assertThat(modificacionDTO1).isEqualTo(modificacionDTO2);
        modificacionDTO2.setId(2L);
        assertThat(modificacionDTO1).isNotEqualTo(modificacionDTO2);
        modificacionDTO1.setId(null);
        assertThat(modificacionDTO1).isNotEqualTo(modificacionDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(modificacionMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(modificacionMapper.fromId(null)).isNull();
    }
}
