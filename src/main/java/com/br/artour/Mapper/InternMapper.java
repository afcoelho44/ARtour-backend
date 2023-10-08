package com.br.artour.Mapper;

import java.util.Map;

public interface InternMapper<T, R> {
     T map(R request);
     T mapUpdate(R request, T record);
}
