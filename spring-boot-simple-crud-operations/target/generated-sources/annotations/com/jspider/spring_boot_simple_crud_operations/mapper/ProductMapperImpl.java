package com.jspider.spring_boot_simple_crud_operations.mapper;

import com.jspider.spring_boot_simple_crud_operations.dto.ProductRequestDTO;
import com.jspider.spring_boot_simple_crud_operations.dto.ProductResponceDTO;
import com.jspider.spring_boot_simple_crud_operations.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-27T00:33:06+0530",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toproduct(ProductRequestDTO productRequestDTO) {
        if ( productRequestDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setCategory( productRequestDTO.category() );
        product.setDescription( productRequestDTO.description() );
        product.setId( productRequestDTO.id() );
        product.setManufactureDate( productRequestDTO.manufactureDate() );
        product.setName( productRequestDTO.name() );
        product.setPrice( productRequestDTO.price() );

        return product;
    }

    @Override
    public ProductResponceDTO toProductResponceDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        Integer id = null;
        String name = null;
        double price = 0.0d;
        String description = null;
        String category = null;

        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        description = product.getDescription();
        category = product.getCategory();

        ProductResponceDTO productResponceDTO = new ProductResponceDTO( id, name, price, description, category );

        return productResponceDTO;
    }

    @Override
    public List<Product> toProducts(List<ProductRequestDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( dtos.size() );
        for ( ProductRequestDTO productRequestDTO : dtos ) {
            list.add( toproduct( productRequestDTO ) );
        }

        return list;
    }

    @Override
    public List<ProductResponceDTO> toProductResponceDTOs(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductResponceDTO> list = new ArrayList<ProductResponceDTO>( products.size() );
        for ( Product product : products ) {
            list.add( toProductResponceDTO( product ) );
        }

        return list;
    }
}
