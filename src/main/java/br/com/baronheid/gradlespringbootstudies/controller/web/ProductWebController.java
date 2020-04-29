package br.com.baronheid.gradlespringbootstudies.controller.web;

import br.com.baronheid.gradlespringbootstudies.model.entity.Product;
import br.com.baronheid.gradlespringbootstudies.model.service.CategoryWebService;
import br.com.baronheid.gradlespringbootstudies.model.service.ProductWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/product/")
public class ProductWebController {

    private final ProductWebService productWebService;

    private final CategoryWebService categoryWebService;

    public ProductWebController(@Autowired final ProductWebService productWebService,
                                @Autowired final CategoryWebService categoryWebService) {
        this.productWebService = productWebService;
        this.categoryWebService = categoryWebService;
    }

    @GetMapping("register")
    public String openForm(Product product, Model model) {
        model.addAttribute("categories", categoryWebService.findAll());
        return "product/form";
    }

    @PostMapping("register")
    public String processForm(@Valid Product product,
                              BindingResult result,
                              RedirectAttributes redirectAttributes) {
        if (!result.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", "Registered!");
            productWebService.save(product);
            return "redirect::listar";
        } else return "product/form";
    }

    @GetMapping("list")
    public String listProducts(Model model) {
        model.addAttribute("products", productWebService.findAll());
        return "product/list";
    }

    @GetMapping("edit/{id}")
    public String editProduct(@PathVariable("id") int idCode, Model model) {
        model.addAttribute("product", productWebService.findById(idCode));
        return "product/form";
    }

    @PostMapping("delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteProduct(int id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", "Removed!");
        productWebService.deleteById(id);
        return "redirect::list";
    }
}
