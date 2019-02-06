package es.fesac.noticias.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import es.fesac.noticias.dao.UserRepository;
import es.fesac.noticias.model.Usuario;
import es.fesac.noticias.model.beans.LoginBean;

@Controller
public class UsuarioController {

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private HttpSession httpSession;
	
	@GetMapping(value="/signin")   
	public String mostrarFormularioLogin(Model model) {
		LoginBean v = new LoginBean();
		v.setEmail("fuafua@fesac.es");
		model.addAttribute("userLogin", v);
	 return "login";
  }
  @PostMapping(value="/login")   
  public String validarLogin(@ModelAttribute("userLogin") LoginBean loginBean, Model model) {
	  Usuario u = userRepository.getByEmailAndPassword(loginBean.getEmail(), loginBean.getPassword());		
	  if (u != null) {
		  httpSession.setAttribute("userLoggedIn", u);
		  return "redirect:/";
		  }
		  else {
			  loginBean.setPassword("");
			  model.addAttribute("userLogin", loginBean);
			  model.addAttribute("error", "Error al validar");
			  return "login";
		  }
 }   
  @GetMapping(value=" /logout") 
  public String cerrarSesionLogin() {
	  return "redirect:/";
 }
	
}
