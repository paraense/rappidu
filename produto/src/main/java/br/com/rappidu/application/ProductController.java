package br.com.rappidu.application;

import br.com.rappidu.application.dto.request.ProductRequest;
import br.com.rappidu.application.dto.responses.ProductResponse;
import br.com.rappidu.application.dto.responses.ProductType;
import br.com.rappidu.domain.mappers.ProductMapper;
import br.com.rappidu.domain.models.Product;
import br.com.rappidu.domain.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@ComponentScan(
        basePackages = "br.com.rappidu.domain.services",
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = ProductService.class
        )
)
public class ProductController {

    private final ProductMapper mapper;
    private final ProductService service;


    @GetMapping
    public ResponseEntity<List<ProductResponse>> listByType(@RequestParam ProductType productType) {
        var x = service.findByType(productType);
        return ResponseEntity.ok(x.stream().map(mapper::toResponse).collect(Collectors.toList()));

    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody ProductRequest productRequest){
        Product product = mapper.toModel(productRequest);
        service.create(product);
        return new ResponseEntity<>("Product Created", HttpStatus.CREATED);
    }

}
