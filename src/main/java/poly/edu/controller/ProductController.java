package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    private List<Product> items = new ArrayList<>();

    public ProductController() {
        items.addAll(Arrays.asList(
                new Product("A", 1.0),
                new Product("B", 12.0)
        ));
    }

    @GetMapping("/product/form")
    public String form(Model model) {
        model.addAttribute("p2", new Product()); // sản phẩm ban đầu (trống khi load)
        model.addAttribute("items", items);
        return "product/form";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("p2") Product p, Model model) {
        // Thêm sản phẩm vào danh sách
        items.add(p);

        // Hiển thị sản phẩm vừa nhập ở mục "Sản phẩm ban đầu"
        model.addAttribute("p2", p);

        // Hiển thị lại toàn bộ danh sách
        model.addAttribute("items", items);

        return "product/form";
    }
}
