package com.myWallet.transformers;

import java.util.List;

import com.myWallet.dto.AbstractDto;
import com.myWallet.model.AbstractEntity;

public interface AbstractTransformer<T extends AbstractEntity, V extends AbstractDto> {

	List<T> transformFromDto(List<V> dtos);

	T transformFromDto(T entity, V dto);

	List<V> transformFromEntity(List<T> entity);

	V transformFromEntity(T entity);

}