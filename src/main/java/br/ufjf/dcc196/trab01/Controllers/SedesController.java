package br.ufjf.dcc196.trab01.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.ufjf.dcc196.trab01.Models.Atividade;
import br.ufjf.dcc196.trab01.Models.Categoria;
import br.ufjf.dcc196.trab01.Models.Membro;
import br.ufjf.dcc196.trab01.Models.Sede;
import br.ufjf.dcc196.trab01.Persistence.AtividadeRepository;
import br.ufjf.dcc196.trab01.Persistence.MembroRepository;
import br.ufjf.dcc196.trab01.Persistence.SedeRepository;

@Controller
@RequestMapping("/sedes")
public class SedesController {

    @Autowired
    private SedeRepository repositorySede;
    @Autowired
    private AtividadeRepository repositoryAtividade;
    @Autowired
    private MembroRepository repositoryMembro;

    @RequestMapping(value = { "/", "", "/index" })
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        List<Sede> sedes = repositorySede.findAll();
        mv.addObject("sedes", sedes);
        mv.setViewName("sedes/index");
        return mv;
    }

    @RequestMapping(value = { "/criar" }, method = RequestMethod.GET)
    public ModelAndView carregaForm() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sedes/criar");
        return mv;
    }

    @RequestMapping(value = { "/criar" }, method = RequestMethod.POST)
    public ModelAndView recebeForm(Sede sede) {
        repositorySede.save(sede);
        ModelAndView mv = new ModelAndView();
        List<Sede> sedes = repositorySede.findAll();
        mv.addObject("sedes", sedes);
        mv.setViewName("sedes/index");
        return mv;
    }

    @RequestMapping(value = { "/editar" }, method = RequestMethod.GET)
    public ModelAndView carregaEditar(@RequestParam(value = "id", required = true) Long id) {
        Sede sede = repositorySede.getOne(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("sede", sede);
        mv.setViewName("sedes/editar");
        return mv;
    }

    @RequestMapping(value = { "/editar" }, method = RequestMethod.POST)
    public ModelAndView recebeEditar(@RequestParam(value = "id", required = true) Long id, Sede sede) {
        sede.setId(id);
        repositorySede.save(sede);
        ModelAndView mv = new ModelAndView();
        List<Sede> sedes = repositorySede.findAll();
        mv.addObject("sedes", sedes);
        mv.setViewName("sedes/index");
        return mv;
    }

    @RequestMapping(value = { "/detalhes" }, method = RequestMethod.GET)
    public ModelAndView carregaDetalhes(@RequestParam(value = "id", required = true) String id) {
        long id2 = Long.valueOf(id).longValue();
        Sede sede = repositorySede.getOne(id2);
        ModelAndView mv = new ModelAndView();
        mv.addObject("sede", sede);
        mv.setViewName("sedes/detalhes");
        return mv;
    }

    @RequestMapping(value = { "/detalhes/{tipoInfoSede}/{id}" }, method = RequestMethod.GET)
    public @ResponseBody List getInfoSede(@PathVariable("tipoInfoSede") String tipoInfoSede,
            @PathVariable("id") Long id) {
        if (tipoInfoSede.equals("atividades")) {
            List<Atividade> atividadesFinais = new ArrayList<>();
            List<Atividade> atividades = repositoryAtividade.findAll();
            for (Atividade atv : atividades) {
                if (atv.getSede().getId().equals(id)) {
                    atividadesFinais.add(atv);
                }
            }
            return atividadesFinais;
        } else {
            List<Membro> membrosFinais = new ArrayList<>();
            List<Membro> membros = repositoryMembro.findAll();
            for (Membro membro : membros) {
                if (membro.getSede().getId() == id) {
                    membrosFinais.add(membro);
                }
            }
            return membrosFinais;
        }
    }

    @RequestMapping(value = { "/detalhescategoria/{id}" }, method = RequestMethod.GET)
    public @ResponseBody List getInfoTabelaCategoria(@PathVariable("id") Long id) {
        List<Categoria> categorias = new ArrayList<>();
        Categoria categoria1 = new Categoria("Assistencial", 0.0, 0);
        Categoria categoria2 = new Categoria("Jurídica", 0.0, 0);
        Categoria categoria3 = new Categoria("Financeira", 0.0, 0);
        Categoria categoria4 = new Categoria("Executiva", 0.0, 0);
        categorias.add(categoria1);
        categorias.add(categoria2);
        categorias.add(categoria3);
        categorias.add(categoria4);
        List<Atividade> atividades = repositoryAtividade.findAll();
        for (Atividade atv : atividades) {
            if (atv.getSede().getId().equals(id)) {
                if (atv.getCategoria().equals("Assistencial")) {
                    Double valorAtual = categorias.get(0).getHoras();
                    valorAtual += atv.getHorasDeAtividade();
                    categorias.get(0).setHoras(valorAtual);
                    Integer numAtividades = categorias.get(0).getNumeroDeAtividades();
                    numAtividades += 1;
                    categorias.get(0).setNumeroDeAtividades(numAtividades);
                } else if (atv.getCategoria().equals("Jurídica")) {
                    Double valorAtual = categorias.get(1).getHoras();
                    valorAtual += atv.getHorasDeAtividade();
                    categorias.get(1).setHoras(valorAtual);
                    Integer numAtividades = categorias.get(1).getNumeroDeAtividades();
                    numAtividades += 1;
                    categorias.get(0).setNumeroDeAtividades(numAtividades);
                } else if (atv.getCategoria().equals("Financeira")) {
                    Double valorAtual = categorias.get(2).getHoras();
                    valorAtual += atv.getHorasDeAtividade();
                    categorias.get(2).setHoras(valorAtual);
                    Integer numAtividades = categorias.get(2).getNumeroDeAtividades();
                    numAtividades += 1;
                    categorias.get(0).setNumeroDeAtividades(numAtividades);
                } else {
                    Double valorAtual = categorias.get(3).getHoras();
                    valorAtual += atv.getHorasDeAtividade();
                    categorias.get(3).setHoras(valorAtual);
                    Integer numAtividades = categorias.get(3).getNumeroDeAtividades();
                    numAtividades += 1;
                    categorias.get(0).setNumeroDeAtividades(numAtividades);
                }
            }
        }
        return categorias;
    }

    @RequestMapping(value = { "/excluir" }, method = RequestMethod.GET)
    public ModelAndView carregaExcluir(@RequestParam(value = "id", required = true) Long id) {
        repositorySede.deleteById(id);
        ModelAndView mv = new ModelAndView();
        List<Sede> sedes = repositorySede.findAll();
        mv.addObject("sedes", sedes);
        mv.setViewName("sedes/index");
        return mv;
    }
}