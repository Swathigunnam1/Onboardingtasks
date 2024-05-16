package com.tasks.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.tasks.bo.UserBO;
import com.tasks.entity.User;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface UserMapper {
	
	 UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	 
@Mappings({
	@Mapping(target="id", ignore=true),
	 @Mapping(target="creationDate", ignore=true)})
	 User toEntity(UserBO userBO);

	 UserBO toBO(User user);
	 

}
