package com.bofa.crq.Service;

import com.bofa.crq.Controller.req_res_model.ProductModel;
import com.bofa.crq.Entity.Product;
import com.bofa.crq.Repository.ProductRepository;
import com.bofa.crq.exception.ProductNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Environment environment;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductModel> getAllProduct(){
        List<Product> productList = this.productRepository.findAll();
        List<ProductModel> productModel = productList.stream()
                                            .map(product -> modelMapper.map(product, ProductModel.class))
                                            .collect(Collectors.toList());
        return productModel;
    }
    public Product saveProduct(ProductModel productModel){
        Product product = modelMapper.map(productModel, Product.class);
        return this.productRepository.save(product);
    }
    public Product updateProduct(String crq, ProductModel product) {
        Optional<Product> existingProduct = productRepository.findById(crq);
        if (existingProduct.isPresent()) {
            Product updatingProduct = existingProduct.get();
            updatingProduct.setRating(product.getRating());
            return this.productRepository.save(updatingProduct);
        } else {
            throw new ProductNotFoundException(environment.getProperty("Service.PRODUCT_NOT_FOUND"));
        }
    }

    public void deleteProduct(String crq) {
        Optional<Product> existingProduct = productRepository.findById(crq);
        if (existingProduct.isPresent()) {
            Product productToBeDeleted = existingProduct.get();
            this.productRepository.delete(productToBeDeleted);
        } else {
            throw new ProductNotFoundException(environment.getProperty("Service.PRODUCT_NOT_FOUND"));
        }
    }
}
