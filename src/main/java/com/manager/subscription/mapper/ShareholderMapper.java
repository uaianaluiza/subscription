package com.manager.subscription.mapper;

import com.manager.subscription.dtos.response.ShareholderResponse;
import com.manager.subscription.models.Shareholder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ShareholderMapper {
    ShareholderMapper INSTANCE = Mappers.getMapper(ShareholderMapper.class);

    ShareholderResponse toShareholderResponse(Shareholder shareholder);



}
