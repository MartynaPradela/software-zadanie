package com.example.tennis.validation;

import com.example.tennis.exception.BusinessException;

public interface AbstractValidator<T> {

	boolean isValid(T t) throws BusinessException;


}
