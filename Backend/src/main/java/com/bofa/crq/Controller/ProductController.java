package com.bofa.crq.Controller;



import com.bofa.crq.Controller.req_res_model.ProductModel;
import com.bofa.crq.Entity.Product;
import com.bofa.crq.Service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/products")
@Api(tags = "API for Products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private Environment environment;

    @GetMapping("/getAllProducts")
    public List<ProductModel> getAllProducts(){
        return productService.getAllProduct();
    }

    @PostMapping(value= "/saveProducts",produces = "application/json")
    public Product saveProduct(@RequestBody ProductModel product){
        return productService.saveProduct(product);
    }
    @PutMapping(value="/updateProduct/{crq}",produces = "application/json")
    public Product updateProduct(@PathVariable String crq, @RequestBody ProductModel productModel){
        return productService.updateProduct(crq,productModel);
    }

    @DeleteMapping(value = "/deleteProduct")
    public ResponseEntity<String> deleteCustomer(@RequestParam String crq) throws Exception {
        productService.deleteProduct(crq);
        String successMessage = environment.getProperty("API.DELETE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }
}
