package exercise.mapper;

import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.model.Product;
import exercise.dto.ProductCreateDTO;

import org.mapstruct.*;
import org.springframework.stereotype.Component;
// BEGIN

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
@Component
public abstract class ProductMapper {

    @Mapping(target = "barcode", source = "vendorCode")
    @Mapping(target = "cost", source = "price")
    @Mapping(target = "name", source = "title")
    public abstract Product map(ProductCreateDTO productDto);

    @Mapping(target = "vendorCode", source = "barcode")
    @Mapping(target = "price", source = "cost")
    @Mapping(target = "title", source = "name")
    public abstract ProductDTO map(Product model);

    @Mapping(target = "cost", source = "price")
    public abstract void update(ProductUpdateDTO productDto, @MappingTarget Product model);
}
// END
